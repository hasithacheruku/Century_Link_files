package com.example.Spring_Boot_Demo.Beans;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Git_User {
	@JsonProperty("login")
	public String login;
	@JsonProperty("id")
	public int id;
	@JsonProperty("node_id")
	public String node_id;
	@JsonProperty("avatar_url")
	public String avatar_url;
	@JsonProperty("gravatar_id")
	public String gravatar_id;
	@JsonProperty("url")
	public String url;
	@JsonProperty("html_url")
    public String html_url;
	@JsonProperty("followers_url")
	public String followers_url;
	@JsonProperty("following_url")
	public String following_url;
	@JsonProperty("gists_url")
	public String gists_url;
	@JsonProperty("starred_url")
	public String starred_url;
	@JsonProperty("subscriptions_url")
	public String subscriptions_url;
	@JsonProperty("organizations_url")
	public String organizations_url;
	@JsonProperty("repos_url")
	public String repos_url;
	@JsonProperty("events_url")
	public String events_url;
	@JsonProperty("received_events_url")
	public String received_events_url;
	@JsonProperty("type")
	public String type;
	@JsonProperty("site_admin")
	public Boolean site_admin;
}
