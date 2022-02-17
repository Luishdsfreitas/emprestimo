package br.com.dimed.personalloan.contract;

import br.com.dimed.personalloan.constants.Constantes;
import br.com.dimed.personalloan.model.EstadoEnum;
import org.junit.Assert;
import org.junit.jupiter.api.Test;

class EmprestimoRequestTest {

    private EmprestimoRequest emprestimoRequest = EmprestimoRequest.builder()
            .nome("Luis")
            .cpf("12345678978")
            .idade(Constantes.IDADE_NEGOCIO)
            .local(EstadoEnum.RS)
            .renda(Constantes.BAIXA_RENDA).build();


    @Test
    void EmprestimoRequestBuilderTest() {
        Assert.assertNotNull(emprestimoRequest);
    }


    @Test
    void EmprestimoRequestGetAndSetCPFTest() {
        emprestimoRequest.setCpf("11222333541");
        Assert.assertEquals("11222333541", emprestimoRequest.getCpf());
    }

    @Test
    void EmprestimoRequestGetAndSetNomeTest() {
        emprestimoRequest.setNome("Henrique");
        Assert.assertEquals("Henrique", emprestimoRequest.getNome());
    }

    @Test
    void EmprestimoRequestGetAndSetIdadeTest() {
        emprestimoRequest.setIdade(29);
        Assert.assertNotEquals(emprestimoRequest.getIdade(), Constantes.IDADE_NEGOCIO);
    }

    @Test
    void EmprestimoRequestGetAndSetLocalTest() {
        emprestimoRequest.setLocal(EstadoEnum.SP);
        Assert.assertNotEquals(EstadoEnum.RS, emprestimoRequest.getLocal());
    }

    @Test
    void EmprestimoRequestGetAndSetRendaTest() {
        emprestimoRequest.setRenda(Constantes.ALTA_RENDA);
        Assert.assertNotEquals(Constantes.BAIXA_RENDA, emprestimoRequest.getRenda());
    }

    @Test
    void EmprestimoRequestEqualsTest() {

        Assert.assertEquals(EmprestimoRequest.builder()
                .nome(emprestimoRequest.getNome())
                .cpf(emprestimoRequest.getCpf())
                .idade(emprestimoRequest.getIdade())
                .local(emprestimoRequest.getLocal())
                .renda(emprestimoRequest.getRenda())
                .build(), emprestimoRequest);
    }

    @Test
    void EmprestimoRequestToStringTest() {
        Assert.assertNotNull(emprestimoRequest.toString());
    }

    @Test
    void EmprestimoRequestBuilderToStringTest() {
        Assert.assertNotNull(emprestimoRequest.builder().toString());
    }

    @Test
    void EmprestimoRequestHashcodeTest() {
        Assert.assertNotEquals(emprestimoRequest.hashCode(), EmprestimoRequest.builder()
                .nome("Henrique")
                .cpf("12345678978")
                .idade(Constantes.IDADE_NEGOCIO)
                .local(EstadoEnum.RS)
                .renda(Constantes.BAIXA_RENDA).build());
    }

}
