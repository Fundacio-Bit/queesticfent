
package org.fundaciobit.basecamp.api3.beans;

import java.util.HashMap;
import java.util.Map;
//import com.fasterxml.jackson.annotation.JsonAnyGetter;
//import com.fasterxml.jackson.annotation.JsonAnySetter;
//import com.fasterxml.jackson.annotation.JsonIgnore;
//import com.fasterxml.jackson.annotation.JsonInclude;
import com.google.gson.annotations.SerializedName;
//import com.fasterxml.jackson.annotation.JsonPropertyOrder;

//@JsonInclude(JsonInclude.Include.NON_NULL)
/*@JsonPropertyOrder({
    "id",
    "status",
    "visible_to_clients",
    "created_at",
    "updated_at",
    "title",
    "inherits_status",
    "type",
    "url",
    "app_url",
    "bookmark_url",
    "subscription_url",
    "comments_count",
    "comments_url",
    "position",
    "parent",
    "bucket",
    "creator",
    "description",
    "content_type",
    "byte_size",
    "filename",
    "download_url",
    "app_download_url",
    "width",
    "height"
})*/
/**
 * 
 * @author anadal
 *
 */
public class Upload {

    @SerializedName("id")
    private Long id;
    @SerializedName("status")
    private String status;
    @SerializedName("visible_to_clients")
    private Boolean visibleToClients;
    @SerializedName("created_at")
    private String createdAt;
    @SerializedName("updated_at")
    private String updatedAt;
    @SerializedName("title")
    private String title;
    @SerializedName("inherits_status")
    private Boolean inheritsStatus;
    @SerializedName("type")
    private String type;
    @SerializedName("url")
    private String url;
    @SerializedName("app_url")
    private String appUrl;
    @SerializedName("bookmark_url")
    private String bookmarkUrl;
    @SerializedName("subscription_url")
    private String subscriptionUrl;
    @SerializedName("comments_count")
    private Long commentsCount;
    @SerializedName("comments_url")
    private String commentsUrl;
    @SerializedName("position")
    private Long position;
    @SerializedName("parent")
    private Parent parent;
    @SerializedName("bucket")
    private Bucket bucket;
    @SerializedName("creator")
    private Creator creator;
    @SerializedName("description")
    private String description;
    @SerializedName("content_type")
    private String contentType;
    @SerializedName("byte_size")
    private Long byteSize;
    @SerializedName("filename")
    private String filename;
    @SerializedName("download_url")
    private String downloadUrl;
    @SerializedName("app_download_url")
    private String appDownloadUrl;
    @SerializedName("width")
    private Long width;
    @SerializedName("height")
    private Long height;
    //@JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     * 
     */
    public Upload() {
    }

