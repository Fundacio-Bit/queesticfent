
package org.fundaciobit.basecamp.api3.beans;

import java.util.LinkedHashMap;
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
    "attachable_sgid",
    "name",
    "email_address",
    "personable_type",
    "title",
    "bio",
    "location",
    "created_at",
    "updated_at",
    "admin",
    "owner",
    "client",
    "employee",
    "time_zone",
    "avatar_url",
    "company",
    "can_ping",
    "can_manage_projects",
    "can_manage_people"
})*/
@Generated("jsonschema2pojo")
public class Participant {

    @SerializedName("id")
    private Integer id;
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
    @SerializedName("location")
    private String location;
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
    @SerializedName("employee")
    private Boolean employee;
    @SerializedName("time_zone")
    private String timeZone;
    @SerializedName("avatar_url")
    private String avatarUrl;
    @SerializedName("company")
    private Company company;
    @SerializedName("can_ping")
    private Boolean canPing;
    @SerializedName("can_manage_projects")
    private Boolean canManageProjects;
    @SerializedName("can_manage_people")
    private Boolean canManagePeople;
    //@JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    @SerializedName("id")
    public Integer getId() {
        return id;
    }

    @SerializedName("id")
    public void setId(Integer id) {
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

    @SerializedName("location")
    public String getLocation() {
        return location;
    }

    @SerializedName("location")
    public void setLocation(String location) {
        this.location = location;
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

    @SerializedName("employee")
    public Boolean getEmployee() {
        return employee;
    }

    @SerializedName("employee")
    public void setEmployee(Boolean employee) {
        this.employee = employee;
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

    @SerializedName("can_ping")
    public Boolean getCanPing() {
        return canPing;
    }

    @SerializedName("can_ping")
    public void setCanPing(Boolean canPing) {
        this.canPing = canPing;
    }

    @SerializedName("can_manage_projects")
    public Boolean getCanManageProjects() {
        return canManageProjects;
    }

    @SerializedName("can_manage_projects")
    public void setCanManageProjects(Boolean canManageProjects) {
        this.canManageProjects = canManageProjects;
    }

    @SerializedName("can_manage_people")
    public Boolean getCanManagePeople() {
        return canManagePeople;
    }

    @SerializedName("can_manage_people")
    public void setCanManagePeople(Boolean canManagePeople) {
        this.canManagePeople = canManagePeople;
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
