package com.company.StudentCourse.exp;

public class PhoneAlreadyExistsException extends RuntimeException {
    public PhoneAlreadyExistsException() {
        super();
    }

    public PhoneAlreadyExistsException(String message) {
        super(message);
    }
}
