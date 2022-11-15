package com.br.vr.transaction.exception;

import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class ExceptionResponse implements Serializable {


    private static final long serialVersionUID = 1L;

    @DateTimeFormat(pattern = "yyyy/MM/dd")
    private Date timestamp;

    private String message;

    private String details;
}
