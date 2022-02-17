import br.com.dimed.personalloan.contract.EmprestimoFacade;
import br.com.dimed.personalloan.contract.EmprestimoRequest;
import br.com.dimed.personalloan.contract.EmprestimoResponse;
import br.com.dimed.personalloan.exception.FieldMessage;
import br.com.dimed.personalloan.exception.StandardError;
import br.com.dimed.personalloan.exception.ValidationError;
import br.com.dimed.personalloan.implem.EmprestimoFacadeService;
import br.com.dimed.personalloan.constants.Constantes;
import br.com.dimed.personalloan.model.Emprestimo;
import br.com.dimed.personalloan.model.EstadoEnum;
import br.com.dimed.personalloan.model.TipoEmprestimoEnum;
import br.com.dimed.personalloan.repository.EmprestimoFacadeRepository;
import br.com.dimed.personalloan.repository.EmprestimoRepository;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

class PersonalLoanApplicationTest {

    EmprestimoFacade facade = new EmprestimoFacade();

    EmprestimoRequest emprestimoRequest = EmprestimoRequest.builder()
            .nome("Luis")
            .cpf("12345678978")
            .idade(Constantes.IDADE_NEGOCIO)
            .local(EstadoEnum.RS)
            .renda(Constantes.BAIXA_RENDA).build();

    @Test
    void EmprestimoFacadeBuilderTest() {

        Assert.assertNotEquals(facade.getTypesLoanAvailable(emprestimoRequest), EmprestimoResponse
                .builder()
                .nome(emprestimoRequest.getNome())
                .emprestimos(null).build());

    }

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

    Emprestimo emprestimo = Emprestimo.builder()
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

    @Test
    void testCodeEstadoEnumTest() {
        Assert.assertEquals(21, EstadoEnum.RS.getCode().intValue());
    }

    @Test
    void testCodeTipoEmprestimoEnumTest() {
        Assert.assertEquals(2, TipoEmprestimoEnum.GARANTIDO.getCode().intValue());
    }

    List<Emprestimo> emprestimosList = new ArrayList<>();

    EmprestimoResponse emprestimoResponse = EmprestimoResponse.builder()
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

    StandardError standardError = StandardError.builder()
            .error(HttpStatus.BAD_REQUEST.value())
            .message("Error BAD_REQUEST")
            .timeStamp(Calendar.getInstance().getTimeInMillis())
            .build();

    @Test
    void StandardErrorBuilderTest() {
        Assert.assertNotNull(standardError);
    }

    @Test
    void StandardErrorSetErrorTest() {
        standardError.setError(HttpStatus.FORBIDDEN.value());
        Assert.assertNotEquals(HttpStatus.BAD_REQUEST.value(), standardError.getError().intValue());
    }

    @Test
    void StandardErrorGetErrorTest() {
        Assert.assertEquals(HttpStatus.BAD_REQUEST.value(), standardError.getError().intValue());
    }

    @Test
    void StandardErrorSetMessageTest() {
        standardError.setMessage("Error Test");
        Assert.assertNotEquals("Error BAD_REQUEST", standardError.getMessage());
    }

    @Test
    void StandardErrorGetMessageTest() {
        Assert.assertEquals("Error BAD_REQUEST", standardError.getMessage());
    }

    @Test
    void StandardErrorSetTimeTest() {
        standardError.setTimeStamp(1L);
        Assert.assertNotEquals(2L, standardError.getTimeStamp().intValue());
    }

    @Test
    void StandardErrorGetTimeTest() {
        Assert.assertNotNull(standardError.getTimeStamp());
    }

    @Test
    void StandardErrorToStringTest() {
        Assert.assertNotNull(standardError.toString());
    }

    @Test
    void StandardBuilderToStringTest() {
        Assert.assertNotNull(standardError.builder().toString());
    }

    @Test
    void StandardErrorEqualsTest() {

        Assert.assertEquals(StandardError.builder()
                .error(standardError.getError())
                .message(standardError.getMessage())
                .timeStamp(standardError.getTimeStamp())
                .build(), standardError);

    }

