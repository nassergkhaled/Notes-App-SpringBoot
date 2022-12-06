package com.example.spring_boot_project_struct.dao;

import com.example.spring_boot_project_struct.entity.NotesEntity;
import com.example.spring_boot_project_struct.entity.PlayersEntity;
import com.example.spring_boot_project_struct.entity.address;
import com.example.spring_boot_project_struct.entity.userEntity;
import com.example.spring_boot_project_struct.reposotry.AddRepo;
import com.example.spring_boot_project_struct.reposotry.NotesRepo;
import com.example.spring_boot_project_struct.reposotry.PlayersRepo;
import com.example.spring_boot_project_struct.reposotry.Test_Repositry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class testDao
{
    @Autowired
    private Test_Repositry Repo;

    public String get_Name()
    {
        return "Hi From Dao";
    }
    public List<userEntity> getUsers()
    {
        return this.Repo.findAll();
    }
    public Optional<userEntity> getUserById(Integer x)
    {
        return this.Repo.findById(x);
    }
    public String DeleteUserById(Integer x)
    {
        Optional <userEntity> Object = this.getUserById(x);
        if (Object.isPresent())
        {
            this.Repo.deleteById(x);

            return "Done Successfully";
        }
        else {return " No User With The Entered ID";}
    }
    public userEntity InsertById(userEntity x)
    {
            return this.Repo.save(x);
    }
    public String UpdateById(userEntity x)
    {
        Optional <userEntity> Object = this.getUserById(x.getId());
        if(Object.isPresent())
        {
            this.Repo.save(x);
            return "Done Successfully";
        }
        else {return " No User With The Entered Id";}
    }
    public List<userEntity> getAllusers()
    {
        return this.Repo.getAllusers();
    }
    public userEntity getSpecificUser(Integer O)
    {
        return this.Repo.getSpecificUser(O);
    }
    public void updatUeByIDa(Integer Z, String Q)
    {
        this.Repo.updatUeByID(Z,Q);
    }
    public void deleteUById(Integer Z)
    {
        this.Repo.deleteUById(Z);
    }

    @Autowired
    private AddRepo Q;
  public List<address> A ()
  {
      return this.Q.getAlladdresss();
  }
  @Autowired
    private NotesRepo R;
  public List<NotesEntity> zz()
  {
      return this.R.getAllNotes();
  }

  @Autowired
  private PlayersRepo PlayerReposotry;

  public Boolean  LogInDao (Integer id, String password)
  {
    Optional <PlayersEntity> PlayerEntity;
    PlayerEntity= Optional.ofNullable(PlayerReposotry.findAllByIdAndPassword(id, password));
    if(PlayerEntity.isPresent()){return Boolean.TRUE;}
    else{return Boolean.FALSE;}
  }




}
