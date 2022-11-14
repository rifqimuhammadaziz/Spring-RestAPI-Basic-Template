package com.rifqimuhammadaziz.springtemplate.exception;

import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;

@Slf4j
@Getter
@Setter
public class CommonException extends Exception {

    private final String code;
    private final String name;
    private final String description;

    private HttpStatus httpStatus = HttpStatus.BAD_REQUEST;

    public CommonException(String code, String name, String description) {
        super(String.format("%s : %s | %s", name, code, description));
        log.error(super.getMessage());

        this.code = code;
        this.name = name;
        this.description = description;
    }
}
