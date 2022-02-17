package br.com.dimed.personalloan.model;

import lombok.Getter;

@Getter
public enum TipoEmprestimoEnum {

    PESSOAL (1), GARANTIDO (2), CONSIGNADO (3);

    private Integer code;

    private TipoEmprestimoEnum(Integer code){
        this.code = code;
    }


}
