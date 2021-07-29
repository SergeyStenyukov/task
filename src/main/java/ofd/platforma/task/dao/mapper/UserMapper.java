package ofd.platforma.task.dao.mapper;

import ofd.platforma.task.dao.BalanceDao;
import ofd.platforma.task.domain.User;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;

@Component
public class UserMapper implements RowMapper<User> {

    private final BalanceDao balanceDao;

    public UserMapper(BalanceDao balanceDao) {
        this.balanceDao = balanceDao;
    }

    @Override
    public User mapRow(ResultSet rs, int rowNum) throws SQLException {
        User user = new User();
        user.setId(rs.getInt("id"));
        user.setLogin(rs.getString("login"));
        user.setPassword(rs.getString("password"));
        user.setBalances(balanceDao.getBalancesByUserId(rs.getInt("id")));
        return user;
    }
}
