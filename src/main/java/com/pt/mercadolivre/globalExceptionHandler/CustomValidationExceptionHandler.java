package com.pt.mercadolivre.globalExceptionHandler;

import com.pt.mercadolivre.exception.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
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

    @ExceptionHandler(HttpMessageNotReadableException.class)
    public ResponseEntity<String> handleHttpMessageNotReadableException(HttpMessageNotReadableException ex) {
        // Aqui você pode extrair mais detalhes do erro, se necessário, e personalizar a mensagem de erro
        String errorMessage = "Valores aceitos para a propriedade tamanho Enum class: [P, M, G, GG, XG]";
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(senhaVazia.class)
    public ResponseEntity<String> senhaVazia(senhaVazia ex) {
        return ResponseEntity.status(400).body(ex.getMessage());
    }

    @ExceptionHandler(EmailExistsException.class)//1
    public ResponseEntity<String> emailExistsException(EmailExistsException ex) {
        return ResponseEntity.status(400).body(ex.getMessage());
    }

    @ExceptionHandler(CategoriaExisteException.class)//1
    public ResponseEntity<String> categoriaExistsException(CategoriaExisteException ex) {
        return ResponseEntity.status(400).body(ex.getMessage());
    }

    @ExceptionHandler(ProdutoNotExistException.class)//1
    public ResponseEntity<String> livroExistsException(ProdutoNotExistException ex) {
        return ResponseEntity.status(400).body(ex.getMessage());
    }

    @ExceptionHandler(UserNotPermission.class)//1
    public ResponseEntity<String> UsuarioSemPermissaoParaInserirIMG(UserNotPermission ex) {
        return ResponseEntity.status(403).body(ex.getMessage());
    }


    @ExceptionHandler(Notavaluemustbebetween1and5.class)//1
    public ResponseEntity<String> Notavaluemustbebetween1and5(Notavaluemustbebetween1and5 ex) {
        return ResponseEntity.status(400).body(ex.getMessage());
    }

    @ExceptionHandler(InvalidNotavalue.class)//1
    public ResponseEntity<String> InvalidNotavalue(InvalidNotavalue ex) {
        return ResponseEntity.status(400).body(ex.getMessage());
    }

    @ExceptionHandler(UserNotExistException.class)//1
    public ResponseEntity<String> UsuarioInexistente(UserNotExistException ex) {
        return ResponseEntity.status(400).body(ex.getMessage());
    }


    @ExceptionHandler(QuantidadeInsulficienteException.class)//1
    public ResponseEntity<String> quantidadeInsulficiente(QuantidadeInsulficienteException ex) {
        return ResponseEntity.status(400).body(ex.getMessage());
    }

    @ExceptionHandler(TipoDePagamentoInexistente.class)//1
    public ResponseEntity<String> tipoDePagamentoInexistente(TipoDePagamentoInexistente ex) {
        return ResponseEntity.status(400).body(ex.getMessage());
    }
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
