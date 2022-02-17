package br.com.dimed.personalloan.exception;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class ValidationError extends StandardError {

    private List<FieldMessage> list = new ArrayList<>();

    public ValidationError(Integer error, String message, Long timeStamp) {
        super(error, message, timeStamp);
    }

    public List<FieldMessage> getErrors(){
        return list;
    }

    public void addError(String fieldName, String message){
        list.add(FieldMessage.builder().fieldName(fieldName).name(message).build());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        ValidationError that = (ValidationError) o;
        return Objects.equals(list, that.list);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), list);
    }
}
