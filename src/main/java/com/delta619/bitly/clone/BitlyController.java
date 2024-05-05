package com.delta619.bitly.clone;


import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.graphql.data.method.annotation.SchemaMapping;



import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class BitlyController {

    @GetMapping("/hi")
    public String hello(){
        return "hello World";
    }

    @GetMapping("/{bitly_url}")
    public String resolve_url(@PathVariable String bitly_url){
        // resolve the bitly url into the full url

        return "The full URL from the database";
    }

    @GetMapping("/shorten/{full_url}")
    public String shortenUrl(@PathVariable String full_url){
        return "123";
    }

//    @GetMapping("/test")
//    @QueryMapping
//    public BitlyURL bookById(@Argument String id) {
//
//    }



}
