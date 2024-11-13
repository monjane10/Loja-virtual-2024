package com.dev.Backend.dto;

import com.dev.Backend.model.Cidade;
import com.dev.Backend.model.Pessoa;
import lombok.Data;
import org.springframework.beans.BeanUtils;

@Data
public class PessoaClientRequestDto {
    private String nome;
    private String bi;
    private String email;
    private String endereco;
    private String nuit;
    private Cidade cidade;


    public Pessoa converter(PessoaClientRequestDto pessoaClientRequestDto){
        Pessoa pessoa = new Pessoa();
        BeanUtils.copyProperties(pessoaClientRequestDto, pessoa);
        return pessoa;
    }
}
