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
        if (pessoa == null) {
            return "Email não encontrado.";
        }

        pessoa.setCodigoRecuperacaoSenha(getCodigoRecuperacaoSenha(pessoa.getId()));
        pessoa.setDataEnvioCodigo(new Date());
        pessoaRepository.saveAndFlush(pessoa);
        emailService.enviarEmailTexto(pessoa.getEmail(), "Recuperação de senha",
                "Olá, o teu código para a recuperação de senha é: " + pessoa.getCodigoRecuperacaoSenha());

        return "Código enviado";
    }

    private String getCodigoRecuperacaoSenha(Long id) {
        DateFormat format = new SimpleDateFormat("ddMMyyyyHHmmssSSS");
        return format.format(new Date()) + id;
    }

    public String alterarSenha(Pessoa pessoa) {
        if (pessoa.getEmail() == null || pessoa.getCodigoRecuperacaoSenha() == null) {
            return "Dados insuficientes para alterar a senha.";
        }
        Pessoa pessoa1 = pessoaRepository.findByEmailAndCodigoRecuperacaoSenha(
                pessoa.getEmail(), pessoa.getCodigoRecuperacaoSenha());

        if (pessoa1 != null) {
            if (pessoa1.getDataEnvioCodigo() != null) {
                long diferencaMillis = new Date().getTime() - pessoa1.getDataEnvioCodigo().getTime();
                if (diferencaMillis < 600000) {
                    pessoa1.setSenha(pessoa.getSenha());
                    pessoa1.setCodigoRecuperacaoSenha(null);
                    pessoaRepository.saveAndFlush(pessoa1);
                    return "Senha alterada com sucesso.";
                } else {
                    return "Código de recuperação expirado.";
                }
            } else {
                return "Data de envio do código não encontrada.";
            }
        } else {
            return "Usuário ou código de recuperação inválido.";
        }
    }


}
