package com.easemob.githubstat;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

/**
 * Created by wangchunye on 8/24/16.
 */
@Data
public class YourOrg {
    private String url;
    private String state;
    private String role;
    @JsonProperty("organization_url")
    private String organizationUrl;
    private Organization organization;
    @Data
    public static class Organization {
        private String login;
        private String id;
        private String url;
        @JsonProperty("repos_url")
        private String reposUrl;
        @JsonProperty("events_url")
        private String eventsUrl;
        @JsonProperty("hooks_url")
        private String hooksUrl;
        @JsonProperty("issues_url")
        private String issuesUrl;
        @JsonProperty("members_url")
        private String membersUrl;
        @JsonProperty("public_members_url")
        private String publicMembersUrl;
        @JsonProperty("avatar_url")
        private String avatarUrl;
        private String description;
    }
    private User user;
    @Data
    static public class User {
        private String login;
        private String id;
        @JsonProperty("avatar_url")
        private String avatarUrl;
        @JsonProperty("gravatar_id")
        private String gravatarId;
        private String url;
        @JsonProperty("html_url")
        private String htmlUrl;
        @JsonProperty("followers_url")
        private String followersUrl;
        @JsonProperty("following_url")
        private String followingUrl;
        @JsonProperty("gists_url")
        private String gistsUrl;
        @JsonProperty("starred_url")
        private String starredUrl;
        @JsonProperty("subscriptions_url")
        private String subscriptionsUrl;
        @JsonProperty("organizations_url")
        private String organizationsUrl;
        private String repos_url;
        private String events_url;
        @JsonProperty("received_events_url")
        private String receivedEvents_url;
        private String type;
        private String site_admin;
    }
}
