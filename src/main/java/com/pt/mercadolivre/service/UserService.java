package com.pt.mercadolivre.service;

import com.pt.mercadolivre.exception.EmailExistsException;
import com.pt.mercadolivre.model.Usuario;
import com.pt.mercadolivre.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    public void validaUsuarioLogin(String login){
        final Optional<Usuario> byLogin = usuarioRepository.findByLogin(login);
        if(byLogin.isPresent()){
            throw new EmailExistsException("Usuário já cadastrado");
        }
    }

}
