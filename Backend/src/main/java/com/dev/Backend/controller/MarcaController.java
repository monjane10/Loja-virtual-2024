package com.dev.Backend.controller;

import com.dev.Backend.model.Marca;
import com.dev.Backend.model.Provincia;
import com.dev.Backend.service.MarcaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/marca")
public class MarcaController {

    @Autowired
    private MarcaService marcaService;

    @GetMapping("/listar")
    public List<Marca> buscarTodas(){
        return marcaService.BuscarMarcas();
    }

    @PostMapping("/adicionar")
    public Marca Inserir(@RequestBody Marca marca){
        return  marcaService.Adicionar(marca);
    }

    @PutMapping("/actualizar")
    public Marca Alterar(@RequestBody Marca marca){
        return marcaService.Actualizar(marca);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> Apagar(@PathVariable("id") Long id){
        marcaService.Excluir(id);
        return ResponseEntity.ok().build();
    }


}
