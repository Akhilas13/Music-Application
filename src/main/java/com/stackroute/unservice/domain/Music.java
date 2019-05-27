package com.stackroute.unservice.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;



    @Entity //declare User class as entity bean
    @Data // altogeher @getter @setter @tostring
    @NoArgsConstructor // create constructor with no parameters
    @AllArgsConstructor // create constructor with 1 parameter for each field in class
    @Builder

    public class Music {
        @Id //to make id as pk in d
                 int id;
                String name;
                String comments;


    }


