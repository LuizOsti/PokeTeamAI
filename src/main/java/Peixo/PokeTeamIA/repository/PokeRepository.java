package Peixo.IAdeTreinoPOKE.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import Peixo.IAdeTreinoPOKE.model.PokeModel;

@Repository
public interface PokeRepository extends JpaRepository<PokeModel, Long> {

}
