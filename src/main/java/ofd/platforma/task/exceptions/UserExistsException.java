package ofd.platforma.task.exceptions;

public class UserExistsException extends AbstractDaoException {

    public UserExistsException(String message, int responseCode) {
        super(message, responseCode);
    }
}
