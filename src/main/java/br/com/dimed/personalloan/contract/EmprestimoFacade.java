package br.com.dimed.personalloan.contract;

import br.com.dimed.personalloan.implem.EmprestimoFacadeService;

public class EmprestimoFacade {

    private EmprestimoFacadeService facade;

    public EmprestimoFacade (){
        this.facade = new EmprestimoFacadeService();
    }

    public EmprestimoResponse getTypesLoanAvailable(EmprestimoRequest obj) {

        return EmprestimoResponse.builder()
                .nome(obj.getNome())
                .emprestimos(facade.getLoansAvailableByAgeAndIncome(obj)).build();
    }

}
