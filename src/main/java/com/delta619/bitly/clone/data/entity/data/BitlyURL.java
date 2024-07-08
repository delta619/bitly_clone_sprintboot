package com.delta619.bitly.clone.data.entity.data;

import jakarta.persistence.*;
import lombok.Data;
import lombok.ToString;


@Entity
@Table(name = "BitlyURLs")
@Data
@ToString
public class BitlyURL {
    @Id
    @Column(name = "bitlyurlid")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "bitlyurl", nullable = false, unique = true)
    private String bitlyurl;

    @Column(name = "origurl", nullable = false)
    private String origurl;

    @Column(name = "owner", nullable = false)
    private String owner;

}