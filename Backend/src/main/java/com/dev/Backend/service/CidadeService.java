package com.dev.Backend.service;

import com.dev.Backend.model.Cidade;
import com.dev.Backend.repository.CidadeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class CidadeService {

    @Autowired
    private CidadeRepository cidadeRepository;

    public List<Cidade> BuscarCidades(){
        return cidadeRepository.findAll();
    }

    public Cidade AdicionarCidade(Cidade objecto){
        objecto.setDataCriacao(new Date());
        Cidade novaCidade = cidadeRepository.saveAndFlush(objecto);
        return novaCidade;
    }

    public Cidade ActualizarCidade(Cidade objecto){
        objecto.setDataActualizacao(new Date());
        return cidadeRepository.saveAndFlush(objecto);
    }

    public void excluirCidade(Long id){
        Cidade objecto = cidadeRepository.findById(id).get();
        cidadeRepository.delete(objecto);
    }
}
