
package org.fundaciobit.basecamp.api3.beans;

//import com.fasterxml.jackson.annotation.JsonInclude;
import com.google.gson.annotations.SerializedName;
//import com.fasterxml.jackson.annotation.JsonPropertyOrder;

//@JsonInclude(JsonInclude.Include.NON_NULL)
/*@JsonPropertyOrder({
    "created_at",
    "creator"
})*/
public class Completion {

    @SerializedName("created_at")
    private String createdAt;
    @SerializedName("creator")
    private Creator creator;

    /**
     * No args constructor for use in serialization
     * 
     */
    public Completion() {
    }

    /**
     * 
     * @param createdAt
     * @param creator
     */
    public Completion(String createdAt, Creator creator) {
        super();
        this.createdAt = createdAt;
        this.creator = creator;
    }

    @SerializedName("created_at")
    public String getCreatedAt() {
        return createdAt;
    }

    @SerializedName("created_at")
    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    @SerializedName("creator")
    public Creator getCreator() {
        return creator;
    }

    @SerializedName("creator")
    public void setCreator(Creator creator) {
        this.creator = creator;
    }

}
