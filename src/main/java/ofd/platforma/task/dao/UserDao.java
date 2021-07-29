package ofd.platforma.task.dao;

import ofd.platforma.task.domain.User;

public interface UserDao extends CrudDao<User, Integer> {

    boolean isUserWithLoginExists(String login);

    User findByLogin(String login);
}
