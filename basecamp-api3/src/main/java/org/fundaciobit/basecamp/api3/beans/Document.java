package org.fundaciobit.basecamp.api3.beans;

public class Document {

    private long id;
    private String status;
    private String created_at;
    private String updated_at;
    private String title;
    private String content;
    private String app_url;
    private String url;

    public long getId() { return id; }
    public void setId(long id) { this.id = id; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }

    public String getCreated_at() { return created_at; }
    public void setCreated_at(String created_at) { this.created_at = created_at; }

    public String getUpdated_at() { return updated_at; }
    public void setUpdated_at(String updated_at) { this.updated_at = updated_at; }

    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }

    public String getContent() { return content; }
    public void setContent(String content) { this.content = content; }

    public String getApp_url() { return app_url; }
    public void setApp_url(String app_url) { this.app_url = app_url; }

    public String getUrl() { return url; }
    public void setUrl(String url) { this.url = url; }
}
