package spring.springdemo.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;
import spring.springdemo.models.GitProfile;
import spring.springdemo.models.User;

@Service
public class ThirdPartyAPIService {
    @Autowired
    private RestTemplate getRestTemplate;

    @Autowired
    private WebClient.Builder  builder;

    private final String urls ="https://api.github.com/users/masterscode";

    public GitProfile getUserProfile() {
        return getRestTemplate.getForObject(urls, GitProfile.class);
    }

    public GitProfile getUserProfileWithWebClient() {
        return builder.build()
                .get()
                .uri(urls)
                .retrieve()
                .bodyToMono(GitProfile.class)
                .block();
    }
}
