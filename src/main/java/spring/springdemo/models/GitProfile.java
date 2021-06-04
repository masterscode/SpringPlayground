package spring.springdemo.models;

import lombok.Data;

import java.time.LocalDate;

@Data
public class GitProfile {

    private String login;
    private String id, node_id, gravatar_id;
    private String avatar_url;
    private String url;
    private String html_url;
    private String followers_url;
    private String following_url;
    private String gists_url;
    private String starred_url;
    private String subscriptions_url;


    private Boolean hireable, site_admin;
    private String organizations_url,
                    repos_url,
                    events_url,
                    received_events_url,
                    twitter_username,
                    bio,
                    email,
                    location,
                    blog,
                    company,
                    name, type;
    private String followers, following, public_repos, public_gists;
    private LocalDate created_at, updated_at;

}
