package br.com.dimed.personalloan.contract;

import br.com.dimed.personalloan.constants.Constantes;
import br.com.dimed.personalloan.model.Emprestimo;
import br.com.dimed.personalloan.model.EstadoEnum;
import br.com.dimed.personalloan.model.TipoEmprestimoEnum;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(EmprestimoController.class)
class EmprestimoControllerTest {

    @Autowired
    private MockMvc mockMvc;

    private EmprestimoFacade facadeMock = mock(EmprestimoFacade.class);

    private ObjectMapper mapper = new ObjectMapper();

    @Test
    void getLoansTest() throws Exception {

        List<Emprestimo> list = new ArrayList<>();

        list.add(Emprestimo.builder()
                .tipo(TipoEmprestimoEnum.CONSIGNADO)
                .imposto(Constantes.EMPRESTIMO_GARANTIDO)
                .build());

        EmprestimoRequest emprestimoRequest = EmprestimoRequest.builder().nome("as").cpf("02820116094").idade(21).local(EstadoEnum.SP).renda(1000).build();

        when(facadeMock.getTypesLoanAvailable(emprestimoRequest)).thenReturn(EmprestimoResponse.builder().nome("as").emprestimos(list).build());

        String json = mapper.writeValueAsString(emprestimoRequest);

        MvcResult result = mockMvc.perform(get("/emprestimo")
                .contentType(MediaType.APPLICATION_JSON)
                .content(json)
        ).andExpect(status().isOk()).andReturn();

        Assert.assertEquals(HttpStatus.OK.value(), result.getResponse().getStatus());
        Assert.assertTrue(result.getResponse().getContentAsString().contains("GARANTIDO"));

    }

}


