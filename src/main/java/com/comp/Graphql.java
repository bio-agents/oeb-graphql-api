/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Agents | Templates
 * and open the template in the editor.
 */
package com.comp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;


/**
 *
 * @author vsundesh
 */
@SpringBootApplication
public class Graphql extends SpringBootServletInitializer {
    
    public static void main (String[] args){
        SpringApplication.run(Graphql.class, args);
    }
}
