package by.shershen.service.exceptions;

import org.springframework.dao.DataAccessException;

public class InternalServerErrorException extends DataAccessException {

    public InternalServerErrorException(String msg) {
        super("Server error. PLease contact the administrator");
    }
}
