package br.com.dimed.personalloan.implem;

import br.com.dimed.personalloan.model.Emprestimo;
import br.com.dimed.personalloan.model.EstadoEnum;
import br.com.dimed.personalloan.repository.EmprestimoFacadeRepository;

import java.util.List;

public class EmprestimoService {

    private EmprestimoFacadeRepository facade;

    public EmprestimoService (){
        this.facade = new EmprestimoFacadeRepository();
    }

    public List<Emprestimo> getLoans(Integer renda, Integer idade, EstadoEnum local) {

        return facade.getLoans(renda, idade, local);

    }

}
