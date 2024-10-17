package com.dev.Backend.controller;

import com.dev.Backend.model.Pessoa;
import com.dev.Backend.service.PessoaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/pessoa")
public class PessoaController {

    @Autowired
    private PessoaService pessoaService;

    @GetMapping("/listar")
    public List<Pessoa> BuscarTodasPessoas(){
        return pessoaService.BuscarPessoas();
    }

    @PostMapping("/adicionar")
    public Pessoa AdicionarPessoa(@RequestBody Pessoa pessoa){
        return pessoaService.adicionarPessoa(pessoa);
    }

    @PutMapping("/actualizar")
    public Pessoa ActualizarPessoa(@RequestBody Pessoa pessoa){
        return pessoaService.actualizarPessoa(pessoa);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> ApagarPessoa(@PathVariable("id") Long id){
        pessoaService.excluirPessoa(id);
        return ResponseEntity.ok().build();
    }



}
