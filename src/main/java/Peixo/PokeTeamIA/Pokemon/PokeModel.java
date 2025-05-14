package Peixo.PokeTeamIA.Pokemon;

import java.util.List;

import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;



@Entity
@Table(name="tb_poke")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PokeModel {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private long id;

    private String nome;
    private String tipo;
    private String tipo2;
    @ElementCollection
    private List<String> weakness;
    private int vida;

}
