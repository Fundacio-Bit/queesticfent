
package org.fundaciobit.basecamp.api3.beans;

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
    "position",
    "parent",
    "bucket",
    "creator",
    "documents_count",
    "documents_url",
    "uploads_count",
    "uploads_url",
    "vaults_count",
    "vaults_url"
})*/
public class Folder {

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
    @SerializedName("position")
    private Long position;
    @SerializedName("parent")
    private Parent parent;
    @SerializedName("bucket")
    private Bucket bucket;
    @SerializedName("creator")
    private Creator creator;
    @SerializedName("documents_count")
    private Long documentsCount;
    @SerializedName("documents_url")
    private String documentsUrl;
    @SerializedName("uploads_count")
    private Long uploadsCount;
    @SerializedName("uploads_url")
    private String uploadsUrl;
    @SerializedName("vaults_count")
    private Long vaultsCount;
    @SerializedName("vaults_url")
    private String vaultsUrl;

    /**
     * No args constructor for use in serialization
     * 
     */
    public Folder() {
    }

    /**
     * 
     * @param parent
     * @param creator
     * @param documentsUrl
     * @param appUrl
     * @param title
     * @param type
     * @param bookmarkUrl
     * @param uploadsUrl
     * @param url
     * @param visibleToClients
     * @param bucket
     * @param createdAt
     * @param documentsCount
     * @param uploadsCount
     * @param vaultsCount
     * @param vaultsUrl
     * @param id
     * @param position
     * @param inheritsStatus
     * @param status
     * @param updatedAt
     */
    public Folder(Long id, String status, Boolean visibleToClients, String createdAt, String updatedAt, String title, Boolean inheritsStatus, String type, String url, String appUrl, String bookmarkUrl, Long position, Parent parent, Bucket bucket, Creator creator, Long documentsCount, String documentsUrl, Long uploadsCount, String uploadsUrl, Long vaultsCount, String vaultsUrl) {
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
        this.position = position;
        this.parent = parent;
        this.bucket = bucket;
        this.creator = creator;
        this.documentsCount = documentsCount;
        this.documentsUrl = documentsUrl;
        this.uploadsCount = uploadsCount;
        this.uploadsUrl = uploadsUrl;
        this.vaultsCount = vaultsCount;
        this.vaultsUrl = vaultsUrl;
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

    @SerializedName("documents_count")
    public Long getDocumentsCount() {
        return documentsCount;
    }

    @SerializedName("documents_count")
    public void setDocumentsCount(Long documentsCount) {
        this.documentsCount = documentsCount;
    }

    @SerializedName("documents_url")
    public String getDocumentsUrl() {
        return documentsUrl;
    }

    @SerializedName("documents_url")
    public void setDocumentsUrl(String documentsUrl) {
        this.documentsUrl = documentsUrl;
    }

    @SerializedName("uploads_count")
    public Long getUploadsCount() {
        return uploadsCount;
    }

    @SerializedName("uploads_count")
    public void setUploadsCount(Long uploadsCount) {
        this.uploadsCount = uploadsCount;
    }

    @SerializedName("uploads_url")
    public String getUploadsUrl() {
        return uploadsUrl;
    }

    @SerializedName("uploads_url")
    public void setUploadsUrl(String uploadsUrl) {
        this.uploadsUrl = uploadsUrl;
    }

    @SerializedName("vaults_count")
    public Long getVaultsCount() {
        return vaultsCount;
    }

    @SerializedName("vaults_count")
    public void setVaultsCount(Long vaultsCount) {
        this.vaultsCount = vaultsCount;
    }

    @SerializedName("vaults_url")
    public String getVaultsUrl() {
        return vaultsUrl;
    }

    @SerializedName("vaults_url")
    public void setVaultsUrl(String vaultsUrl) {
        this.vaultsUrl = vaultsUrl;
    }

}
