package com.example.spring_boot_project_struct.reposotry;


import com.example.spring_boot_project_struct.entity.PlayersEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PlayersRepo extends JpaRepository<PlayersEntity,Integer> {

    public PlayersEntity findAllByIdAndPassword(Integer id, String password);



}
