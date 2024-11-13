package com.dev.Backend.controller;

import com.dev.Backend.dto.PessoaClientRequestDto;
import com.dev.Backend.model.Pessoa;
import com.dev.Backend.service.PessoaClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/cliente")
public class PessoaClientController {

    @Autowired
    private PessoaClientService pessoaService;

    @PostMapping("/addClient")
    public Pessoa Inserir(@RequestBody PessoaClientRequestDto pessoaClientRequestDto){
        return pessoaService.adicionarPessoa(pessoaClientRequestDto);
    }

    
}
