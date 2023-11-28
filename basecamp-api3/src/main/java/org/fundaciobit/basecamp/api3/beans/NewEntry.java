package org.fundaciobit.basecamp.api3.beans;

import com.google.gson.annotations.SerializedName;

/**
 * 
 * @author anadal
 *
 */
public class NewEntry {

    protected String summary; // - what this schedule entry is about
    protected String starts_at; // - date-time (ISO 8601) for when this schedule entry begins
    protected String ends_at; // - date-time (ISO 8601) for when this schedule entry ends
    
    @SerializedName("all_day")
    private Boolean allDay;
    
    protected Integer[] participant_ids; // Email list seppared by comma

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public String getStarts_at() {
        return starts_at;
    }

    public void setStarts_at(String starts_at) {
        this.starts_at = starts_at;
    }

    public String getEnds_at() {
        return ends_at;
    }

    public void setEnds_at(String ends_at) {
        this.ends_at = ends_at;
    }

    public Integer[] getParticipant_ids() {
        return participant_ids;
    }

    public void setParticipant_ids(Integer[] participant_ids) {
        this.participant_ids = participant_ids;
    }

    public Boolean getAllDay() {
        return allDay;
    }

    public void setAllDay(Boolean allDay) {
        this.allDay = allDay;
    }

}
