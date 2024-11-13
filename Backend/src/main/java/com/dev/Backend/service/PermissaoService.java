package com.dev.Backend.service;

import com.dev.Backend.model.Permissao;
import com.dev.Backend.repository.PermissaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class PermissaoService {

    @Autowired
    private PermissaoRepository permissaoRepository;

    public List<Permissao> BuscarTodos() {
        return permissaoRepository.findAll();
    }

    public Permissao adicionar(Permissao objecto) {
        objecto.setDataCriacao(new Date());
        Permissao novoObjecto = permissaoRepository.saveAndFlush(objecto);
        return novoObjecto;
    }

    public Permissao alterar (Permissao objecto){
        objecto.setDataActualizacao(new Date());
        return permissaoRepository.saveAndFlush(objecto);
    }

    public void excluir (Long id){
        Permissao objecto = permissaoRepository.findById(id).get();
        permissaoRepository.delete(objecto);
    }
}
