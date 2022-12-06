package com.example.spring_boot_project_struct.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

//Entity --> Repository --> Dao --> Controller

@Entity
@Table(name = "users")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class userEntity {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY) //AUTO INC
    private Integer id;
    @Column(name = "Name")
    private String name; // if u use the column annotation then u can name the variable any name u want but if u dont want to us the column annotation then u must to name the variable the same name it has in the data base
    @Column(name="email")
    private String email;
    @Column(name="Phone")
    private Integer phone;
    @Column(name="Company")
    private String company;
    @Column(name="Password")
    private String password;

    @JsonManagedReference
    @OneToOne(mappedBy = "userEntity")
    public address addressEntity;

   @JsonManagedReference
   @OneToMany(mappedBy = "userEntity")//Note Very Important if you made many relations for the same entity you have to choose the same mapped by name
   private List <NotesEntity> userNotes;


   @JsonManagedReference
   @OneToMany(mappedBy = "userEntity")
   private List <user_course> userCourses;


}
