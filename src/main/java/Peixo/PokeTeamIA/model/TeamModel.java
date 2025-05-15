package Peixo.IAdeTreinoPOKE.model;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "PokeTeams")
public class TeamModel {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int id;

    private String TeamName;

    @ManyToMany
    @JoinTable(
        name = "team_pokemon",
        joinColumns = @JoinColumn(name = "team_id"),
        inverseJoinColumns = @JoinColumn(name = "pokemon_id")
    )
    private List<PokeModel> pokes;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTeamName() {
        return TeamName;
    }

    public void setTeamName(String teamName) {
        TeamName = teamName;
    }

    public List<PokeModel> getPokes() {
        return pokes;
    }

    public void setPokes(List<PokeModel> pokes) {
        this.pokes = pokes;
    }

    
    
}
