package br.com.dimed.personalloan.implem;

import br.com.dimed.personalloan.contract.EmprestimoRequest;
import br.com.dimed.personalloan.constants.Constantes;
import br.com.dimed.personalloan.model.EstadoEnum;
import org.junit.Assert;
import org.junit.jupiter.api.Test;

class EmprestimoFacadeServiceTest {

    private EmprestimoFacadeService emprestimoFacadeService = new EmprestimoFacadeService();

    private EmprestimoRequest emprestimoRequest = EmprestimoRequest.builder()
            .nome("Luis Henrique")
            .cpf("12312345678")
            .idade(Constantes.IDADE_NEGOCIO)
            .local(EstadoEnum.RJ)
            .renda(Constantes.ALTA_RENDA)
            .build();

    @Test
    void getLoansAvailableByAgeAndIncomeTest() {
        Assert.assertNotNull(emprestimoFacadeService.getLoansAvailableByAgeAndIncome(emprestimoRequest));
    }
}
