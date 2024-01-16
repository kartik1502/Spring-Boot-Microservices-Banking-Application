package org.training.account.service.configuration;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import feign.Response;
import feign.codec.ErrorDecoder;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.io.IOUtils;
import org.training.account.service.exception.GlobalException;

import java.io.IOException;
import java.io.Reader;
import java.nio.charset.StandardCharsets;
import java.util.Objects;

@Slf4j
public class FeignClientErrorDecoder implements ErrorDecoder {

    /**
     * Decode the response and return an Exception object.
     *
     * @param s        the response string
     * @param response the HTTP response object
     * @return an Exception object representing the decoded response
     */
    @Override
    public Exception decode(String s, Response response) {

        GlobalException globalException = extractGlobalException(response);

        log.info("response status: "+response.status());
        if (response.status() == 400) {
            log.error("Error in request went through feign client: {}", globalException.getErrorMessage() + " - " + globalException.getErrorCode());
            return globalException;
        }
        log.error("general exception went through feign client");
        return new Exception();
    }

    /**
     * Extracts a GlobalException object from the response.
     *
     * @param response The response object containing the exception information
     * @return The GlobalException object extracted from the response, or null if extraction fails
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