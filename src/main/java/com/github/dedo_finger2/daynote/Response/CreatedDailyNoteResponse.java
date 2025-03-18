package com.github.dedo_finger2.daynote.Response;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;

@Getter
@Setter(onParam_ = {@Param("id")})
@NoArgsConstructor
public class CreatedDailyNoteResponse {
    final private HttpStatus status = HttpStatus.CREATED;
    private Long id;
}
