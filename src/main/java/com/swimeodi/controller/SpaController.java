package com.swimeodi.controller;

import org.springframework.core.io.ClassPathResource;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.io.IOException;

@Controller
public class SpaController {

    @GetMapping(value = { "/", "/{path:[^\\.]*}", "/**/{path:[^\\.]*}" })
    public ResponseEntity<byte[]> spa() throws IOException {
        ClassPathResource resource = new ClassPathResource("static/index.html");
        return ResponseEntity.ok()
                .contentType(MediaType.TEXT_HTML)
                .body(resource.getContentAsByteArray());
    }
}
