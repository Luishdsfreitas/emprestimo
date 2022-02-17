package br.com.dimed.personalloan.contract;

import br.com.dimed.personalloan.constants.Constantes;
import br.com.dimed.personalloan.model.Emprestimo;
import br.com.dimed.personalloan.model.TipoEmprestimoEnum;
import org.junit.Assert;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

class EmprestimoResponseTest {

    private List<Emprestimo> emprestimosList = new ArrayList<>();

    private EmprestimoResponse emprestimoResponse = EmprestimoResponse.builder()
            .nome("Luis")
            .emprestimos(emprestimosList)
            .build();

    @Test
    void EmprestimoResponseBuilderTest() {
        Assert.assertNotNull(emprestimoResponse);
    }

    @Test
    void EmprestimoResponseGetAndSetNomeTest() {
        emprestimoResponse.setNome("Henrique");
        Assert.assertEquals("Henrique", emprestimoResponse.getNome());
    }

    @Test
    void EmprestimoResponseGetAndSetEmprestimosTest() {
        emprestimosList.add(Emprestimo.builder()
                .tipo(TipoEmprestimoEnum.PESSOAL)
                .imposto(Constantes.EMPRESTIMO_PESSOAL)
                .build());

        emprestimoResponse.setEmprestimos(emprestimosList);
        Assert.assertTrue(emprestimoResponse.getEmprestimos().size() > 0);
    }

    @Test
    void EmprestimoResponseHashcodeTest() {
        Assert.assertNotEquals(emprestimoResponse.hashCode(), EmprestimoResponse.builder()
                .nome("Luis")
                .emprestimos(emprestimosList)
                .build());
    }

    @Test
    void EmprestimoResponseToStringTest() {
        Assert.assertNotNull(emprestimoResponse.toString());
    }

}