    @Test
    void StandardErrorHashcodeTest() {
        Assert.assertNotEquals(StandardError.builder()
                .error(1)
                .message("Test")
                .timeStamp(Calendar.getInstance().getTimeInMillis())
                .build(), standardError.hashCode());
    }

    FieldMessage fieldMessage = FieldMessage.builder()
            .name("Test Error")
            .fieldName("ERROR")
            .build();

    @Test
    void FieldMessageBuilderTest() {
        Assert.assertNotNull(fieldMessage);
    }

    @Test
    void FieldMessageSetAndGetNameTest() {
        fieldMessage.setName("Change");
        Assert.assertEquals("Change", fieldMessage.getName());
    }

    @Test
    void FieldMessageSetAndGetFieldNameTest() {
        fieldMessage.setFieldName("Change");
        Assert.assertEquals("Change", fieldMessage.getFieldName());
    }

    @Test
    void FieldMessageToStringTest() {
        Assert.assertNotNull(fieldMessage.toString());
    }

    @Test
    void FieldMessageBuilderToStringTest() {
        Assert.assertNotNull(fieldMessage.builder().toString());
    }

    @Test
    void FieldMessageHashcodeTest() {

        Assert.assertNotEquals(FieldMessage.builder()
                .name(fieldMessage.getName())
                .fieldName(fieldMessage.getFieldName())
                .build(), fieldMessage.hashCode());
    }

    @Test
    void FieldMessageEqualsTest() {

        Assert.assertEquals(FieldMessage.builder()
                .name(fieldMessage.getName())
                .fieldName(fieldMessage.getFieldName())
                .build(), fieldMessage);

    }

    ValidationError validationError = new ValidationError(HttpStatus.BAD_REQUEST.value(),
            "BAD REQUEST", Calendar.getInstance().getTimeInMillis());

    @Test
    void ValidationBuilderTest() {
        Assert.assertNotNull(validationError);
    }

    @Test
    void ValidationErrorSetAndGetErrorTest() {
        validationError.setError(HttpStatus.FORBIDDEN.value());
        Assert.assertNotEquals(HttpStatus.BAD_REQUEST.value(), validationError.getError().intValue());
    }

    @Test
    void ValidationErrorSetAndGetMessageTest() {
        validationError.setMessage("Error Test");
        Assert.assertNotEquals("Error BAD_REQUEST", validationError.getMessage());
    }

    @Test
    void ValidationErrorSetAndGetTimeTest() {
        validationError.setTimeStamp(1L);
        Assert.assertNotEquals(2L, validationError.getTimeStamp().intValue());
    }

    @Test
    void ValidationErrorToStringTest() {
        Assert.assertNotNull(validationError.toString());
    }

    @Test
    void ValidationErrorBuilderToStringTest() {
        Assert.assertNotNull(validationError.builder().toString());
    }

    @Test
    void ValidationErrorSetAndGetErrorsTest() {
        validationError.addError("Test", "Test");
        Assert.assertNotNull(validationError.getErrors());
    }

    @Test
    void ValidationErrorHashcodeTest() {
        Assert.assertNotEquals(ValidationError.builder()
                .error(1)
                .message("Test")
                .timeStamp(Calendar.getInstance().getTimeInMillis())
                .build(), validationError.hashCode());
    }

    @Test
    void ValidationErrorEqualsTest() {

        Assert.assertEquals(new ValidationError(validationError.getError(),
                validationError.getMessage(),
                validationError.getTimeStamp()), validationError);

    }

    EmprestimoFacadeService emprestimoFacadeService = new EmprestimoFacadeService();

    @Test
    void getLoansAvailableByAgeAndIncomeTest() {
        Assert.assertNotNull(emprestimoFacadeService.getLoansAvailableByAgeAndIncome(emprestimoRequest));
    }

    EmprestimoFacadeRepository emprestimoFacadeReposito = new EmprestimoFacadeRepository();

    @Test
    void getLoansTest() {
        Assert.assertNotNull(emprestimoFacadeReposito.getLoans(5000, 39, EstadoEnum.SP));
    }

    EmprestimoRepository emprestimoRepository = EmprestimoRepository.builder().build();

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
