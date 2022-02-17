package br.com.dimed.personalloan.exception;

import br.com.dimed.personalloan.exception.ValidationError;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;

import java.util.Calendar;

class ValidatorErrorTest {

    private ValidationError validationError = new ValidationError(HttpStatus.BAD_REQUEST.value(),
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

}






