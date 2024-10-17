package com.dev.Backend.service;

import com.dev.Backend.model.Provincia;
import com.dev.Backend.repository.ProvinciaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class ProvinciaService {

    @Autowired
    private ProvinciaRepository provinciaRepository;

    public List<Provincia>BuscarProvincias(){
        return provinciaRepository.findAll();
    }

    public Provincia Inserir(Provincia provincia){
        provincia.setDataCriacao(new Date());
        Provincia provinciaNova = provinciaRepository.saveAndFlush(provincia);
                return provinciaNova;
    }

    public Provincia Alterar(Provincia provincia){
        provincia.setDataActualizacao(new Date());
        return provinciaRepository.saveAndFlush(provincia);

    }
    public void Excluir(Long id){
        Provincia provincia =  provinciaRepository.findById(id).get();
        provinciaRepository.delete(provincia);
    }
}
