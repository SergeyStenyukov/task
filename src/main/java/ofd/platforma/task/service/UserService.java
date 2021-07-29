package ofd.platforma.task.service;

import ofd.platforma.task.dao.BalanceDao;
import ofd.platforma.task.dao.UserDao;
import ofd.platforma.task.domain.Balance;
import ofd.platforma.task.domain.User;
import ofd.platforma.task.domain.enums.BalanceType;
import ofd.platforma.task.exceptions.UserExistsException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.Collections;
import java.util.List;

@Service
public class UserService {

    private final UserDao userDao;

    private final BalanceDao balanceDao;

    public UserService(UserDao userDao, BalanceDao balanceDao) {
        this.userDao = userDao;
        this.balanceDao = balanceDao;
    }

    @Transactional
    public User save(User user) {
        boolean isLoginExists = userDao.isUserWithLoginExists(user.getLogin());
        if (!isLoginExists) {
            User savedUser = userDao.save(user);
            createDefaultBalanceAndSetToUser(savedUser);
            return savedUser;
        } else throw new UserExistsException("User with login " + user.getLogin() + " already exists");
    }

    public User findById(int id) {
        return userDao.findById(id);
    }

    public List<User> findAll() {
        return userDao.findAll();
    }

    public User findByLogin(String login) {
        return userDao.findByLogin(login);
    }

    public Balance saveBalance(String login, Balance balance) throws DataIntegrityViolationException {
        User user = findByLogin(login);
        balance.setUserId(user.getId());
        return balanceDao.save(balance);
    }

    private void createDefaultBalanceAndSetToUser(User user) {
        Balance balance = new Balance();
        balance.setType(BalanceType.FREE);
        balance.setAmount(new BigDecimal(0));
        balance.setUserId(user.getId());
        Balance savedBalance = balanceDao.save(balance);
        user.setBalances(Collections.singletonList(savedBalance));
    }
}
