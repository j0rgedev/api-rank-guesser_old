package com.george.apirankguesser.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class CustomExceptionDTO {
    private int status;
    private String message;
}
