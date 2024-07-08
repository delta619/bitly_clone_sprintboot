package com.delta619.bitly.clone.controller;



import com.delta619.bitly.clone.data.entity.data.BitlyURL;
import com.delta619.bitly.clone.data.entity.repository.BitlyURLRepository;
import com.delta619.bitly.clone.service.BitlyurlService;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;
import java.util.Random;


@RestController
@RequestMapping("/api/url/")
public class BitlyController {
    private final BitlyURLRepository bitlyURLRepository;
    private final BitlyurlService bitlyurlService;

    public BitlyController(BitlyURLRepository bitlyURLRepository, BitlyurlService bitlyurlService) {
        this.bitlyURLRepository = bitlyURLRepository;
        this.bitlyurlService = bitlyurlService;
    }

    @GetMapping
    public String getData() {
        return "bar";
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<ApiResponse<BitlyURL>> insertBitlyURL(@RequestBody BitlyURL bitlyURL) {

        Optional<BitlyURL> obj = bitlyurlService.getBitlyURLByOrigURL(bitlyURL.getOrigurl());
        if (obj.isPresent()) {
            return new ResponseEntity<>(new ApiResponse<>(obj.get()), HttpStatus.BAD_REQUEST);
        }

        String newShortUrl;
        Random random = new Random();
        while (true) {
            newShortUrl = generateShortUrl(random);
            if (bitlyurlService.getBitlyURLByShortURL(newShortUrl).isEmpty()) {
                break;
            }
        }
        bitlyURL.setBitlyurl(newShortUrl);
        bitlyurlService.saveBitlyURL(bitlyURL);
        return new ResponseEntity<>(new ApiResponse<>(bitlyURL), HttpStatus.CREATED);
    }

    @GetMapping("/{bitlyurl}")
    public BitlyURL getBitlyURL(@PathVariable("bitlyurl")String bitlyurl){
        Optional<BitlyURL> bitlyObj = this.bitlyURLRepository.findByBitlyurl(bitlyurl);
        if (bitlyObj.isEmpty()){
            System.out.println("Not found");
        }
        return bitlyObj.get();
    }

    private String generateShortUrl(Random random) {
        StringBuilder newShortUrl = new StringBuilder();
        for (int i = 0; i < 5; i++) {
            char c = (char) ('a' + random.nextInt(26));
            newShortUrl.append(c);
        }
        return newShortUrl.toString();
    }


}
