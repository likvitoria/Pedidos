package br.com.ufsm.pedidoService.pedidoservice.exceptionHandler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.io.IOException;

@RestControllerAdvice
public class PedidosExceptionHandler {

    @ExceptionHandler(Exception.class)
    public ResponseEntity<String> handleException() throws IOException {
        return new ResponseEntity<String>("Alguma coisa deu errado", HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
