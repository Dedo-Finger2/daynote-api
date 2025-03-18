package com.github.dedo_finger2.daynote.Response;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.http.HttpStatus;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class ResponseCollection<T> {
    private HttpStatus status;
    private String message;
    private List<T> data;
}
