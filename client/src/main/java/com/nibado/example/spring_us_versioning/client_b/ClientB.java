package com.nibado.example.spring_us_versioning.client_b;

import com.nibado.example.spring_us_versioning.BaseClient;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;

@Slf4j
public class ClientB extends BaseClient {
    public ClientB() {
        super(2);
    }

    public void doWork() throws IOException {
        User user = super.getAs("http://localhost:8080/user/0", User.class);
        log.info("Got v2 user: {}", user);
    }
}
