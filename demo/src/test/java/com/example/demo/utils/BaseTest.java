package com.example.demo.utils;

import org.springframework.beans.factory.annotation.Value;

/**
 * @author bruno.alves.rocha
 */
public class BaseTest {

    @Value("${local.server.port}")
    private int port=0;

    protected String url (final String context) {
        return "http://localhost:" + port + context;
    }
}
