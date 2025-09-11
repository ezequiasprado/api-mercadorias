package com.shoppee.api.service;

import com.shoppee.api.dto.CategoriaDto;
import com.shoppee.api.dto.MercadoriaDTO;
import com.shoppee.api.entity.Categoria;
import com.shoppee.api.entity.Mercadoria;
import com.shoppee.api.repository.MercadoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class MercadoriaService {
    @Autowired
    private MercadoriaRepository repository;

    public MercadoriaDTO findById(UUID id){
        MercadoriaDTO dto = new MercadoriaDTO();
        //repositório retorna entidade
        Mercadoria mercadoria = repository.findById(id).orElseThrow();
        return convertToDto(mercadoria);
    }

    public List<MercadoriaDTO> findAll(){
        //receber uma lista de Mercadorias entity
        List<Mercadoria> mercadorias = repository.findAll();
        //criar lista de MercadoriasDTO
        List<MercadoriaDTO> mercadoriasDTO = new ArrayList<>();
        //Para cada mercadoria entidade add na lista uma mercadoria dto
        for(Mercadoria mercadoria : mercadorias){
            mercadoriasDTO.add(convertToDto(mercadoria));
        }
        return mercadoriasDTO;
    }

    public MercadoriaDTO save(MercadoriaDTO dto){
        Mercadoria mercadoria = convertToEntity(dto);
        mercadoria = repository.save(mercadoria);
        //só aceita entity
        return convertToDto(mercadoria);
    }

    public MercadoriaDTO update(UUID id, MercadoriaDTO dto){
        Mercadoria mercadoria = convertToEntity(dto);
        mercadoria.setId(id);
        mercadoria = repository.save(mercadoria);
        return convertToDto(mercadoria);
    }

    private MercadoriaDTO convertToDto(Mercadoria mercadoria) {
        MercadoriaDTO dto = new MercadoriaDTO();
        dto.setNome(mercadoria.getNome());
        dto.setPreco(mercadoria.getPreco());
        dto.setQuantidade(mercadoria.getQuantidade());
        dto.setCategoria(mercadoria.getCategoria());
        dto.setFornecedor(mercadoria.getFornecedor());
      return dto;
    }

    private Mercadoria convertToEntity(MercadoriaDTO dto){
        Mercadoria mercadoria = new Mercadoria();
        mercadoria.setNome(dto.getNome());
        mercadoria.setPreco(dto.getPreco());
        mercadoria.setQuantidade(dto.getQuantidade());
        mercadoria.setCategoria(dto.getCategoria());
        mercadoria.setFornecedor(dto.getFornecedor());
        return mercadoria;
    }



}
