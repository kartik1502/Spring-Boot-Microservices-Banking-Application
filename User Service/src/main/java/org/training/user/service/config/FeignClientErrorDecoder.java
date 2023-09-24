package org.training.user.service.config;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import feign.Response;
import feign.codec.ErrorDecoder;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.io.IOUtils;
import org.training.user.service.exception.GlobalException;

import java.io.IOException;
import java.io.Reader;
import java.nio.charset.StandardCharsets;
import java.util.Objects;

@Slf4j
public class FeignClientErrorDecoder implements ErrorDecoder {

    /**
     * Overrides the decode method to handle exception decoding.
     *
     * @param s        The string being decoded.
     * @param response The response from the server.
     * @return The decoded exception.
     */
    @Override
    public Exception decode(String s, Response response) {

        GlobalException globalException = extractGlobalException(response);

        switch (response.status()) {
            case 400 -> {
                log.error("global exception is handled by feign client");
                return globalException;
            }
            default -> {
                log.error("common exception thrown");
                return new Exception();
            }
        }
    }

    /**
     * Extracts a GlobalException object from a Response object.
     *
     * @param response The Response object from which to extract the GlobalException.
     * @return The extracted GlobalException object, or null if extraction fails.
     */
    private GlobalException extractGlobalException(Response response) {

        GlobalException globalException = null;
        Reader reader = null;

        try {
            reader = response.body().asReader(StandardCharsets.UTF_8);
            String result = IOUtils.toString(reader);
            log.error(result);
            ObjectMapper mapper = new ObjectMapper();
            mapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
            globalException = mapper.readValue(result, GlobalException.class);
            log.error(globalException.toString());
        } catch (IOException e) {
            log.error("IO Exception while reading exception message", e);
        } finally {
            if (!Objects.isNull(reader)){
                try {
                    reader.close();
                } catch (IOException e) {
                    log.error("IO Exception while reading exception message", e);
                }
            }
        }
        return globalException;
    }
}
