package com.dev.Backend.service;

import com.dev.Backend.model.Marca;
import com.dev.Backend.repository.MarcaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class MarcaService {
    @Autowired
    private MarcaRepository marcaRepository;

    public List<Marca> BuscarMarcas (){
        return marcaRepository.findAll();
    }

    public Marca Adicionar(Marca marca){
        marca.setDataCriacao(new Date());
        Marca novaMarca = marcaRepository.saveAndFlush(marca);
        return novaMarca;
    }

    public Marca Actualizar(Marca marca){
        marca.setDataActualizacao(new Date());
        return marcaRepository.saveAndFlush(marca);
    }

    public void Excluir(Long id){
        Marca marca = marcaRepository.findById(id).get();
        marcaRepository.delete(marca);
    }


}
