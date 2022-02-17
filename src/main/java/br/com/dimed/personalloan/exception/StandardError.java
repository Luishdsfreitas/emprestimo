package br.com.dimed.personalloan.exception;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class StandardError {

    private Integer error;
    private String message;
    private Long timeStamp;

}
