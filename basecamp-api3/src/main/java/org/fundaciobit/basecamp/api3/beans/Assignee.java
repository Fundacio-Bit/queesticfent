
package org.fundaciobit.basecamp.api3.beans;

import com.google.gson.annotations.SerializedName;

////import com.fasterxml.jackson.annotation.JsonInclude;
//import com.google.gson.annotations.SerializedName;
////import com.fasterxml.jackson.annotation.JsonPropertyOrder;

//@JsonInclude(JsonInclude.Include.NON_NULL)
//@JsonPropertyOrder({ "id", "attachable_sgid", "name", "email_address", "personable_type", "title", "bio", "created_at",        "updated_at", "admin", "owner", "client", "time_zone", "avatar_url", "company" })
public class Assignee {

    @SerializedName("id")
    private Long id;
    @SerializedName("attachable_sgid")
    private String attachableSgid;
    @SerializedName("name")
    private String name;
    @SerializedName("email_address")
    private String emailAddress;
    @SerializedName("personable_type")
    private String personableType;
    @SerializedName("title")
    private String title;
    @SerializedName("bio")
    private String bio;
    @SerializedName("created_at")
    private String createdAt;
    @SerializedName("updated_at")
    private String updatedAt;
    @SerializedName("admin")
    private Boolean admin;
    @SerializedName("owner")
    private Boolean owner;
    @SerializedName("client")
    private Boolean client;
    @SerializedName("time_zone")
    private String timeZone;
    @SerializedName("avatar_url")
    private String avatarUrl;
    @SerializedName("company")
    private Company company;

    /**
     * No args constructor for use in serialization
     * 
     */
    public Assignee() {
    }

    /**
     * 
     * @param owner
     * @param personableType
     * @param avatarUrl
     * @param bio
     * @param admin
     * @param timeZone
     * @param title
     * @param createdAt
     * @param emailAddress
     * @param attachableSgid
     * @param name
     * @param client
     * @param company
     * @param id
     * @param updatedAt
     */
    public Assignee(Long id, String attachableSgid, String name, String emailAddress, String personableType,
            String title, String bio, String createdAt, String updatedAt, Boolean admin, Boolean owner, Boolean client,
            String timeZone, String avatarUrl, Company company) {
        super();
        this.id = id;
        this.attachableSgid = attachableSgid;
        this.name = name;
        this.emailAddress = emailAddress;
        this.personableType = personableType;
        this.title = title;
        this.bio = bio;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.admin = admin;
        this.owner = owner;
        this.client = client;
        this.timeZone = timeZone;
        this.avatarUrl = avatarUrl;
        this.company = company;
    }

    @SerializedName("id")
    public Long getId() {
        return id;
    }

    @SerializedName("id")
    public void setId(Long id) {
        this.id = id;
    }

    @SerializedName("attachable_sgid")
    public String getAttachableSgid() {
        return attachableSgid;
    }

    @SerializedName("attachable_sgid")
    public void setAttachableSgid(String attachableSgid) {
        this.attachableSgid = attachableSgid;
    }

    @SerializedName("name")
    public String getName() {
        return name;
    }

    @SerializedName("name")
    public void setName(String name) {
        this.name = name;
    }

    @SerializedName("email_address")
    public String getEmailAddress() {
        return emailAddress;
    }

    @SerializedName("email_address")
    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    @SerializedName("personable_type")
    public String getPersonableType() {
        return personableType;
    }

    @SerializedName("personable_type")
    public void setPersonableType(String personableType) {
        this.personableType = personableType;
    }

    @SerializedName("title")
    public String getTitle() {
        return title;
    }

    @SerializedName("title")
    public void setTitle(String title) {
        this.title = title;
    }

    @SerializedName("bio")
    public String getBio() {
        return bio;
    }

    @SerializedName("bio")
    public void setBio(String bio) {
        this.bio = bio;
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

    @SerializedName("admin")
    public Boolean getAdmin() {
        return admin;
    }

    @SerializedName("admin")
    public void setAdmin(Boolean admin) {
        this.admin = admin;
    }

    @SerializedName("owner")
    public Boolean getOwner() {
        return owner;
    }

    @SerializedName("owner")
    public void setOwner(Boolean owner) {
        this.owner = owner;
    }

    @SerializedName("client")
    public Boolean getClient() {
        return client;
    }

    @SerializedName("client")
    public void setClient(Boolean client) {
        this.client = client;
    }

    @SerializedName("time_zone")
    public String getTimeZone() {
        return timeZone;
    }

    @SerializedName("time_zone")
    public void setTimeZone(String timeZone) {
        this.timeZone = timeZone;
    }

    @SerializedName("avatar_url")
    public String getAvatarUrl() {
        return avatarUrl;
    }

    @SerializedName("avatar_url")
    public void setAvatarUrl(String avatarUrl) {
        this.avatarUrl = avatarUrl;
    }

    @SerializedName("company")
    public Company getCompany() {
        return company;
    }

    @SerializedName("company")
    public void setCompany(Company company) {
        this.company = company;
    }

}
