package ofd.platforma.task.exceptions;

public class AbstractDaoException extends RuntimeException{

    private int responseCode;

    public AbstractDaoException(String message, int responseCode) {
        super(message);
        this.responseCode = responseCode;
    }

    public int getResponseCode() {
        return responseCode;
    }

    public void setResponseCode(int responseCode) {
        this.responseCode = responseCode;
    }
}
