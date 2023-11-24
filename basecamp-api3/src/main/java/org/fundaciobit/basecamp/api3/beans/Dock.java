
package org.fundaciobit.basecamp.api3.beans;

//import com.fasterxml.jackson.annotation.JsonInclude;
import com.google.gson.annotations.SerializedName;
//import com.fasterxml.jackson.annotation.JsonPropertyOrder;

//@JsonInclude(JsonInclude.Include.NON_NULL)
/*@JsonPropertyOrder({
    "id",
    "title",
    "name",
    "enabled",
    "position",
    "url",
    "app_url"
})*/
public class Dock {

    @SerializedName("id")
    private Long id;
    @SerializedName("title")
    private String title;
    @SerializedName("name")
    private String name;
    @SerializedName("enabled")
    private Boolean enabled;
    @SerializedName("position")
    private Object position;
    @SerializedName("url")
    private String url;
    @SerializedName("app_url")
    private String appUrl;

    /**
     * No args constructor for use in serialization
     * 
     */
    public Dock() {
    }

    /**
     * 
     * @param name
     * @param appUrl
     * @param id
     * @param position
     * @param title
     * @param enabled
     * @param url
     */
    public Dock(Long id, String title, String name, Boolean enabled, Object position, String url, String appUrl) {
        super();
        this.id = id;
        this.title = title;
        this.name = name;
        this.enabled = enabled;
        this.position = position;
        this.url = url;
        this.appUrl = appUrl;
    }

    @SerializedName("id")
    public Long getId() {
        return id;
    }

    @SerializedName("id")
    public void setId(Long id) {
        this.id = id;
    }

    @SerializedName("title")
    public String getTitle() {
        return title;
    }

    @SerializedName("title")
    public void setTitle(String title) {
        this.title = title;
    }

    @SerializedName("name")
    public String getName() {
        return name;
    }

    @SerializedName("name")
    public void setName(String name) {
        this.name = name;
    }

    @SerializedName("enabled")
    public Boolean getEnabled() {
        return enabled;
    }

    @SerializedName("enabled")
    public void setEnabled(Boolean enabled) {
        this.enabled = enabled;
    }

    @SerializedName("position")
    public Object getPosition() {
        return position;
    }

    @SerializedName("position")
    public void setPosition(Object position) {
        this.position = position;
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

}
