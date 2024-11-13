package com.dev.Backend.service;

import com.dev.Backend.dto.PessoaClientRequestDto;
import com.dev.Backend.model.Pessoa;
import com.dev.Backend.repository.PermissaoRepository;
import com.dev.Backend.repository.PessoaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Service
public class PessoaClientService {

    @Autowired
    private PessoaRepository pessoaRepository;

    @Autowired
    private PermissaoService permissaoService;
    @Autowired
    private PermissaoPessoaService permissaoPessoaService;
    @Autowired
    private EmailService emailService;

    public Pessoa adicionarPessoa(PessoaClientRequestDto pessoaClientRequestDto) {
        Pessoa pessoa = pessoaClientRequestDto.converter(pessoaClientRequestDto);
        pessoa.setDataCriacao(new Date());
        Pessoa objectoNovo = pessoaRepository.saveAndFlush(pessoa);
        permissaoPessoaService.vincularPessoaPermissaoCliente(objectoNovo);
        //emailService.enviarEmailTexto(objectoNovo.getEmail(), "Cadastro na Loja LM", "O registo na loja foi realizado com sucesso, Em breve irá receber a senha de acesso por email");

        Map<String, Object> propMap = new HashMap<>();
        propMap.put("nome", objectoNovo.getNome());
        propMap.put("mensagem", "O registo na loja LM foi realizado com sucesso. Em breve, você receberá a senha de acesso por email.");
        emailService.enviarEmailTemplate(objectoNovo.getEmail(), "Cadastro na Loja LM", propMap);

        return objectoNovo;
    }





}
