package br.com.dimed.personalloan.exception;

import br.com.dimed.personalloan.exception.StandardError;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;

import java.util.Calendar;

class StandardErrorTest {

    private StandardError standardError = StandardError.builder()
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
    void StandardErrorHashcodeTest() {
        Assert.assertNotEquals(StandardError.builder()
                .error(1)
                .message("Test")
                .timeStamp(Calendar.getInstance().getTimeInMillis())
                .build(), standardError.hashCode());
    }

    @Test
    void StandardErrorEqualsTest() {

        Assert.assertEquals(StandardError.builder()
                .error(standardError.getError())
                .message(standardError.getMessage())
                .timeStamp(standardError.getTimeStamp())
                .build(), standardError);

    }

}



