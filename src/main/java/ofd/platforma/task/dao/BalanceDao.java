package ofd.platforma.task.dao;

import ofd.platforma.task.domain.Balance;

import java.util.List;

public interface BalanceDao extends CrudDao<Balance, Integer> {

    List<Balance> getBalancesByUserId(int userId);
}
