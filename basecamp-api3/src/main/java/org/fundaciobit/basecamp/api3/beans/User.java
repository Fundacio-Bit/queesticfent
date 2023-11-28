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
/*@JsonPropertyOrder({ "id", "attachable_sgid", "name", "email_address", "personable_type", "title", "bio", "location",
        "created_at", "updated_at", "admin", "owner", "client", "employee", "time_zone", "avatar_url", "company",
        "can_ping", "can_manage_projects", "can_manage_people" })*/
/**
 * 
 * @author anadal
 *
 */
@Generated("jsonschema2pojo")
public class User {

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
    private Object bio;
    @SerializedName("location")
    private Object location;
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

    /**
    * No args constructor for use in serialization
    *
    */
    public User() {
    }

    /**
    *
    * @param owner
    * @param personableType
    * @param canPing
    * @param avatarUrl
    * @param bio
    * @param admin
    * @param timeZone
    * @param title
    * @param employee
    * @param createdAt
    * @param emailAddress
    * @param attachableSgid
    * @param name
    * @param client
    * @param location
    * @param company
    * @param canManageProjects
    * @param id
    * @param canManagePeople
    * @param updatedAt
    */
    public User(Integer id, String attachableSgid, String name, String emailAddress, String personableType,
            String title, Object bio, Object location, String createdAt, String updatedAt, Boolean admin, Boolean owner,
            Boolean client, Boolean employee, String timeZone, String avatarUrl, Company company, Boolean canPing,
            Boolean canManageProjects, Boolean canManagePeople) {
        super();
        this.id = id;
        this.attachableSgid = attachableSgid;
        this.name = name;
        this.emailAddress = emailAddress;
        this.personableType = personableType;
        this.title = title;
        this.bio = bio;
        this.location = location;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.admin = admin;
        this.owner = owner;
        this.client = client;
        this.employee = employee;
        this.timeZone = timeZone;
        this.avatarUrl = avatarUrl;
        this.company = company;
        this.canPing = canPing;
        this.canManageProjects = canManageProjects;
        this.canManagePeople = canManagePeople;
    }

    @SerializedName("id")
    public Integer getId() {
        return id;
    }

    @SerializedName("id")
    public void setId(Integer id) {
        this.id = id;
    }


    public String getAttachableSgid() {
        return attachableSgid;
    }


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
    public Object getBio() {
        return bio;
    }

    @SerializedName("bio")
    public void setBio(Object bio) {
        this.bio = bio;
    }

    @SerializedName("location")
    public Object getLocation() {
        return location;
    }

    @SerializedName("location")
    public void setLocation(Object location) {
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

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class ");
        sb.append(User.class.getSimpleName()).append(" {");
        sb.append("\n\t");
        sb.append("id");
        sb.append('=');
        sb.append(((this.id == null) ? "<null>" : this.id));
        sb.append("\n\t");
        sb.append("name");
        sb.append('=');
        sb.append(((this.name == null) ? "<null>" : this.name));
        sb.append("\n\t");
        sb.append("emailAddress");
        sb.append('=');
        sb.append(((this.emailAddress == null) ? "<null>" : this.emailAddress));
        sb.append("\n\t");
        sb.append("personableType");
        sb.append('=');
        sb.append(((this.personableType == null) ? "<null>" : this.personableType));
        sb.append("\n\t");
        sb.append("title");
        sb.append('=');
        sb.append(((this.title == null) ? "<null>" : this.title));
        sb.append("\n\t");
        sb.append("bio");
        sb.append('=');
        sb.append(((this.bio == null) ? "<null>" : this.bio));
        sb.append("\n\t");
        sb.append("location");
        sb.append('=');
        sb.append(((this.location == null) ? "<null>" : this.location));
        sb.append("\n\t");
        sb.append("createdAt");
        sb.append('=');
        sb.append(((this.createdAt == null) ? "<null>" : this.createdAt));
        sb.append("\n\t");
        sb.append("updatedAt");
        sb.append('=');
        sb.append(((this.updatedAt == null) ? "<null>" : this.updatedAt));
        sb.append("\n\t");
        sb.append("admin");
        sb.append('=');
        sb.append(((this.admin == null) ? "<null>" : this.admin));
        sb.append("\n\t");
        sb.append("owner");
        sb.append('=');
        sb.append(((this.owner == null) ? "<null>" : this.owner));
        sb.append("\n\t");
        sb.append("client");
        sb.append('=');
        sb.append(((this.client == null) ? "<null>" : this.client));
        sb.append("\n\t");
        sb.append("employee");
        sb.append('=');
        sb.append(((this.employee == null) ? "<null>" : this.employee));
        sb.append("\n\t");
        sb.append("timeZone");
        sb.append('=');
        sb.append(((this.timeZone == null) ? "<null>" : this.timeZone));
        sb.append("\n\t");
        sb.append("avatarUrl");
        sb.append('=');
        sb.append(((this.avatarUrl == null) ? "<null>" : this.avatarUrl));
        sb.append("\n\t");
        sb.append("company");
        sb.append('=');
        sb.append(((this.company == null) ? "<null>" : this.company));
        sb.append("\n\t");
        sb.append("canPing");
        sb.append('=');
        sb.append(((this.canPing == null) ? "<null>" : this.canPing));
        sb.append("\n\t");
        sb.append("canManageProjects");
        sb.append('=');
        sb.append(((this.canManageProjects == null) ? "<null>" : this.canManageProjects));
        sb.append("\n\t");
        sb.append("canManagePeople");
        sb.append('=');
        sb.append(((this.canManagePeople == null) ? "<null>" : this.canManagePeople));
        sb.append("\n\t");
        sb.append("attachableSgid");
        sb.append('=');
        sb.append(((this.attachableSgid == null) ? "<null>" : this.attachableSgid));
        sb.append("\n\t");
        sb.append("additionalProperties");
        sb.append('=');
        sb.append(((this.additionalProperties == null) ? "<null>" : this.additionalProperties));
        sb.append("\n");
        if (sb.charAt((sb.length() - 1)) == ',') {
            sb.setCharAt((sb.length() - 1), '}');
        } else {
            sb.append('}');
        }
        return sb.toString();
    }

}
