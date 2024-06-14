package com.pt.mercadolivre.globalExceptionHandler;

import com.pt.mercadolivre.exception.senhaVazia;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class CustomValidationExceptionHandler { 

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResponseEntity<Map<String, String>> handleValidationExceptions(MethodArgumentNotValidException ex) {
        Map<String, String> errors = new HashMap<>(); //1
        ex.getBindingResult().getFieldErrors().forEach(error -> errors.put(error.getField(), error.getDefaultMessage()));
        return ResponseEntity.badRequest().body(errors);
    }

    @ExceptionHandler(senhaVazia.class)
    public ResponseEntity<String> senhaVazia(senhaVazia ex) {
        return ResponseEntity.status(400).body(ex.getMessage());
    }

//    @ExceptionHandler(EmailExistsException.class)//1
//    public ResponseEntity<String> emailExistsException(EmailExistsException ex) {
//        return ResponseEntity.status(400).body(ex.getMessage());
//    }
//
//    @ExceptionHandler(CategoriaExisteException.class)//1
//    public ResponseEntity<String> categoriaExistsException(CategoriaExisteException ex) {
//        return ResponseEntity.status(400).body(ex.getMessage());
//    }
//
//
//    @ExceptionHandler(LivroExistException.class)//1
//    public ResponseEntity<String> livroExistsException(LivroExistException ex) {
//        return ResponseEntity.status(400).body(ex.getMessage());
//    }
//
//
//    @ExceptionHandler(DocumentoInvalido.class)//1
//    public ResponseEntity<String> DocumentoInvalido(LivroExistException ex) {
//        return ResponseEntity.status(400).body(ex.getMessage());
//    }
//
//
//    @ExceptionHandler(EstadoExistsException.class)//1
//    public ResponseEntity<String> EstadoDeSerInformado(EstadoExistsException ex) {
//        return ResponseEntity.status(400).body(ex.getMessage());
//    }
//
//    @ExceptionHandler(CarrinhoSemItens.class)//1
//    public ResponseEntity<String> CarrinhoSemItens(CarrinhoSemItens ex) {
//        return ResponseEntity.status(400).body(ex.getMessage());
//    }
//
//    @ExceptionHandler(valorTotalDoCarrinhoNaoConfereComValorTotaldaCompra.class)//1
//    public ResponseEntity<String> valorTotalDoCarrinhoNaoConfereComValorTotaldaCompra(valorTotalDoCarrinhoNaoConfereComValorTotaldaCompra ex) {
//        return ResponseEntity.status(400).body(ex.getMessage());
//    }
//
//
//    @ExceptionHandler(ValorIncorretoException.class)//1
//    public ResponseEntity<String> IllegalStateException(ValorIncorretoException ex) {
//        return ResponseEntity.status(400).body(ex.getMessage());
//    }
//
//    @ExceptionHandler(CupomExisteException.class)//1
//    public ResponseEntity<String> IllegalStateException(CupomExisteException ex) {
//        return ResponseEntity.status(400).body(ex.getMessage());
//    }
//
//    @ExceptionHandler(CupomDataException.class)//1
//    public ResponseEntity<String> IllegalStateException(CupomDataException ex) {
//        return ResponseEntity.status(400).body(ex.getMessage());
//    }
//
//    @ExceptionHandler(CupomInativoException.class)//1
//    public ResponseEntity<String> IllegalStateException(CupomInativoException ex) {
//        return ResponseEntity.status(400).body(ex.getMessage());
//    }
//







}
