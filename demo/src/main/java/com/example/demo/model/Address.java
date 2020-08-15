package com.example.demo.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
@Builder


public class Address {

    private String street;
    private String city;


    public static  class AddressBuilder{

        public AddressBuilder(){}

        private String street;
        private String city;


        public AddressBuilder withStreet(String street){
            this.street =street;
            return this;
        }

        public AddressBuilder withCity(String city){
            this.city =city;
            return this;
        }

        public Address build(){
            Address address =  new Address();
            address.setCity(this.city);
            address.setStreet(this.street);
            return address;
        }

    }

    public void setStreet(String street) {
        this.street = street;
    }

    public void setCity(String city) {
        this.city = city;
    }


    public String getStreet() {
        return street;
    }

    public String getCity() {
        return city;
    }

}
