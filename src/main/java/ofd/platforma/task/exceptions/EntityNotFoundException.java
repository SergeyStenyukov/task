package ofd.platforma.task.exceptions;

public class EntityNotFoundException extends AbstractDaoException {

    public EntityNotFoundException(String message, int responseCode) {
        super(message, responseCode);
    }
}
