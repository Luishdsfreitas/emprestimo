package br.com.dimed.personalloan.repository;

import br.com.dimed.personalloan.model.Emprestimo;
import br.com.dimed.personalloan.model.EstadoEnum;

import java.util.List;

public class EmprestimoFacadeRepository {

    private EmprestimoRepository emprestimoRepository;

    public EmprestimoFacadeRepository() {
        this.emprestimoRepository = EmprestimoRepository.builder().build();
    }

    public List<Emprestimo> getLoans(Integer renda, Integer idade, EstadoEnum local) {
        return emprestimoRepository.simulationQueryLoans(renda, idade, local);
    }
}
