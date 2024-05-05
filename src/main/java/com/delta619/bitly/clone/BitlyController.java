package com.delta619.bitly.clone;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BitlyController {

    @GetMapping("/")
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
        BitlyURL bitly_obj = new BitlyURL(full_url);
        String short_url = bitly_obj.getShort_url();
        return "https://bitly.com/"+short_url;
    }

}
