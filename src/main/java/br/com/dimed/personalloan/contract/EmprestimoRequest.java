package br.com.dimed.personalloan.contract;

import br.com.dimed.personalloan.model.EstadoEnum;
import lombok.Builder;
import lombok.Data;
import org.hibernate.validator.constraints.br.CPF;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
@Builder
public class EmprestimoRequest {

    @NotBlank(message = "Campo nome inválido")
    private String nome;
    @NotBlank
    @CPF(message = "Campo CPF inválido")
    private String cpf;
    @NotNull (message = "Campo idade invalida")
    @Min(18)
    private Integer idade;
    @NotNull(message = "Campo local invalida")
    private EstadoEnum local;
    @NotNull(message = "Campo renda invalida")
    @Min(500)
    private Integer renda;

}