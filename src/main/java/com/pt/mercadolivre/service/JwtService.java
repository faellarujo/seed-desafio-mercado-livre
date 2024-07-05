package com.pt.mercadolivre.service;


import org.springframework.security.core.Authentication;
import org.springframework.security.oauth2.jwt.JwtClaimsSet;
import org.springframework.security.oauth2.jwt.JwtEncoder;
import org.springframework.security.oauth2.jwt.JwtEncoderParameters;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.stream.Collectors;


/**
 * Precisamos do Beans que implementam a regras do jwt.
 * Nesse objeto temos um propriedade chamada "JwtEncoder" que já possui uma implementação pronta no Spring
 * diferente dos projetos antigos que a galera faz tudo na pedreragem
 * Vou apenas utilizar a capacidade do servidor de recurso do OAuth2 para ser capaz de codificar e decodificar um
 * token jwt
 */


@Service
public class JwtService {

    /**
     * Metodo que gera um token apartir de um objeto que reprecsenta uma autenticação
     * Apartir dessa autenticação vamos gerar um token
     *
     * Muito mais simples do que JwtUtils que encontramos por ai
     */

    private final JwtEncoder encoder;

    public JwtService(JwtEncoder encoder) {
        this.encoder = encoder;    }


    public String generateToken(Authentication authentication) {

        Instant now = Instant.now();
        long expiry = now.getEpochSecond() + 3600;

        /**
         * scopes apenas para pegar os papeis e colocar dentro do token
         * Serve normalmente para um SPA que precisa pegar as informações de érmissão desse usuario
         */

        String scopes = authentication.getAuthorities().stream()
                .map(grantedAuthority -> grantedAuthority.getAuthority())
                .collect(Collectors.joining(" "));

        /**
         * As Claims são as informações de propriedade desse token
         * UserDatails possue poucas informações, mas podemos adicionar mais informações
         * atraves da Claims
         */

        JwtClaimsSet claims = JwtClaimsSet.builder()
                .issuer("spring-security-jwt") // provider desse projeto
                .issuedAt(now) // data de emissão
                .expiresAt(now.plusSeconds(expiry)) // data de expiração
                .subject(authentication.getName()) // quem é o dono desse token normalmente o usuario
                .claim("scope", scopes) // papeis do usuario
                .build();

        /**
         * Aqui retornamos o token codificado apartir das claims
         */

        return encoder.encode(JwtEncoderParameters.from(claims)).getTokenValue();
    }
}



