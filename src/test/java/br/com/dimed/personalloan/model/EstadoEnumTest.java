package br.com.dimed.personalloan.model;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

class EstadoEnumTest {

    @Test
    void testCodeEstadoEnumTest() {
        Assert.assertEquals(21, EstadoEnum.RS.getCode().intValue());
    }

}
