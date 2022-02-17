package br.com.dimed.personalloan.model;

import br.com.dimed.personalloan.constants.Constantes;
import org.junit.Assert;
import org.junit.jupiter.api.Test;

class EmprestimoTest {

    private Emprestimo emprestimo = Emprestimo.builder()
            .tipo(TipoEmprestimoEnum.PESSOAL)
            .imposto(Constantes.EMPRESTIMO_PESSOAL)
            .build();

    @Test
    void EmprestimoBuilderTest() {
        Assert.assertNotNull(emprestimo);
    }

    @Test
    void EmprestimoGetAndSetTipoTest() {
        emprestimo.setTipo(TipoEmprestimoEnum.CONSIGNADO);
        Assert.assertEquals(TipoEmprestimoEnum.CONSIGNADO, emprestimo.getTipo());
    }

    @Test
    void EmprestimoGetAndSetImpostoTest() {
        emprestimo.setImposto(Constantes.ALTA_RENDA);
        Assert.assertEquals(Constantes.ALTA_RENDA, emprestimo.getImposto());
    }

    @Test
    void EmprestimoEqualsTest() {

        Assert.assertEquals(Emprestimo.builder()
                .tipo(emprestimo.getTipo())
                .imposto(emprestimo.getImposto())
                .build(), emprestimo);
    }

    @Test
    void EmprestimoToStringTest() {
        Assert.assertNotNull(emprestimo.toString());
    }

    @Test
    void EmprestimoBuilderToStringTest() {
        Assert.assertNotNull(emprestimo.builder().toString());
    }

    @Test
    void EmprestimoHashcodeTest() {
        Assert.assertEquals(Emprestimo.builder()
                .tipo(TipoEmprestimoEnum.PESSOAL)
                .imposto(Constantes.EMPRESTIMO_PESSOAL)
                .build().hashCode(), emprestimo.hashCode());
    }

}
