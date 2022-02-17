package br.com.dimed.personalloan.contract;

import br.com.dimed.personalloan.model.Emprestimo;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class EmprestimoResponse {

    private String nome;
    private List<Emprestimo> emprestimos;

}
