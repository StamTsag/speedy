package com.speedy.entities;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "results")
public class Result {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private String link;

    @Column(nullable = false)
    private int latencyMs;

    @Column(nullable = false)
    private int downloadMbps;

    @Column(name = "created_at")
    private LocalDateTime createdAt;

    // Getters and setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public int getDownloadMbps() {
        return downloadMbps;
    }

    public void setDownloadMbps(int downloadMbps) {
        this.downloadMbps = downloadMbps;
    }

    public int getLatencyMs() {
        return latencyMs;
    }

    public void setLatency(int latencyMs) {
        this.latencyMs = latencyMs;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    @PrePersist
    public void prePersist() {
        this.createdAt = LocalDateTime.now();
    }
}
