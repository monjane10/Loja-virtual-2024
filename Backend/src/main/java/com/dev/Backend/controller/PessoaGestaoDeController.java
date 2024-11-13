package com.dev.Backend.controller;
import com.dev.Backend.service.PessoaGestaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/pessoa-gestao")
public class PessoaGestaoDeController {

    @Autowired
    private PessoaGestaoService pessoaGestaoService;
    @PostMapping("/recuperar-senha")
    public String recuperarCodigo(@RequestParam("email") String email){

        return pessoaGestaoService.solicitarCodigo(email);

    }




}
