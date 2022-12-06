package com.example.spring_boot_project_struct.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

import javax.persistence.*;

@Table(name = "users_courses")
@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class user_course {
    @Transient
    private String course_name;//any filed doesn't exist in the database must be defined firstly with the transient annotation
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "uc_id")
    public Integer uc_id;
    public Integer course_id;
    public Integer user_id;


    public String getCourseName()
    {
        return this.courseEntity.getCourse_name();
    }


    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "user_id",insertable = false,updatable = false)
    private userEntity userEntity;


    @JsonBackReference
    @ManyToOne(fetch = FetchType.LAZY)
    @NotFound(action = NotFoundAction.IGNORE)// Maybe we don't need it but for making sure
    @JoinColumn(name = "course_id",insertable = false,updatable = false)
    private coursesEntity courseEntity;


}
