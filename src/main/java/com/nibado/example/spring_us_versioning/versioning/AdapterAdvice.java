package com.nibado.example.spring_us_versioning.versioning;

import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

import static java.lang.Integer.parseInt;

@ControllerAdvice
public class AdapterAdvice implements ResponseBodyAdvice<Versioned> {

    @Override
    public boolean supports(MethodParameter methodParameter, Class<? extends HttpMessageConverter<?>> aClass) {
        return isVersioned(methodParameter);
    }

    @Override
    public Versioned beforeBodyWrite(
            Versioned versioned,
            MethodParameter methodParameter,
            MediaType mediaType,
            Class<? extends HttpMessageConverter<?>> aClass,
            ServerHttpRequest serverHttpRequest,
            ServerHttpResponse serverHttpResponse) {

        String version = serverHttpRequest.getHeaders().getFirst("X-Protocol-Version");

        if(version == null) {
            throw new RuntimeException("Missing 'X-Protocol-Version' header.");
        }

        return versioned.toVersion(parseInt(version));
    }

    private boolean isVersioned(final MethodParameter methodParameter) {
        for(Class<?> interf : ((Class<?>)methodParameter.getGenericParameterType()).getInterfaces()) {
            if(interf.equals(Versioned.class)) {
                return true;
            }
        }

        return false;
    }
}
