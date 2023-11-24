
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
//@JsonPropertyOrder({ "id", "attachable_sgid", "name", "email_address", "personable_type", "title", "bio", "created_at",    "updated_at", "admin", "owner", "client", "time_zone", "avatar_url", "company" })
public class Creator {

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

    public String attachable_sgid;
    public String email_address;
    public String personable_type;
    public Object location;
    public boolean employee;
    public String time_zone;
    public String avatar_url;
    public boolean can_ping;
    public boolean can_manage_projects;
    public boolean can_manage_people;
    //@JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     * 
     */
    public Creator() {
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

    //@JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    //@JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

    public String getAttachable_sgid() {
        return attachable_sgid;
    }

    public void setAttachable_sgid(String attachable_sgid) {
        this.attachable_sgid = attachable_sgid;
    }

    public String getEmail_address() {
        return email_address;
    }

    public void setEmail_address(String email_address) {
        this.email_address = email_address;
    }

    public String getPersonable_type() {
        return personable_type;
    }

    public void setPersonable_type(String personable_type) {
        this.personable_type = personable_type;
    }

    public Object getLocation() {
        return location;
    }

    public void setLocation(Object location) {
        this.location = location;
    }

    public boolean isEmployee() {
        return employee;
    }

    public void setEmployee(boolean employee) {
        this.employee = employee;
    }

    public String getTime_zone() {
        return time_zone;
    }

    public void setTime_zone(String time_zone) {
        this.time_zone = time_zone;
    }

    public String getAvatar_url() {
        return avatar_url;
    }

    public void setAvatar_url(String avatar_url) {
        this.avatar_url = avatar_url;
    }

    public boolean isCan_ping() {
        return can_ping;
    }

    public void setCan_ping(boolean can_ping) {
        this.can_ping = can_ping;
    }

    public boolean isCan_manage_projects() {
        return can_manage_projects;
    }

    public void setCan_manage_projects(boolean can_manage_projects) {
        this.can_manage_projects = can_manage_projects;
    }

    public boolean isCan_manage_people() {
        return can_manage_people;
    }

    public void setCan_manage_people(boolean can_manage_people) {
        this.can_manage_people = can_manage_people;
    }

}
