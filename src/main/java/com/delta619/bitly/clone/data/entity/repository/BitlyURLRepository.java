package com.delta619.bitly.clone.data.entity.repository;

import com.delta619.bitly.clone.data.entity.data.BitlyURL;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface BitlyURLRepository extends JpaRepository<BitlyURL, Long> {
    Optional<BitlyURL> findByBitlyurl(String bitlyurl);
    Optional<BitlyURL> findByOrigurl(String origurl);
}
