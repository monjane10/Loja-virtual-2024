package com.dev.Backend.service;

import com.dev.Backend.dto.PessoaClientRequestDto;
import com.dev.Backend.model.Pessoa;
import com.dev.Backend.repository.PessoaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

@Service
public class PessoaGestaoService {
    @Autowired
    private PessoaRepository pessoaRepository;
    @Autowired
    private EmailService emailService;

    public String solicitarCodigo(String email) {
        Pessoa pessoa = pessoaRepository.findByEmail(email);
        pessoa.setCodigoRecuperacaoSenha(getCodigoRecuperacaoSenha(pessoa.getId()));
        pessoa.setDataEnvioCodigo(new Date());
        pessoaRepository.saveAndFlush(pessoa);
        emailService.enviarEmailTexto(pessoa.getEmail(), "Recuperação de senha", "Olá, o teu codigo para a recuperação de senha é:" +pessoa.getCodigoRecuperacaoSenha());

       return "Código enviado";
    }
    private String getCodigoRecuperacaoSenha(Long id){
        DateFormat format = new SimpleDateFormat("ddMMyyyyHHmmSSmm");
        return format.format(new Date())+id;

    }
}
