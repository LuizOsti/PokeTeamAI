package Peixo.IAdeTreinoPOKE.service;

import java.util.List;

import org.springframework.stereotype.Service;

import Peixo.IAdeTreinoPOKE.model.PokeModel;
import Peixo.IAdeTreinoPOKE.repository.PokeRepository;

@Service
public class PokeService {

    private PokeRepository repository;

    public PokeService(PokeRepository repository) {
        this.repository = repository;
    }

    public PokeModel salvar(PokeModel pokeModel) {
        return repository.save(pokeModel);
    }

    public List<PokeModel> listar(){
        return repository.findAll();                         
    }
    
    public PokeModel buscarporid(Long id) {
        return repository.findById(id).orElse(null);
    }
    public void deletar(Long id) {
        repository.deleteById(id);
    }
    public List<PokeModel> findAllById(List<Long> ids) {
    return repository.findAllById(ids);
    }   
}
