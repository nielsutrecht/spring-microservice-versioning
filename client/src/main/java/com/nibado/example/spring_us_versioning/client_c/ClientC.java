package com.nibado.example.spring_us_versioning.client_c;

import com.nibado.example.spring_us_versioning.BaseClient;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.util.UUID;

@Slf4j
public class ClientC extends BaseClient {
    public ClientC() {
        super(3);
    }

    public void doWork() throws IOException {
        User user = super.getAs("http://localhost:8080/user/" + new UUID(0, 0), User.class);
        log.info("Got v3 user: {}", user);
    }
}
