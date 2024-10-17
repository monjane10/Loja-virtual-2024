package com.dev.Backend.service;

import com.dev.Backend.model.Producto;
import com.dev.Backend.repository.ProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class ProductoService {

    @Autowired
    private ProductoRepository productoRepository;

    public List<Producto> BuscarProductos(){
        return productoRepository.findAll();
    }

    public Producto adicionarProducto(Producto producto){
        producto.setDataCriacao(new Date());
        Producto novoProducto = productoRepository.saveAndFlush(producto);
        return novoProducto;
    }

    public Producto alterarProducto(Producto producto){
        producto.setDataActualizacao(new Date());
        return productoRepository.saveAndFlush(producto);
    }

    public void ExcluirProducto(Long id){
        Producto producto = productoRepository.findById(id).get();
        productoRepository.delete(producto);

    }
}
