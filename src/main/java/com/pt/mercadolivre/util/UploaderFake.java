package com.pt.mercadolivre.util;

import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Set;
import java.util.UUID;
import java.util.stream.Collectors;

@Component
public class UploaderFake {
    public static Set<String> envia(List<MultipartFile> imagem) {
        return imagem.stream()
                .map(im -> "http://bucket.io/" + im.getOriginalFilename())
                .collect(Collectors.toSet());
    }
}
