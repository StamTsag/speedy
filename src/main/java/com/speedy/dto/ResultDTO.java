package com.speedy.dto;

public class ResultDTO {
    public String link;
    public String href;
    public int latencyMs;
    public int downloadMbps;

    public ResultDTO(String link, int latencyMs, int downloadMbps) {
        this.link = link;
        this.href = "https://speedy.stamtsag.com/" + link;
        this.latencyMs = latencyMs;
        this.downloadMbps = downloadMbps;
    }
}
