
package org.fundaciobit.basecamp.api3.beans;

import java.util.List;
//import com.fasterxml.jackson.annotation.JsonInclude;
import com.google.gson.annotations.SerializedName;
//import com.fasterxml.jackson.annotation.JsonPropertyOrder;

//@JsonInclude(JsonInclude.Include.NON_NULL)
/*@JsonPropertyOrder({
    "id",
    "status",
    "created_at",
    "updated_at",
    "name",
    "description",
    "purpose",
    "clients_enabled",
    "bookmark_url",
    "url",
    "app_url",
    "dock",
    "bookmarked"
})*/
public class Project {

    @SerializedName("id")
    private Long id;
    @SerializedName("status")
    private String status;
    @SerializedName("created_at")
    private String createdAt;
    @SerializedName("updated_at")
    private String updatedAt;
    @SerializedName("name")
    private String name;
    @SerializedName("description")
    private String description;
    @SerializedName("purpose")
    private String purpose;
    @SerializedName("clients_enabled")
    private Boolean clientsEnabled;
    @SerializedName("bookmark_url")
    private String bookmarkUrl;
    @SerializedName("url")
    private String url;
    @SerializedName("app_url")
    private String appUrl;
    @SerializedName("dock")
    private List<Dock> dock = null;
    @SerializedName("bookmarked")
    private Boolean bookmarked;

    /**
     * No args constructor for use in serialization
     * 
     */
    public Project() {
    }

    /**
     * 
     * @param purpose
     * @param bookmarked
     * @param description
     * @param appUrl
     * @param bookmarkUrl
     * @param url
     * @param createdAt
     * @param name
     * @param clientsEnabled
     * @param id
     * @param dock
     * @param status
     * @param updatedAt
     */
    public Project(Long id, String status, String createdAt, String updatedAt, String name, String description, String purpose, Boolean clientsEnabled, String bookmarkUrl, String url, String appUrl, List<Dock> dock, Boolean bookmarked) {
        super();
        this.id = id;
        this.status = status;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.name = name;
        this.description = description;
        this.purpose = purpose;
        this.clientsEnabled = clientsEnabled;
        this.bookmarkUrl = bookmarkUrl;
        this.url = url;
        this.appUrl = appUrl;
        this.dock = dock;
        this.bookmarked = bookmarked;
    }

    @SerializedName("id")
    public Long getId() {
        return id;
    }

    @SerializedName("id")
    public void setId(Long id) {
        this.id = id;
    }

    @SerializedName("status")
    public String getStatus() {
        return status;
    }

    @SerializedName("status")
    public void setStatus(String status) {
        this.status = status;
    }

    @SerializedName("created_at")
    public String getCreatedAt() {
        return createdAt;
    }

    @SerializedName("created_at")
    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    @SerializedName("updated_at")
    public String getUpdatedAt() {
        return updatedAt;
    }

    @SerializedName("updated_at")
    public void setUpdatedAt(String updatedAt) {
        this.updatedAt = updatedAt;
    }

    @SerializedName("name")
    public String getName() {
        return name;
    }

    @SerializedName("name")
    public void setName(String name) {
        this.name = name;
    }

    @SerializedName("description")
    public String getDescription() {
        return description;
    }

    @SerializedName("description")
    public void setDescription(String description) {
        this.description = description;
    }

    @SerializedName("purpose")
    public String getPurpose() {
        return purpose;
    }

    @SerializedName("purpose")
    public void setPurpose(String purpose) {
        this.purpose = purpose;
    }

    @SerializedName("clients_enabled")
    public Boolean getClientsEnabled() {
        return clientsEnabled;
    }

    @SerializedName("clients_enabled")
    public void setClientsEnabled(Boolean clientsEnabled) {
        this.clientsEnabled = clientsEnabled;
    }

    @SerializedName("bookmark_url")
    public String getBookmarkUrl() {
        return bookmarkUrl;
    }

    @SerializedName("bookmark_url")
    public void setBookmarkUrl(String bookmarkUrl) {
        this.bookmarkUrl = bookmarkUrl;
    }

    @SerializedName("url")
    public String getUrl() {
        return url;
    }

    @SerializedName("url")
    public void setUrl(String url) {
        this.url = url;
    }

    @SerializedName("app_url")
    public String getAppUrl() {
        return appUrl;
    }

    @SerializedName("app_url")
    public void setAppUrl(String appUrl) {
        this.appUrl = appUrl;
    }

    @SerializedName("dock")
    public List<Dock> getDock() {
        return dock;
    }

    @SerializedName("dock")
    public void setDock(List<Dock> dock) {
        this.dock = dock;
    }

    @SerializedName("bookmarked")
    public Boolean getBookmarked() {
        return bookmarked;
    }

    @SerializedName("bookmarked")
    public void setBookmarked(Boolean bookmarked) {
        this.bookmarked = bookmarked;
    }

}
