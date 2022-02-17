package br.com.dimed.personalloan.implem;

import br.com.dimed.personalloan.contract.EmprestimoRequest;
import br.com.dimed.personalloan.model.Emprestimo;

import java.util.List;

public class EmprestimoFacadeService {

    private EmprestimoService emprestimoService;

    public EmprestimoFacadeService() {
        this.emprestimoService = new EmprestimoService();
    }

    public List<Emprestimo> getLoansAvailableByAgeAndIncome(EmprestimoRequest obj) {

        return emprestimoService.getLoans(obj.getRenda(), obj.getIdade(), obj.getLocal());

    }




}
