package com.shoppee.api.controller;

import com.shoppee.api.dto.MercadoriaDTO;
import com.shoppee.api.service.MercadoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/mercadoria")
public class MercadoriaController {
    @Autowired
    private MercadoriaService service;
    //procurar uma mercadoria por ID
    @GetMapping("/{id}")
    public MercadoriaDTO findById(@PathVariable UUID id){
        return service.findById(id);
    }
    //Listar todas as mercadorias
    @GetMapping
    public List<MercadoriaDTO> findAll(){
        return service.findAll();
    }
    //Salvar uma mercadoria
    @PostMapping
    public MercadoriaDTO save(@RequestBody MercadoriaDTO dto){
        return service.save(dto);
    }
    //Atualizar uma mercadoria
    @PutMapping("/{id}")
    public MercadoriaDTO update(@PathVariable UUID id,
                                @RequestBody MercadoriaDTO dto){
        return service.update(id,dto);
    }
}
