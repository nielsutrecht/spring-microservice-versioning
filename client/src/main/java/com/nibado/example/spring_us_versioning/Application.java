package com.nibado.example.spring_us_versioning;

import com.nibado.example.spring_us_versioning.client_a.ClientA;
import com.nibado.example.spring_us_versioning.client_b.ClientB;
import com.nibado.example.spring_us_versioning.client_c.ClientC;

public class Application {
    public static void main(String... argv) throws Exception {
        new ClientA().doWork();
        new ClientB().doWork();
        new ClientC().doWork();
    }
}
