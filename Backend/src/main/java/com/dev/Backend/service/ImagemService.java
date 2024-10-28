package com.dev.Backend.service;

import com.dev.Backend.model.Producto;
import com.dev.Backend.model.imagem;
import com.dev.Backend.repository.ImagemRepository;
import com.dev.Backend.repository.ProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Date;
import java.util.List;

@Service
public class ImagemService {

    @Autowired
    private ImagemRepository imagemRepository;
    @Autowired
    ProductoRepository productoRepository;

    public List<imagem> buscarTodas(){
        return imagemRepository.findAll();
    }

    public imagem inserir(Long productoId, MultipartFile file){
        Producto producto = productoRepository.findById(productoId).get();
        imagem novaImagem = new imagem();
        try {
            if (!file.isEmpty()){
                byte[] bytes = file.getBytes();
                String nomeImagem = String.valueOf(producto.getId()) + file.getOriginalFilename();
                Path caminho = Paths
                        .get("c:/imagens/" );
                Files.write(caminho, bytes);
                novaImagem.setNome(nomeImagem);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        novaImagem.setDataCriacao(new Date());
        novaImagem.setProducto(producto);
        novaImagem = imagemRepository.saveAndFlush(novaImagem);
        return novaImagem;


    }

}
