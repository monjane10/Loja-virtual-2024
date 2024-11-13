package com.dev.Backend.controller;

import com.dev.Backend.dto.PessoaClientRequestDto;
import com.dev.Backend.model.Pessoa;
import com.dev.Backend.service.PessoaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/cliente")
public class PessoaClientController {

    @Autowired
    private PessoaService pessoaService;

    @PostMapping("/addClient")
    public Pessoa Inserir(@RequestBody PessoaClientRequestDto pessoaClientRequestDto){
        Pessoa pessoa = new PessoaClientRequestDto().converter(pessoaClientRequestDto);
        return pessoaService.adicionarPessoa(pessoa);
    }

    
}
