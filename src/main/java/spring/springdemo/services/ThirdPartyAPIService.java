package spring.springdemo.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import spring.springdemo.models.GitProfile;
import spring.springdemo.models.User;

@Service
public class ThirdPartyAPIService {
    @Autowired
    private RestTemplate getRestTemplate;

    public GitProfile getUserProfile() {
        final String urls ="https://api.github.com/users/masterscode";
        return getRestTemplate.getForObject(urls, GitProfile.class);

    }
}
