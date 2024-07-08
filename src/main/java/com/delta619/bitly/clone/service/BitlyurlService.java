package com.delta619.bitly.clone.service;

import com.delta619.bitly.clone.data.entity.data.BitlyURL;
import com.delta619.bitly.clone.data.entity.repository.BitlyURLRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class BitlyurlService {
    @Autowired
    private BitlyURLRepository bitlyURLRepository;

    public Optional<BitlyURL> getBitlyURLByShortURL(String bitlyurl) {
        return bitlyURLRepository.findByBitlyurl(bitlyurl);
    }
    public Optional<BitlyURL> getBitlyURLByOrigURL(String origurl) {
        return bitlyURLRepository.findByOrigurl(origurl);
    }


    public BitlyURL saveBitlyURL(BitlyURL bitlyURL) {
        return bitlyURLRepository.save(bitlyURL);
    }
}
