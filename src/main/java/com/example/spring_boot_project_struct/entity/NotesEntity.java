package com.example.spring_boot_project_struct.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Table(name = "notes")
@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class NotesEntity {
    @Id
    @Column(name = "note_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer note_id;
    @Column(name = "user_id")
    public Integer user_id;
    @Column(name = "note_text")
    public String note_text;

//    @JsonBackReference
//    @ManyToOne(fetch = FetchType.LAZY)//Lazy because maybe one user have 500 notes and 500 is big number
//    @JoinColumn(name = "user_id", insertable = false, updatable = false)
//    private userEntity UserEntity;


    @JsonBackReference
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id",insertable = false,updatable = false)
    private userEntity userEntity;

}



