package org.school.exceptions;

public class NoSuchUserException extends Exception {
    public NoSuchUserException() {
        super("用户不存在！");
    }

    public NoSuchUserException(String message) {
        super(message);
    }
}