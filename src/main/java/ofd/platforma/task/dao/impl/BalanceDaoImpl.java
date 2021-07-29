package ofd.platforma.task.dao.impl;

import ofd.platforma.task.dao.BalanceDao;
import ofd.platforma.task.dao.mapper.BalanceMapper;
import ofd.platforma.task.domain.Balance;
import ofd.platforma.task.domain.enums.BalanceType;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import java.sql.PreparedStatement;
import java.util.List;

@Repository
public class BalanceDaoImpl implements BalanceDao {

    private static final String INSERT_BALANCE_SQl = "INSERT INTO balances (type, amount, user_id) values (?, ?, ?)";

    private static final String SELECT_USER_BALANCES_SQL = "SELECT * FROM balances WHERE user_id = ?";

    private static final String SELECT_USER_BALANCES_FIXED_LAST_FIVE_SQL = "SELECT * FROM balances WHERE user_id = ? AND type = ? ORDER BY created_date DESC LIMIT 5";

    private static final String SELECT_ALL_BALANCES_SQL = "SELECT * FROM balances";

    private final JdbcTemplate jdbcTemplate;

    private final BalanceMapper balanceMapper;

    public BalanceDaoImpl(JdbcTemplate jdbcTemplate, BalanceMapper balanceMapper) {
        this.jdbcTemplate = jdbcTemplate;
        this.balanceMapper = balanceMapper;
    }

    @Override
    public Balance save(Balance balance) throws DataIntegrityViolationException {
        KeyHolder keyHolder = new GeneratedKeyHolder();
        int createdRows = jdbcTemplate.update(con -> {
                    PreparedStatement pst =
                            con.prepareStatement(INSERT_BALANCE_SQl, new String[]{"id"});
                    pst.setString(1, balance.getType().toString());
                    pst.setString(2, balance.getAmount().toString());
                    pst.setInt(3, balance.getUserId());
                    return pst;
                },
                keyHolder);
        balance.setId((int) keyHolder.getKey());
        return balance;
    }

    @Override
    public Balance findById(Integer id) {
        return null;
    }

    @Override
    public List<Balance> findAll() {
        return jdbcTemplate.query(SELECT_ALL_BALANCES_SQL, balanceMapper);
    }

    @Override
    public List<Balance> getBalancesByUserId(int userId) {
        return jdbcTemplate.query(SELECT_USER_BALANCES_FIXED_LAST_FIVE_SQL, balanceMapper, userId, BalanceType.FIXED.toString());
    }
}
