package org.school.exceptions;

public class WrongPasswordException extends Exception {
    public WrongPasswordException() {
        super("密码错误！");
    }

    public WrongPasswordException(String message) {
        super(message);
    }
}
