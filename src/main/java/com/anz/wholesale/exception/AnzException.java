package com.anz.wholesale.exception;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;

@AllArgsConstructor
@Data
public class AnzException {

    private HttpStatus status;

    private int statusCode;

    private String message;

    private LocalDateTime time;

}
