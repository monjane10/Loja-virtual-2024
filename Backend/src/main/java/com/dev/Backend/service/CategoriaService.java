package com.dev.Backend.service;

import com.dev.Backend.model.Categoria;
import com.dev.Backend.repository.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class CategoriaService {

    @Autowired
    private CategoriaRepository categoriaRepository;

    public List<Categoria> BuscarCategorias(){
        return categoriaRepository.findAll();
    }

    public Categoria AdicionarCategoria(Categoria categoria){
        categoria.setDataCriacao(new Date());
        Categoria novaCategoria = categoriaRepository.saveAndFlush(categoria);
        return novaCategoria;
    }

    public Categoria ActualizarCategoria(Categoria categoria){
        categoria.setDataActualizacao(new Date());
        return categoriaRepository.saveAndFlush(categoria);
    }

    public void Excluir(Long id){
        Categoria categoria = categoriaRepository.findById(id).get();
        categoriaRepository.delete(categoria);
    }
}
