package com.nibado.example.spring_us_versioning;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;

import java.io.IOException;

public abstract class BaseClient {
    private static final String PROTOCOL_VERSION_HEADER = "X-Protocol-Version";
    private static final ThreadLocal<ObjectMapper> MAPPER = ThreadLocal.withInitial(ObjectMapper::new);
    private final int protocolVersion;
    private final OkHttpClient client = new OkHttpClient();

    public BaseClient(final int protocolVersion) {
        this.protocolVersion = protocolVersion;
    }

    public <T> T getAs(String url, Class<T> clazz) throws IOException {
        Request request = new Request.Builder()
                .url(url)
                .header(PROTOCOL_VERSION_HEADER, Integer.toString(protocolVersion))
                .build();

        Response response = client.newCall(request).execute();

        return MAPPER.get().readValue(response.body().byteStream(), clazz);
    }
}
