package br.edu.ifsp.pep.bcc.estoque.exceptions;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Builder;

import java.time.LocalDateTime;
import java.util.List;

@Builder
public record ApiError (
        @JsonFormat(pattern = "dd-MM-yyyy")
        LocalDateTime timestamp,

        Integer code,
        String status,
        List<String> errors ){

}
