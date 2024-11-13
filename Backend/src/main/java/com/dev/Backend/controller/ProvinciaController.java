package com.dev.Backend.controller;

import com.dev.Backend.model.Provincia;
import com.dev.Backend.service.ProvinciaService;
import jakarta.websocket.server.PathParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/provincia")
public class ProvinciaController {

    @Autowired
    private ProvinciaService provinciaService;

    @GetMapping("/listar")
    public List<Provincia> BuscarTodos(){
        return provinciaService.BuscarProvincias();
    }

    @PostMapping("/Inserir")
    public Provincia inserir(@RequestBody Provincia provincia){
        return provinciaService.Inserir(provincia);

    }

    @PutMapping("/alterar")
    public Provincia alterar(@RequestBody Provincia provincia){
        return provinciaService.Alterar(provincia);

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluir(@PathVariable("id") Long id){
        provinciaService.Excluir(id);
        return ResponseEntity.ok().build();

    }


}
