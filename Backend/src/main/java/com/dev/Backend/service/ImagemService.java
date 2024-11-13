package com.dev.Backend.service;

import com.dev.Backend.model.Marca;
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

    public imagem inserir(Long productoId, MultipartFile file) {
        // Verificar se o produto existe
        Producto producto = productoRepository.findById(productoId)
                .orElseThrow(() -> new RuntimeException("Produto não encontrado")); // Trate o caso quando o produto não é encontrado

        imagem novaImagem = new imagem(); // Nome da classe atualizado
        try {
            if (!file.isEmpty()) {
                byte[] bytes = file.getBytes();
                String nomeImagem = producto.getId() + "_" + System.currentTimeMillis() + "_" + file.getOriginalFilename(); // Evita sobrescrita
                Path caminho = Paths.get("c:/imagens/" + nomeImagem); // Inclui o nome do arquivo
                Files.write(caminho, bytes);
                novaImagem.setNome(nomeImagem);
            }

        } catch (IOException e) {
            e.printStackTrace();
            // Aqui você pode lançar uma exceção ou retornar uma resposta apropriada
            throw new RuntimeException("Erro ao salvar a imagem: " + e.getMessage());
        }
        novaImagem.setDataCriacao(new Date());
        novaImagem.setProducto(producto);
        return imagemRepository.saveAndFlush(novaImagem);
    }





    public imagem alterar (imagem objecto){
        objecto.setDataActualizacao(new Date());
        return imagemRepository.saveAndFlush(objecto);
    }

    public void Excluir(Long id){
        imagem objecto = imagemRepository.findById(id).get();
        imagemRepository.delete(objecto);
    }

}
