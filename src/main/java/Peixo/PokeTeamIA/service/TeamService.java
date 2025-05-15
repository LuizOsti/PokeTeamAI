package Peixo.IAdeTreinoPOKE.service;

import java.util.List;

import org.springframework.stereotype.Service;

import Peixo.IAdeTreinoPOKE.model.TeamModel;
import Peixo.IAdeTreinoPOKE.repository.TeamRepository;

@Service
public class TeamService {

    private final TeamRepository teamRepository;
    private final PokeService pokeService;

    public TeamService(TeamRepository teamRepository, PokeService pokeService) {
        this.teamRepository = teamRepository;
        this.pokeService = pokeService;
    }

    public TeamModel createTeam(String teamName, List<Long> pokeIds) {
        TeamModel team = new TeamModel();
        team.setTeamName(teamName);
        team.setPokes(pokeService.findAllById(pokeIds));
        return teamRepository.save(team);
    }
    public List<TeamModel> getAllTeams() {
        return teamRepository.findAll();
    }

    public TeamModel getTeamById(Integer id) {
        return teamRepository.findById(id).orElse(null);
    }
}

