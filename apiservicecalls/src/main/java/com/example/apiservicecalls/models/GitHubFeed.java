package com.example.apiservicecalls.models;

public class GitHubFeed {

    String name;
    String email;
    String avatar_url;

    public GitHubFeed(String name, String email, String avatar_url) {
        this.name = name;
        this.email = email;
        this.avatar_url = avatar_url;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAvatar_url() {
        return avatar_url;
    }

    public void setAvatar_url(String avatar_url) {
        this.avatar_url = avatar_url;
    }
}
