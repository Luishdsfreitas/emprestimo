package br.com.dimed.personalloan.repository;

import br.com.dimed.personalloan.model.EstadoEnum;
import org.junit.Assert;
import org.junit.jupiter.api.Test;

class EmprestimoFacadeTest {

    private EmprestimoFacadeRepository  emprestimoFacadeReposito = new EmprestimoFacadeRepository();

    @Test
    void getLoansTest(){
        Assert.assertNotNull(emprestimoFacadeReposito.getLoans(5000, 39, EstadoEnum.SP));
    }

}
