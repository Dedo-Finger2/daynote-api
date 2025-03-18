package com.github.dedo_finger2.daynote.Response;

import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

@Getter
@NoArgsConstructor
public class ResponseInternalServerError {
    final private HttpStatus status = HttpStatus.INTERNAL_SERVER_ERROR;
    final private String message = "internal server error";
}
