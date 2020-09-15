package com.example.demo;

import java.util.Date;

public class CatFacts implements Comparable<CatFacts> {
    private String text;
    private Date createdAt;
    private Date updatedAt;

    public CatFacts() {
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }

    @Override
    public int compareTo(CatFacts o) {
        return this.getCreatedAt().compareTo(o.createdAt);
    }

    @Override
    public String toString() {
        return "CatJoke{" +
                "text='" + text + '\'' +
                ", createdAt=" + createdAt +
                ", updatedAt=" + updatedAt +
                '}';
    }

}