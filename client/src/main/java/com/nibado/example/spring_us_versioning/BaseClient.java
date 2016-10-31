package com.nibado.example.spring_us_versioning;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.http.client.fluent.Request;

import java.io.IOException;
import java.io.InputStream;

public abstract class BaseClient {
    private static final String PROTOCOL_VERSION_HEADER = "X-Protocol-Version";
    private static final ThreadLocal<ObjectMapper> MAPPER = ThreadLocal.withInitial(ObjectMapper::new);
    private final int protocolVersion;

    public BaseClient(final int protocolVersion) {
        this.protocolVersion = protocolVersion;
    }

    public <T> T getAs(String url, Class<T> clazz) throws IOException {
       InputStream ins = Request.Get(url)
                .addHeader(PROTOCOL_VERSION_HEADER, Integer.toString(protocolVersion))
                .connectTimeout(1000)
                .socketTimeout(1000)
                .execute().returnContent().asStream();

        return MAPPER.get().readValue(ins, clazz);
    }
}
