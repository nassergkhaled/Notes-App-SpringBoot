package com.example.spring_boot_project_struct.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import net.bytebuddy.agent.builder.AgentBuilder;

import javax.persistence.*;

@Table(name="adreess")
@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class address {
    @Id
    @Column(name = "address_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY) //AUTO INC
    public Integer id;
    @Column(name = "user_id")
    public Integer user_id;
    public String name;


    @JsonBackReference
    @OneToOne(fetch= FetchType.EAGER)//EAGER --> SMALL NUMBER OF ADDRESS FOR ONE USER WHILE LAZY --> BIG NUMBER OF ADDRESS FOR ONE USER
    @JoinColumn(name = "user_id ", insertable = false,updatable = false)
    private userEntity userEntity;

}
