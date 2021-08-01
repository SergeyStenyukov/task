package ofd.platforma.task.dao.impl;

import ofd.platforma.task.dao.UserDao;
import ofd.platforma.task.dao.mapper.UserMapper;
import ofd.platforma.task.domain.User;
import ofd.platforma.task.domain.enums.ResponseCode;
import ofd.platforma.task.exceptions.EntityNotFoundException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import java.sql.PreparedStatement;
import java.util.List;

@Repository
public class UserDaoImpl implements UserDao {

    private static final String INSERT_USER_SQl = "INSERT INTO users (login, password) values (?, ?)";

    private static final String SELECT_USER_SQL = "SELECT * FROM users WHERE id = ?";

    private static final String SELECT_USER_BY_LOGIN_SQL = "SELECT * FROM users WHERE login = ?";

    private static final String SELECT_USER_COUNT_BY_LOGIN_SQL = "SELECT COUNT(*) FROM users WHERE login = ?";

    private static final String SELECT_ALL_USERS_SQL = "SELECT * FROM users";

    private final JdbcTemplate jdbcTemplate;

    private final UserMapper userMapper;

    public UserDaoImpl(JdbcTemplate jdbcTemplate, UserMapper userMapper) {
        this.jdbcTemplate = jdbcTemplate;
        this.userMapper = userMapper;
    }

    @Override
    public User save(User user) {
        KeyHolder keyHolder = new GeneratedKeyHolder();
        int createdRows = jdbcTemplate.update(con -> {
                    PreparedStatement pst =
                            con.prepareStatement(INSERT_USER_SQl, new String[]{"id"});
                    pst.setString(1, user.getLogin());
                    pst.setString(2, user.getPassword());
                    return pst;
                },
                keyHolder);
        user.setId((int) keyHolder.getKey());
        return user;
    }

    @Override
    public User findById(Integer id) {
        try {
            return jdbcTemplate.queryForObject(SELECT_USER_SQL, userMapper, id);
        } catch (EmptyResultDataAccessException e) {
            throw new EntityNotFoundException("Cannot find user with id " + id, ResponseCode.USER_DOESNT_EXIST.getValue());
        }
    }

    @Override
    public List<User> findAll() {
        return jdbcTemplate.query(SELECT_ALL_USERS_SQL, userMapper);
    }

    @Override
    public boolean isUserWithLoginExists(String login) {
        Integer count = jdbcTemplate.queryForObject(SELECT_USER_COUNT_BY_LOGIN_SQL, Integer.class, login);
        return count != null && count > 0;
    }

    @Override
    public User findByLogin(String login) {
        try {
            return jdbcTemplate.queryForObject(SELECT_USER_BY_LOGIN_SQL, userMapper, login);
        } catch (EmptyResultDataAccessException e) {
            throw new EntityNotFoundException("Cannot find user with login " + login, ResponseCode.USER_DOESNT_EXIST.getValue());
        }
    }
}
