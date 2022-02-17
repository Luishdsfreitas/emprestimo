package br.com.dimed.personalloan.exception;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

class FieldMessageTest {

    private FieldMessage fieldMessage = FieldMessage.builder()
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

}
