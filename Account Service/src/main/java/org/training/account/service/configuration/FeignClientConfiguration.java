package org.training.account.service.configuration;

import feign.codec.ErrorDecoder;
import org.springframework.cloud.openfeign.FeignClientProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FeignClientConfiguration extends FeignClientProperties.FeignClientConfiguration {

    /**
     * Returns a new instance of ErrorDecoder that is used to decode errors from a Feign client.
     *
     * @return a new instance of ErrorDecoder
     */
    @Bean
    public ErrorDecoder errorDecoder() {
        return new FeignClientErrorDecoder();
    }
}
