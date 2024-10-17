package com.dev.Backend.controller;

import com.dev.Backend.model.Producto;
import com.dev.Backend.service.ProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/api/producto")
public class ProductoController {

    @Autowired
    private ProductoService productoService;

    @GetMapping("/listar")
    public List<Producto> BuscarTodosProductos(){
        return productoService.BuscarProductos();
    }

    @PostMapping("/adicionar")
    public Producto AdicionarProducto(@RequestBody Producto producto){
        return productoService.adicionarProducto(producto);
    }

    @PutMapping("/actualizar")
    public Producto ActualizarProducto(@RequestBody Producto producto){
        return productoService.alterarProducto(producto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> ApagarProducto(@PathVariable("id") Long id){
        productoService.ExcluirProducto(id);
        return ResponseEntity.ok().build();
    }

}
