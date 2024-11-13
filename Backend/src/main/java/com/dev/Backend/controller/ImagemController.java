package com.dev.Backend.controller;

import com.dev.Backend.model.Categoria;
import com.dev.Backend.model.imagem;
import com.dev.Backend.service.ImagemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequestMapping("/api/imagem")
public class ImagemController {

    @Autowired
    ImagemService imagemService;

    @GetMapping("/buscarImagens")
    public List<imagem> BuscarTodas() {
        return imagemService.buscarTodas();
    }

    @PostMapping("/InserirImagens")
    public imagem adicionar(@RequestParam("producto_id") Long productoId,@RequestParam("file") MultipartFile file){
        return imagemService.inserir(productoId, file);
    }

    @PutMapping("/actualizar")
    public imagem AlterarCategoria(@RequestBody imagem objecto) {
        return imagemService.alterar(objecto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> ApagarImagem(@PathVariable("id") Long id ){
        imagemService.Excluir(id);
        return ResponseEntity.ok().build();
    }
}

