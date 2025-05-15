package Peixo.IAdeTreinoPOKE.service;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import Peixo.IAdeTreinoPOKE.dto.PokeAPIDTO;
import Peixo.IAdeTreinoPOKE.model.PokeModel;

@Service
public class PokeAPIService {

    private final RestTemplate restTemplate;
    private final PokeService pokeService;

    public PokeAPIService(RestTemplate restTemplate, PokeService pokeService) {
        this.restTemplate = restTemplate;
        this.pokeService = pokeService;
    }

    public void PokeImportAPI(int idPokeAPI) {
        String url = "https://pokeapi.co/api/v2/pokemon/" + idPokeAPI;

        PokeAPIDTO response = restTemplate.getForObject(url, PokeAPIDTO.class);

        PokeModel poke = new PokeModel();
        poke.setNome(response.getName());
        
        if (!response.getTypes().isEmpty()) {
            poke.setTipo(response.getTypes().get(0).getType().getName());
            
            if (response.getTypes().size() > 1) {
                poke.setTipo2(response.getTypes().get(1).getType().getName());
            }
        }
        
        if (!response.getStats().isEmpty()) {
            poke.setHp(response.getStats().get(0).getBase_stat());
            
            if (response.getStats().size() > 1) {
                poke.setAtk(response.getStats().get(1).getBase_stat());
            }
        }

        pokeService.salvar(poke);
    }
}
