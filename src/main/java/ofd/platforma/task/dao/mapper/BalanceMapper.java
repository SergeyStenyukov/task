package ofd.platforma.task.dao.mapper;

import ofd.platforma.task.domain.Balance;
import ofd.platforma.task.domain.enums.BalanceType;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;

@Component
public class BalanceMapper implements RowMapper<Balance> {

    @Override
    public Balance mapRow(ResultSet resultSet, int i) throws SQLException {
        Balance balance = new Balance();
        balance.setId(resultSet.getInt("id"));
        balance.setType(BalanceType.valueOf(resultSet.getString("type")));
        balance.setAmount(resultSet.getBigDecimal("amount"));
        balance.setUserId(resultSet.getInt("user_id"));
        balance.setLocalDateTime(resultSet.getObject("created_date", LocalDateTime.class));
        return balance;
    }
}
