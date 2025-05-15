package Peixo.IAdeTreinoPOKE.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import Peixo.IAdeTreinoPOKE.model.TeamModel;

public interface TeamRepository extends JpaRepository<TeamModel, Integer> {
}