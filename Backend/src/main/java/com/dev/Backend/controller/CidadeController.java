package com.dev.Backend.controller;

import com.dev.Backend.model.Cidade;
import com.dev.Backend.service.CidadeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/cidade")
public class CidadeController {
    
    @Autowired
    public CidadeService cidadeService;
    
    @GetMapping("/listar")
    public List<Cidade> BuscaTodasCidades(){
        return cidadeService.BuscarCidades();
    }

    @PostMapping("/adicionar")
    public Cidade InserirCidade(@RequestBody Cidade objecto){
        return cidadeService.AdicionarCidade(objecto);
    }

    @PutMapping("/actualizar")
    public Cidade AlterarCidade(@RequestBody Cidade objecto){
        return  cidadeService.ActualizarCidade(objecto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> ApagarCidade(@PathVariable("id") Long id ){
        cidadeService.excluirCidade(id);
        return ResponseEntity.ok().build();
    }
}
