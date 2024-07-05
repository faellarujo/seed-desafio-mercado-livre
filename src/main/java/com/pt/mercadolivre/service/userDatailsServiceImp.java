package com.pt.mercadolivre.service;

import com.pt.mercadolivre.repository.UsuarioRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class userDatailsServiceImp implements UserDetailsService {

    /**
     * Essa chamada é feita pelo spring security automaticamente quando o usuario tenta se autenticar
     * O Spring security chama esse método para verificar se o usuario existe por debaixo dos panos
     * Eu preciso apenas prover a implementação desse método
     */

    private UsuarioRepository usuarioRepository;

    public userDatailsServiceImp(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return usuarioRepository.findByUsername(username)
                .map(UserAuthenticated::new)
                .orElseThrow(() -> new UsernameNotFoundException("Usuario não encontrado"));
    }
}
