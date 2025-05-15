package Peixo.IAdeTreinoPOKE.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import Peixo.IAdeTreinoPOKE.model.PokeModel;
import Peixo.IAdeTreinoPOKE.model.TeamModel;
import Peixo.IAdeTreinoPOKE.service.PokeAPIService;
import Peixo.IAdeTreinoPOKE.service.PokeService;
import Peixo.IAdeTreinoPOKE.service.TeamService;

@RestController
@RequestMapping("/poke")
public class PokeController {

    private final PokeService service;
    private final PokeAPIService apiService;
    private final TeamService teamService;

    

    public PokeController(PokeService service, PokeAPIService apiService, TeamService teamService) {
        this.service = service;
        this.apiService = apiService;
        this.teamService = teamService;
    }

    @PostMapping
    public ResponseEntity<PokeModel> criar(@RequestBody PokeModel pokeModel) {
        PokeModel salvo = service.salvar(pokeModel);
        return ResponseEntity.ok(salvo);
    }

    @GetMapping
    public List<PokeModel> listarTodos() {
        return service.listar();
    }

    @GetMapping("/{id}")
    public PokeModel buscarPorId(@PathVariable Long id) {
        return service.buscarporid(id);
    }

    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long id) {
        service.deletar(id);
    }
        
    @PostMapping("/importar/{idApi}")
    public ResponseEntity<String> importarDaAPI(@PathVariable int idApi) {
        apiService.PokeImportAPI(idApi);
        return ResponseEntity.ok("Pokémon importado da API com sucesso!");
    }
    
    @PostMapping("/team")
    public ResponseEntity<TeamModel> createTeam(
        @RequestParam String teamName,
        @RequestBody List<Long> pokemonIds) {
        
        TeamModel team = teamService.createTeam(teamName, pokemonIds);
        return ResponseEntity.ok(team);
    }
}
