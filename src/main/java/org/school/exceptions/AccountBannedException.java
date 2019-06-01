package org.school.exceptions;

public class AccountBannedException extends Exception {
    public AccountBannedException() {
        super("账户已被禁用！");
    }

    public AccountBannedException(String message) {
        super(message);
    }
}