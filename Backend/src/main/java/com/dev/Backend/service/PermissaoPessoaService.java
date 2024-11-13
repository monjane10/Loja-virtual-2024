package com.dev.Backend.service;

import com.dev.Backend.model.PermissaPessoa;
import com.dev.Backend.model.Permissao;
import com.dev.Backend.model.Pessoa;
import com.dev.Backend.repository.PermissaoPessoaRepository;
import com.dev.Backend.repository.PermissaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class PermissaoPessoaService {

    @Autowired
    private PermissaoPessoaRepository permissaoPessoaRepository;
    @Autowired
    private PermissaoRepository permissaoRepository;

    public void vincularPessoaPermissaoCliente(Pessoa pessoa){
        List<Permissao> listaPermissao =  permissaoRepository.findByNome("cliente");
        if (listaPermissao.size()>0){
            PermissaPessoa permissaPessoa = new PermissaPessoa();
            permissaPessoa.setPessoa(pessoa);
            permissaPessoa.setPermissao(listaPermissao.get(0));
            permissaPessoa.setDataCriacao(new Date());
            permissaoPessoaRepository.saveAndFlush(permissaPessoa);

        }

    }

}
