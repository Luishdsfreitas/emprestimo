package br.com.dimed.personalloan.exception;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class FieldMessage {

    private String fieldName;
    private String name;

}
