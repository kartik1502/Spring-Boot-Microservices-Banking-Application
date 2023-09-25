package org.training.fundtransfer.configuration;

import feign.codec.ErrorDecoder;
import org.springframework.cloud.openfeign.FeignClientProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FeignClientConfiguration extends FeignClientProperties.FeignClientConfiguration {

    /**
     * Returns the error decoder for the Feign client.
     *
     * @return the error decoder
     */
    @Bean
    public ErrorDecoder errorDecoder() {
        return new FeignClientErrorDecoder();
    }
}
