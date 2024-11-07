package org.training.user.service.utils;

import org.springframework.web.reactive.function.client.WebClient;

public class WebClientFactory {

    public static WebClient createWebClient() {
        return WebClient.create("https://example.org");
    }
}
