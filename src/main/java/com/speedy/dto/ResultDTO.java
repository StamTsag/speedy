package com.speedy.dto;

public class ResultDTO {
    public String link;
    public String href;
    public int latencyMs;
    public int downloadMbps;
    public String country;
    public String server;

    public ResultDTO(String link, int latencyMs, int downloadMbps, String country, String server) {
        this.link = link;
        this.href = "https://speedy.stamtsag.com/" + link;
        this.latencyMs = latencyMs;
        this.downloadMbps = downloadMbps;
        this.country = country;
        this.server = server;
    }
}
