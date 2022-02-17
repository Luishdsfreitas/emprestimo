package br.com.dimed.personalloan.model;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

class TipoEmprestimoEnumTest {

    @Test
    void testCodeTipoEmprestimoEnumTest() {
        Assert.assertEquals(2, TipoEmprestimoEnum.GARANTIDO.getCode().intValue());
    }

}
