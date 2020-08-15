package com.example.demo.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.redis.core.RedisHash;

@AllArgsConstructor
@Getter
@Setter
@Builder
@RedisHash
public class Person {

    private String lastname;
    private Address address;
    private String id;
    private String firstname;

    public static class PersonBuilder{
        private String lastname;
        private Address address;
        private String id;
        private String firstname;

        public PersonBuilder(){

        }
        public PersonBuilder withid(String id){
            this.id = id;
            return this;
        }

        public PersonBuilder withFirstName(String firstName){
            this.firstname = firstName;
            return this;
        }

        public PersonBuilder withLastName(String lastName){
            this.lastname = lastName;
            return this;
        }

        public PersonBuilder withAddress(Address address){
            this.address = address;
            return this;
        }

        public Person build(){
            Person person = new Person();
            person.setAddress(this.address);
            person.setFirstname(this.firstname);
            person.setLastname(this.lastname);
            person.setId(this.id);
            return person;
        }
    }


    public String getId() {
        return id;
    }

    public String getFirstname() {
        return firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public Address getAddress() {
        return address;
    }



    public void setId(String id) {
        this.id = id;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public void setAddress(Address address) {
        this.address = address;
    }





}
