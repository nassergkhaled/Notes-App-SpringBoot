package com.example.spring_boot_project_struct.controller;

import com.example.spring_boot_project_struct.dao.testDao;
import com.example.spring_boot_project_struct.dto.*;
import com.example.spring_boot_project_struct.entity.NotesEntity;
import com.example.spring_boot_project_struct.entity.address;
import com.example.spring_boot_project_struct.entity.userEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.expression.ExpressionException;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;

@RestController
public class TestController {

    @Autowired
    public testDao A;



    @GetMapping(path="Testdb")
    public String printdb()
    {
        return this.A.get_Name();
    }
    @PostMapping(path="testpdb")

    public List<userEntity> Ak()
    {
        return this.A.getUsers();
    }


    /* There is 2 Types for get data from link
        The first one (used in printOmar ) link Type is www.website.com/omar?name=nasser&Type=human&Quantity=1
        While the next one (used in printNAsser) link Type is www.website.com/nasser/ahmad/robot/1
        the way to get data from link in the code is mentioned below the first class is for the first method and
        the next class is for the next method
        */
    @GetMapping(path = "/omar")
    public String printOMar(@RequestParam(required = false, defaultValue = "nasserfromintelj") String name,
                            @RequestParam(name = "type") String Type,
                            @RequestParam int Quantity) {
        //return "Working.. ";
        return "Name :" + name + " Type :" + Type + " Quantity :" + Quantity;
    }

    @GetMapping("nasser/{name}/{Type}/{Quantity}")
    public String printNAsser(@PathVariable("name") String name,
                              @PathVariable("Type") String Type,
                              @PathVariable("Quantity") int Quantity) {
        return "Name :" + name + " Type :" + Type + " Quantity :" + Quantity;
    }

    @PostMapping(path = "/test-post")
    public String printAHmad(@RequestBody RegistrationClass Form) {
        return "Name is : " + Form.getName() + " Email is : " + Form.getEmail() + " Password is : " + Form.getPassword();
    }

    @PostMapping(path = "/test-post-form")
    public RegistrationClass testPost(@RequestBody RegistrationClass form) {
        return form;
    }

    @GetMapping(path = "/test-json-object")
    public HashMap<String, Object> testJson() {
        HashMap<String, Object> object = new HashMap<>();
        HashMap<String, Object> subObject = new HashMap<>();

        List<ContactsDto> contacts = new ArrayList<>();

        contacts.add(new ContactsDto("Work", "078888888888"));
        contacts.add(new ContactsDto("Home", "099999999"));
        contacts.add(new ContactsDto("Other", "05555555"));

        subObject.put("work", "test work address");
        subObject.put("home", "my home address");

        object.put("firstName", "Abd");
        object.put("lastName", "AbuGhazaleh");
        object.put("mobile", "055555");
        object.put("address", subObject);
        object.put("contacts", contacts);

        return object;
    }


    @GetMapping(path = "/test-json-array")
    public List<UserDto> getUsers() {

        List<UserDto> users = new ArrayList<>();

        List<AddressDto> abdAddress = new ArrayList<>();
        abdAddress.add(new AddressDto("Jordan", "Amman", "18 bim"));
        abdAddress.add(new AddressDto("USA", "FD", "XF"));
        abdAddress.add(new AddressDto("UAE", "Dubai", "122222 st"));


        List<AddressDto> suhierAddress = new ArrayList<>();
        suhierAddress.add(new AddressDto("Jordan", "Amman", "18 bim"));
        suhierAddress.add(new AddressDto("USA", "FD", "XF"));
        suhierAddress.add(new AddressDto("UAE", "Dubai", "122222 st"));

        List<AddressDto> jonAddress = new ArrayList<>();
        jonAddress.add(new AddressDto("Jordan", "Amman", "18 bim"));
        jonAddress.add(new AddressDto("USA", "FD", "XF"));
        jonAddress.add(new AddressDto("UAE", "Dubai", "122222 st"));


        users.add(new UserDto("Abd", "AbuGHazlaeh", "077777", "M", abdAddress));
        users.add(new UserDto("Suhier", "Test", "055555", "F", suhierAddress));
        users.add(new UserDto("Jon", "FFF", "15050", "M", jonAddress));

        return users;
    }
    @GetMapping(path = "/test-optional")
    public void testOptional() {
        Integer x = null;
        Optional<Integer> opt = Optional.ofNullable(x);

        if (opt.isPresent()) {
            System.out.println("X is Present .");//present value means notnull value
        } else {
            System.out.println("X is Not Present .");
        }

        x = opt.orElse(10);//if x was null give it the value of 10

        System.out.println("Or Else :  " + x);


        opt.ifPresent(i -> {
            System.out.println("It's Present Val : " + i);
        });//lambda "for" example

        opt.orElseThrow(() -> new ExpressionException("Value not valid"));//if we want it to behave like thers exception if x was null
    }
    @GetMapping(path="/test-find")
    public Optional<userEntity> get_user(@RequestParam Integer x)
    {
        return this.A.getUserById(x);
    }

//    @GetMapping(path="test-name")
//
//    public String n (@RequestParam (name="h") Integer nameforidreq)
//    {
//        Optional <entity_test> option = this.A.getUserById(nameforidreq);
//        if(option.isPresent())
//        {
//            return "Name is :"+option.get().getName()+"\n"+"Company is :"+option.get().getCompany();
//        }
//        else {return "No user With the entered ID";}
//    }
    @DeleteMapping(path="/dtest")
    public String UU(@RequestParam(name="id")Integer s)
    {
       return( this.A.DeleteUserById(s));
    }
    @PostMapping(path="/ptest")
    public userEntity YY(@RequestBody userEntity z)
    {
        return (this.A.InsertById(z));
    }
    //if the user id was existed in the json then it's an update request otherwise if it wasn't existed then
    // it's an insert request hence that the id is auto generated

    @PostMapping(path="/pUtest")
    public String YAY(@RequestBody userEntity z)
    {
        return (this.A.UpdateById(z));
    }
    @GetMapping(path="HI")
    public List<userEntity> K()
    {
        return this.A.getAllusers();
    }


    @GetMapping(path ="HII")
    public Optional<userEntity> get_use(@RequestParam Integer x)
    {
        return Optional.ofNullable(this.A.getSpecificUser(x));
    }

    @PostMapping(path="QQ")
    public void Qwas(@RequestBody userEntity user)
    {
         this.A.updatUeByIDa(user.getId(),user.getPassword());
    }
    @GetMapping(path = "de")
    public void yyf(@RequestParam Integer J)
    {
        this.A.deleteUById(J);
    }


   @GetMapping(path = "v")
    public List<address> V ()

   {
       return this.A.A();
   }




   @GetMapping(path="notes")
    public List<NotesEntity> Z()
   {
       return this.A.zz();
   }

    @PostMapping("/login")
    public String LogIN(@RequestBody LogInBody Body)
    {
        if(A.LogInDao(Body.getId(),Body.getPassword()))
        {
            return "Success";
        }
        else{return "Failed";}
    }
}