    /**
     * 
     * @param parent
     * @param byteSize
     * @param downloadUrl
     * @param description
     * @param title
     * @param type
     * @param visibleToClients
     * @param createdAt
     * @param id
     * @param contentType
     * @param updatedAt
     * @param height
     * @param creator
     * @param appUrl
     * @param appDownloadUrl
     * @param bookmarkUrl
     * @param url
     * @param bucket
     * @param filename
     * @param commentsUrl
     * @param commentsCount
     * @param width
     * @param position
     * @param inheritsStatus
     * @param status
     * @param subscriptionUrl
     */
    public Upload(Long id, String status, Boolean visibleToClients, String createdAt, String updatedAt, String title, Boolean inheritsStatus, String type, String url, String appUrl, String bookmarkUrl, String subscriptionUrl, Long commentsCount, String commentsUrl, Long position, Parent parent, Bucket bucket, Creator creator, String description, String contentType, Long byteSize, String filename, String downloadUrl, String appDownloadUrl, Long width, Long height) {
        super();
        this.id = id;
        this.status = status;
        this.visibleToClients = visibleToClients;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.title = title;
        this.inheritsStatus = inheritsStatus;
        this.type = type;
        this.url = url;
        this.appUrl = appUrl;
        this.bookmarkUrl = bookmarkUrl;
        this.subscriptionUrl = subscriptionUrl;
        this.commentsCount = commentsCount;
        this.commentsUrl = commentsUrl;
        this.position = position;
        this.parent = parent;
        this.bucket = bucket;
        this.creator = creator;
        this.description = description;
        this.contentType = contentType;
        this.byteSize = byteSize;
        this.filename = filename;
        this.downloadUrl = downloadUrl;
        this.appDownloadUrl = appDownloadUrl;
        this.width = width;
        this.height = height;
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

    @SerializedName("visible_to_clients")
    public Boolean getVisibleToClients() {
        return visibleToClients;
    }

    @SerializedName("visible_to_clients")
    public void setVisibleToClients(Boolean visibleToClients) {
        this.visibleToClients = visibleToClients;
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

    @SerializedName("title")
    public String getTitle() {
        return title;
    }

    @SerializedName("title")
    public void setTitle(String title) {
        this.title = title;
    }

    @SerializedName("inherits_status")
    public Boolean getInheritsStatus() {
        return inheritsStatus;
    }

    @SerializedName("inherits_status")
    public void setInheritsStatus(Boolean inheritsStatus) {
        this.inheritsStatus = inheritsStatus;
    }

    @SerializedName("type")
    public String getType() {
        return type;
    }

    @SerializedName("type")
    public void setType(String type) {
        this.type = type;
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

    @SerializedName("bookmark_url")
    public String getBookmarkUrl() {
        return bookmarkUrl;
    }

    @SerializedName("bookmark_url")
    public void setBookmarkUrl(String bookmarkUrl) {
        this.bookmarkUrl = bookmarkUrl;
    }

    @SerializedName("subscription_url")
    public String getSubscriptionUrl() {
        return subscriptionUrl;
    }

    @SerializedName("subscription_url")
    public void setSubscriptionUrl(String subscriptionUrl) {
        this.subscriptionUrl = subscriptionUrl;
    }

    @SerializedName("comments_count")
    public Long getCommentsCount() {
        return commentsCount;
    }

    @SerializedName("comments_count")
    public void setCommentsCount(Long commentsCount) {
        this.commentsCount = commentsCount;
    }

    @SerializedName("comments_url")
    public String getCommentsUrl() {
        return commentsUrl;
    }

    @SerializedName("comments_url")
    public void setCommentsUrl(String commentsUrl) {
        this.commentsUrl = commentsUrl;
    }

    @SerializedName("position")
    public Long getPosition() {
        return position;
    }

    @SerializedName("position")
    public void setPosition(Long position) {
        this.position = position;
    }

    @SerializedName("parent")
    public Parent getParent() {
        return parent;
    }

    @SerializedName("parent")
    public void setParent(Parent parent) {
        this.parent = parent;
    }

    @SerializedName("bucket")
    public Bucket getBucket() {
        return bucket;
    }

    @SerializedName("bucket")
    public void setBucket(Bucket bucket) {
        this.bucket = bucket;
    }

    @SerializedName("creator")
    public Creator getCreator() {
        return creator;
    }

    @SerializedName("creator")
    public void setCreator(Creator creator) {
        this.creator = creator;
    }

    @SerializedName("description")
    public String getDescription() {
        return description;
    }

    @SerializedName("description")
    public void setDescription(String description) {
        this.description = description;
    }

    @SerializedName("content_type")
    public String getContentType() {
        return contentType;
    }

    @SerializedName("content_type")
    public void setContentType(String contentType) {
        this.contentType = contentType;
    }

    @SerializedName("byte_size")
    public Long getByteSize() {
        return byteSize;
    }

    @SerializedName("byte_size")
    public void setByteSize(Long byteSize) {
        this.byteSize = byteSize;
    }

    @SerializedName("filename")
    public String getFilename() {
        return filename;
    }

    @SerializedName("filename")
    public void setFilename(String filename) {
        this.filename = filename;
    }

    @SerializedName("download_url")
    public String getDownloadUrl() {
        return downloadUrl;
    }

    @SerializedName("download_url")
    public void setDownloadUrl(String downloadUrl) {
        this.downloadUrl = downloadUrl;
    }

    @SerializedName("app_download_url")
    public String getAppDownloadUrl() {
        return appDownloadUrl;
    }

    @SerializedName("app_download_url")
    public void setAppDownloadUrl(String appDownloadUrl) {
        this.appDownloadUrl = appDownloadUrl;
    }

    @SerializedName("width")
    public Long getWidth() {
        return width;
    }

    @SerializedName("width")
    public void setWidth(Long width) {
        this.width = width;
    }

    @SerializedName("height")
    public Long getHeight() {
        return height;
    }

    @SerializedName("height")
    public void setHeight(Long height) {
        this.height = height;
    }

    //@JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    //@JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
