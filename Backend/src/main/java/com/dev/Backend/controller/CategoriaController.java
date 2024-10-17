package com.dev.Backend.controller;

import com.dev.Backend.model.Categoria;
import com.dev.Backend.service.CategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/categoria")
public class CategoriaController {

    @Autowired
    private CategoriaService categoriaService;

    @GetMapping("/listar")
    public List<Categoria> BuscarTodasCategorias(){
        return categoriaService.BuscarCategorias();
    }

    @PostMapping("/adicionar")
    public Categoria InserirCategoria(@RequestBody Categoria categoria){
        return categoriaService.AdicionarCategoria(categoria);
    }

    @PutMapping("/actualizar")
    public Categoria AlterarCategoria(@RequestBody Categoria categoria){
        return categoriaService.ActualizarCategoria(categoria);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> ApagarCategoria(@PathVariable("id") Long id ){
        categoriaService.Excluir(id);
        return ResponseEntity.ok().build();
    }
}
