package com.github.dedo_finger2.daynote.Response;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.http.HttpStatus;

@Getter
@Setter
@NoArgsConstructor
public class BaseResponse {
    private HttpStatus status;
    private String message;
}
