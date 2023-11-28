package org.fundaciobit.basecamp.api3.beans;

import com.google.gson.annotations.SerializedName;

//@JsonInclude(JsonInclude.Include.NON_NULL)
/*//@JsonPropertyOrder({
"attachable_sgid",
"description",
"base_name"
})*/
public class AttachFile {

    @SerializedName("attachable_sgid")
    private String attachableSgid;
    @SerializedName("description")
    private String description;
    @SerializedName("base_name")
    private String baseName;

    /**
    * No args constructor for use in serialization
    *
    */
    public AttachFile() {
    }

    /**
    *
    * @param attachableSgid
    * @param description
    * @param baseName
    */
    public AttachFile(String attachableSgid, String description, String baseName) {
        super();
        this.attachableSgid = attachableSgid;
        this.description = description;
        this.baseName = baseName;
    }

    public String getAttachableSgid() {
        return attachableSgid;
    }

    public void setAttachableSgid(String attachableSgid) {
        this.attachableSgid = attachableSgid;
    }

    @SerializedName("description")
    public String getDescription() {
        return description;
    }

    @SerializedName("description")
    public void setDescription(String description) {
        this.description = description;
    }

    @SerializedName("base_name")
    public String getBaseName() {
        return baseName;
    }

    @SerializedName("base_name")
    public void setBaseName(String baseName) {
        this.baseName = baseName;
    }

}
