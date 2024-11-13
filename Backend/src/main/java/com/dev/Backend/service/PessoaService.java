package com.dev.Backend.service;

import com.dev.Backend.model.Pessoa;
import com.dev.Backend.repository.PessoaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Optional;
import java.util.regex.Pattern;

import java.util.List;

@Service
public class PessoaService {

    @Autowired
    private PessoaRepository pessoaRepository;

    public List<Pessoa> BuscarPessoas(){
        return pessoaRepository.findAll();
    }

    public Pessoa adicionarPessoa(Pessoa pessoa) {
        validarPessoa(pessoa);
        pessoa.setDataCriacao(new Date());
        pessoa.setDataActualizacao(new Date());
        pessoa.setPermissaPessoas(pessoa.getPermissaPessoas());
        return pessoaRepository.saveAndFlush(pessoa);
    }

    public Pessoa actualizarPessoa(Pessoa objeto) {
        objeto.setDataActualizacao(new Date());
        return pessoaRepository.saveAndFlush(objeto);
    }



    private void validarPessoa(Pessoa pessoa) {
        if (pessoa.getNome() == null || pessoa.getNome().isEmpty()) {
            throw new IllegalArgumentException("O nome é obrigatório.");
        }
        if (pessoa.getEmail() == null || !isValidEmail(pessoa.getEmail())) {
            throw new IllegalArgumentException(" O Email inválido.");
        }
        if (pessoa.getBi() == null || pessoa.getBi().isEmpty()) {
            throw new IllegalArgumentException("O BI é obrigatório.");
        }

    }


    private boolean isValidEmail(String email) {
        String emailRegex = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$";
        Pattern pattern = Pattern.compile(emailRegex);
        return pattern.matcher(email).matches();
    }

    public void excluirPessoa(Long id){
        Pessoa pessoa = pessoaRepository.findById(id).get();
        pessoaRepository.delete(pessoa);
    }




}
