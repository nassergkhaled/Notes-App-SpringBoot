package com.example.spring_boot_project_struct.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Table(name = "courses")
@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class coursesEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "course_id")
    public Integer course_id;
    public String course_name;
    public String course_time;



    @JsonManagedReference
    @OneToMany(mappedBy = "courseEntity")
    private List<user_course> userCourses;
}