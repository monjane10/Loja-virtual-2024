package com.dev.Backend.controller;

import com.dev.Backend.model.Permissao;
import com.dev.Backend.service.PermissaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/permissao")
public class PermissaoController {

    @Autowired
    private PermissaoService permissaoService;

    @GetMapping("/buscar")
    public List<Permissao> buscarTodos(){
        return permissaoService.BuscarTodos();
    }

    @PostMapping("/adicionar")
    public Permissao Inserir(@RequestBody Permissao objecto){
        return permissaoService.adicionar(objecto);
    }

    @PutMapping("/actualizar")
    public Permissao Actualizar(@RequestBody Permissao permissao){
        return permissaoService.alterar(permissao);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> apagarPermissao(@PathVariable("id") Long id){
        permissaoService.excluir(id);
        return ResponseEntity.ok().build();
    }



}
