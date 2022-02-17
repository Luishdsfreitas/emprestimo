package br.com.dimed.personalloan.repository;

import br.com.dimed.personalloan.model.EstadoEnum;
import org.junit.Assert;
import org.junit.jupiter.api.Test;

class EmprestimoRepositoryTest {

    private EmprestimoRepository emprestimoRepository = EmprestimoRepository.builder().build();

    @Test
    void EmprestimoRepositoryBuilderTest() {
        Assert.assertNotNull(emprestimoRepository);
    }

    @Test
    void EmprestimoRepositoryToStringTest() {
        Assert.assertNotNull(emprestimoRepository.toString());
    }

    @Test
    void EmprestimoRepositoryBuilderToStringTest() {
        Assert.assertNotNull(emprestimoRepository.builder().toString());
    }

    @Test
    void EmprestimoRepositorySimulationQueryLoansTest() {

        Assert.assertNotNull(emprestimoRepository.simulationQueryLoans(3000, 29, EstadoEnum.SP));

        Assert.assertNotNull(emprestimoRepository.simulationQueryLoans(5000, 29, EstadoEnum.SP));

        Assert.assertNotNull(emprestimoRepository.simulationQueryLoans(5000, 30, EstadoEnum.RJ));

        Assert.assertNotNull(emprestimoRepository.simulationQueryLoans(3500, 17, EstadoEnum.SP));

    }

}
