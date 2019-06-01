package org.school.exceptions;

public class UserExistsException extends Exception{
    public UserExistsException() {
        super("账户已存在！");
    }

    public UserExistsException(String message) {
        super(message);
    }
}
