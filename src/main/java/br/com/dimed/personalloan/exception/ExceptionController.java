package br.com.dimed.personalloan.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletRequest;
import javax.validation.UnexpectedTypeException;

@ControllerAdvice
public class ExceptionController {

    @ExceptionHandler(HttpMessageNotReadableException.class)
    public ResponseEntity<StandardError> badRequest (HttpMessageNotReadableException e, HttpServletRequest request){

        StandardError error = StandardError.builder()
                .error(HttpStatus.BAD_REQUEST.value())
                .message(e.getMessage())
                .timeStamp(System.currentTimeMillis()).build();

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error);

    }

    @ExceptionHandler(UnexpectedTypeException.class)
    public ResponseEntity<StandardError> unexpectedTypeException (UnexpectedTypeException e, HttpServletRequest request){

        StandardError error = StandardError.builder()
                .error(HttpStatus.BAD_REQUEST.value())
                .message(e.getMessage())
                .timeStamp(System.currentTimeMillis()).build();

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error);

    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<StandardError> methodArgumentNotValidException (MethodArgumentNotValidException e, HttpServletRequest request){

        ValidationError error = new ValidationError(HttpStatus.BAD_REQUEST.value(),
                                                    "Erro de validação",
                                                    System.currentTimeMillis());

        for (FieldError x : e.getBindingResult().getFieldErrors()) {
            error.addError(x.getField(), x.getDefaultMessage());
        }

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error);

    }

}
