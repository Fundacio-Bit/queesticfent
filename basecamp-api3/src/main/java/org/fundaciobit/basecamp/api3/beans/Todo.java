
package org.fundaciobit.basecamp.api3.beans;

import java.util.Date;
import java.util.List;
//import com.fasterxml.jackson.annotation.JsonInclude;
import com.google.gson.annotations.SerializedName;
//import com.fasterxml.jackson.annotation.JsonPropertyOrder;

//@JsonInclude(JsonInclude.Include.NON_NULL)
/*@JsonPropertyOrder({ "id", "status", "visible_to_clients", "created_at", "updated_at", "title", "inherits_status",
        "type", "url", "app_url", "bookmark_url", "subscription_url", "comments_count", "comments_url", "parent",
        "bucket", "creator", "description", "completed", "completion", "content", "starts_on", "due_on", "assignees",
        "completion_subscribers", "completion_url" })*/
public class Todo {

    @SerializedName("id")
    private Long id;
    @SerializedName("status")
    private String status;
    @SerializedName("visible_to_clients")
    private Boolean visibleToClients;
    @SerializedName("created_at")
    private String createdAt;
    @SerializedName("updated_at")
    private Date updatedAt;
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
    @SerializedName("parent")
    private Parent parent;
    @SerializedName("bucket")
    private Bucket bucket;
    @SerializedName("creator")
    private Creator creator;
    @SerializedName("description")
    private String description;
    @SerializedName("completed")
    private Boolean completed;
    @SerializedName("completion")
    private Completion completion;
    @SerializedName("content")
    private String content;
    @SerializedName("starts_on")
    private Object startsOn;
    @SerializedName("due_on")
    private Object dueOn;
    @SerializedName("assignees")
    private List<Assignee> assignees = null;
    @SerializedName("completion_subscribers")
    private List<Object> completionSubscribers = null;
    @SerializedName("completion_url")
    private String completionUrl;
    @SerializedName("position")
    private Integer position;

    /**
     * No args constructor for use in serialization
     * 
     */
    public Todo() {
    }

    /**
     * 
     * @param parent
     * @param dueOn
     * @param completionSubscribers
     * @param description
     * @param assignees
     * @param completionUrl
     * @param title
     * @param type
     * @param content
     * @param visibleToClients
     * @param createdAt
     * @param id
     * @param updatedAt
     * @param completion
     * @param creator
     * @param appUrl
     * @param completed
     * @param bookmarkUrl
     * @param startsOn
     * @param url
     * @param bucket
     * @param commentsUrl
     * @param commentsCount
     * @param inheritsStatus
     * @param status
     * @param subscriptionUrl
     */
    public Todo(Long id, String status, Boolean visibleToClients, String createdAt, Date updatedAt, String title,
            Boolean inheritsStatus, String type, String url, String appUrl, String bookmarkUrl, String subscriptionUrl,
            Long commentsCount, String commentsUrl, Parent parent, Bucket bucket, Creator creator, String description,
            Boolean completed, Completion completion, String content, Object startsOn, Object dueOn,
            List<Assignee> assignees, List<Object> completionSubscribers, String completionUrl, Integer position) {
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
        this.parent = parent;
        this.bucket = bucket;
        this.creator = creator;
        this.description = description;
        this.completed = completed;
        this.completion = completion;
        this.content = content;
        this.startsOn = startsOn;
        this.dueOn = dueOn;
        this.assignees = assignees;
        this.completionSubscribers = completionSubscribers;
        this.completionUrl = completionUrl;
        this.position = position;
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
    public Date getUpdatedAt() {
        return updatedAt;
    }

    @SerializedName("updated_at")
    public void setUpdatedAt(Date updatedAt) {
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

    @SerializedName("completed")
    public Boolean getCompleted() {
        return completed;
    }

    @SerializedName("completed")
    public void setCompleted(Boolean completed) {
        this.completed = completed;
    }

    @SerializedName("completion")
    public Completion getCompletion() {
        return completion;
    }

    @SerializedName("completion")
    public void setCompletion(Completion completion) {
        this.completion = completion;
    }

    @SerializedName("content")
    public String getContent() {
        return content;
    }

    @SerializedName("content")
    public void setContent(String content) {
        this.content = content;
    }

    @SerializedName("starts_on")
    public Object getStartsOn() {
        return startsOn;
    }

    @SerializedName("starts_on")
    public void setStartsOn(Object startsOn) {
        this.startsOn = startsOn;
    }

    @SerializedName("due_on")
    public Object getDueOn() {
        return dueOn;
    }

    @SerializedName("due_on")
    public void setDueOn(Object dueOn) {
        this.dueOn = dueOn;
    }

    @SerializedName("assignees")
    public List<Assignee> getAssignees() {
        return assignees;
    }

    @SerializedName("assignees")
    public void setAssignees(List<Assignee> assignees) {
        this.assignees = assignees;
    }

    @SerializedName("completion_subscribers")
    public List<Object> getCompletionSubscribers() {
        return completionSubscribers;
    }

    @SerializedName("completion_subscribers")
    public void setCompletionSubscribers(List<Object> completionSubscribers) {
        this.completionSubscribers = completionSubscribers;
    }

    @SerializedName("completion_url")
    public String getCompletionUrl() {
        return completionUrl;
    }

    @SerializedName("completion_url")
    public void setCompletionUrl(String completionUrl) {
        this.completionUrl = completionUrl;
    }

    public Integer getPosition() {
        return position;
    }

    public void setPosition(Integer position) {
        this.position = position;
    }

}
