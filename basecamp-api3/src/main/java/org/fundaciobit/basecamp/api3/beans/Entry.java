
package org.fundaciobit.basecamp.api3.beans;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.Generated;
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
    "parent",
    "bucket",
    "creator",
    "description",
    "summary",
    "all_day",
    "starts_at",
    "ends_at",
    "participants",
    "recurrence_schedule"
})*/
@Generated("jsonschema2pojo")
public class Entry {

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
    private Integer commentsCount;
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
    @SerializedName("summary")
    private String summary;
    @SerializedName("all_day")
    private Boolean allDay;
    @SerializedName("starts_at")
    private String startsAt;
    @SerializedName("ends_at")
    private String endsAt;
    @SerializedName("participants")
    private List<Participant> participants;
    @SerializedName("recurrence_schedule")
    private RecurrenceSchedule recurrenceSchedule;
    //@JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

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
    public Integer getCommentsCount() {
        return commentsCount;
    }

    @SerializedName("comments_count")
    public void setCommentsCount(Integer commentsCount) {
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

    @SerializedName("summary")
    public String getSummary() {
        return summary;
    }

    @SerializedName("summary")
    public void setSummary(String summary) {
        this.summary = summary;
    }

    @SerializedName("all_day")
    public Boolean getAllDay() {
        return allDay;
    }

    @SerializedName("all_day")
    public void setAllDay(Boolean allDay) {
        this.allDay = allDay;
    }

    @SerializedName("starts_at")
    public String getStartsAt() {
        return startsAt;
    }

    @SerializedName("starts_at")
    public void setStartsAt(String startsAt) {
        this.startsAt = startsAt;
    }

    @SerializedName("ends_at")
    public String getEndsAt() {
        return endsAt;
    }

    @SerializedName("ends_at")
    public void setEndsAt(String endsAt) {
        this.endsAt = endsAt;
    }

    @SerializedName("participants")
    public List<Participant> getParticipants() {
        return participants;
    }

    @SerializedName("participants")
    public void setParticipants(List<Participant> participants) {
        this.participants = participants;
    }

    @SerializedName("recurrence_schedule")
    public RecurrenceSchedule getRecurrenceSchedule() {
        return recurrenceSchedule;
    }

    @SerializedName("recurrence_schedule")
    public void setRecurrenceSchedule(RecurrenceSchedule recurrenceSchedule) {
        this.recurrenceSchedule = recurrenceSchedule;
    }

    //@JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    //@JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class ").append(this.getClass().getSimpleName()).append(" {\n");
        sb.append("id");
        sb.append('=');
        sb.append(((this.id == null) ? "<null>" : this.id));
        sb.append("\n\t");
        sb.append("status");
        sb.append('=');
        sb.append(((this.status == null) ? "<null>" : this.status));
        sb.append("\n\t");
        sb.append("visibleToClients");
        sb.append('=');
        sb.append(((this.visibleToClients == null) ? "<null>" : this.visibleToClients));
        sb.append("\n\t");
        sb.append("createdAt");
        sb.append('=');
        sb.append(((this.createdAt == null) ? "<null>" : this.createdAt));
        sb.append("\n\t");
        sb.append("updatedAt");
        sb.append('=');
        sb.append(((this.updatedAt == null) ? "<null>" : this.updatedAt));
        sb.append("\n\t");
        sb.append("title");
        sb.append('=');
        sb.append(((this.title == null) ? "<null>" : this.title));
        sb.append("\n\t");
        sb.append("inheritsStatus");
        sb.append('=');
        sb.append(((this.inheritsStatus == null) ? "<null>" : this.inheritsStatus));
        sb.append("\n\t");
        sb.append("type");
        sb.append('=');
        sb.append(((this.type == null) ? "<null>" : this.type));
        sb.append("\n\t");
        sb.append("url");
        sb.append('=');
        sb.append(((this.url == null) ? "<null>" : this.url));
        sb.append("\n\t");
        sb.append("appUrl");
        sb.append('=');
        sb.append(((this.appUrl == null) ? "<null>" : this.appUrl));
        sb.append("\n\t");
        sb.append("bookmarkUrl");
        sb.append('=');
        sb.append(((this.bookmarkUrl == null) ? "<null>" : this.bookmarkUrl));
        sb.append("\n\t");
        sb.append("subscriptionUrl");
        sb.append('=');
        sb.append(((this.subscriptionUrl == null) ? "<null>" : this.subscriptionUrl));
        sb.append("\n\t");
        sb.append("commentsCount");
        sb.append('=');
        sb.append(((this.commentsCount == null) ? "<null>" : this.commentsCount));
        sb.append("\n\t");
        sb.append("commentsUrl");
        sb.append('=');
        sb.append(((this.commentsUrl == null) ? "<null>" : this.commentsUrl));
        sb.append("\n\t");
        sb.append("parent");
        sb.append('=');
        sb.append(((this.parent == null) ? "<null>" : this.parent));
        sb.append("\n\t");
        sb.append("bucket");
        sb.append('=');
        sb.append(((this.bucket == null) ? "<null>" : this.bucket));
        sb.append("\n\t");
        sb.append("creator");
        sb.append('=');
        sb.append(((this.creator == null) ? "<null>" : this.creator));
        sb.append("\n\t");
        sb.append("description");
        sb.append('=');
        sb.append(((this.description == null) ? "<null>" : this.description));
        sb.append("\n\t");
        sb.append("summary");
        sb.append('=');
        sb.append(((this.summary == null) ? "<null>" : this.summary));
        sb.append("\n\t");
        sb.append("allDay");
        sb.append('=');
        sb.append(((this.allDay == null) ? "<null>" : this.allDay));
        sb.append("\n\t");
        sb.append("startsAt");
        sb.append('=');
        sb.append(((this.startsAt == null) ? "<null>" : this.startsAt));
        sb.append("\n\t");
        sb.append("endsAt");
        sb.append('=');
        sb.append(((this.endsAt == null) ? "<null>" : this.endsAt));
        sb.append("\n\t");
        sb.append("participants");
        sb.append('=');
        sb.append(((this.participants == null) ? "<null>" : this.participants));
        sb.append("\n\t");
        if (sb.charAt((sb.length() - 1)) == ',') {
            sb.setCharAt((sb.length() - 1), '}');
        } else {
            sb.append('}');
        }
        return sb.toString();
    }

}
