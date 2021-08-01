package ofd.platforma.task.domain.enums;

public enum ResponseCode {

    OK(0),
    USER_ALREADY_EXISTS(1),
    ERROR(2),
    USER_DOESNT_EXIST(4),
    PASSWORD_OR_LOGIN_INCORRECT(5);

    private final int value;

    ResponseCode(final int newValue) {
        value = newValue;
    }

    public int getValue() {
        return value;
    }
}
