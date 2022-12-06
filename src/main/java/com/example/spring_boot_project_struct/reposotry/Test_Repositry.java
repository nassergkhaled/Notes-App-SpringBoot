package com.example.spring_boot_project_struct.reposotry;

import com.example.spring_boot_project_struct.entity.userEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import javax.transaction.Transactional;
import java.util.List;


public interface Test_Repositry extends JpaRepository<userEntity,Integer>

{

    //There are 3 Ways To Communicate With The DataBase
    // 1. JPA Predefined Functions Which is The Easiest Way Save()//DeleteByID( id )//FindByID( id )...
    // 2. JPQL Write JPQL Query Which is Simpler Than The Native Query
    // 3. Native Query Directly
    // 4. Derived Query Ex: findAll  BY  Name,.....

    @Query(value = "SELECT t FROM userEntity t")
    List<userEntity> getAllusers();

    @Query(value="SELECT t from userEntity  t WHERE t.id=:X")
    userEntity getSpecificUser(Integer X);

    @Modifying
    @Transactional
    @Query(value = "UPDATE userEntity  t SET t.password=:P WHERE t.id=:A")
    void updatUeByID(Integer A,String P);



    @Modifying
    @Transactional
    @Query(value = "DELETE FROM userEntity t WHERE t.id=:idz")
    void deleteUById(Integer idz);


    @Query(value = "select * from users order by user_id desc", nativeQuery = true)
    List<userEntity> getAllUsersByNativeQuery();

    List <userEntity> findAllByName(String Name);

    //                    Another Examples From Course Instructor
//
//    List<UserEntity> findAllByLastName(String lastName);
//
//    List<UserEntity> findAllByFirstNameStartingWith(String firstName);
//
//    List<UserEntity> findAllByFirstNameEndingWith(String firstName);
//
//    List<UserEntity> findAllByFirstNameContaining(String firstNameLike);
//
//    List<UserEntity> findAllByFirstNameAndLastName(String firstName, String lastName);
//
//    List<UserEntity> findAllByOrderByFirstNameDesc();
//
//    List<UserEntity> findAllByOrderByFirstNameAsc();




}
