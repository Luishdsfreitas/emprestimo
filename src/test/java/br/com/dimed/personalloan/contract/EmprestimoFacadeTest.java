package br.com.dimed.personalloan.contract;

import br.com.dimed.personalloan.constants.Constantes;
import br.com.dimed.personalloan.model.EstadoEnum;
import org.junit.Assert;
import org.junit.jupiter.api.Test;

class EmprestimoFacadeTest {

    private EmprestimoFacade facade = new EmprestimoFacade();

    EmprestimoRequest emprestimoRequest = EmprestimoRequest.builder()
            .nome("Luis")
            .cpf("12345678978")
            .idade(Constantes.IDADE_NEGOCIO)
            .local(EstadoEnum.RS)
            .renda(Constantes.BAIXA_RENDA).build();

    @Test
    void EmprestimoFacadeBuilderTest(){

        Assert.assertNotEquals(facade.getTypesLoanAvailable(emprestimoRequest), EmprestimoResponse
                .builder()
                .nome(emprestimoRequest.getNome())
                .emprestimos(null).build());

    }

}
