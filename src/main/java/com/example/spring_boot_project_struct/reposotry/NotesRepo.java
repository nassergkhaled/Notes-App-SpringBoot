package com.example.spring_boot_project_struct.reposotry;

import com.example.spring_boot_project_struct.entity.NotesEntity;
import com.example.spring_boot_project_struct.entity.address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface NotesRepo extends JpaRepository<NotesEntity, Integer> {
    @Query(value = "SELECT t FROM NotesEntity t")
    List<NotesEntity> getAllNotes();
}
