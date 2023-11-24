
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
    "frequency",
    "days",
    "hour",
    "minute",
    "week_instance",
    "week_interval",
    "month_interval",
    "start_date",
    "duration",
    "end_date"
})*/
@Generated("jsonschema2pojo")
public class RecurrenceSchedule {

    @SerializedName("frequency")
    private String frequency;
    @SerializedName("days")
    private List<Integer> days;
    @SerializedName("hour")
    private Integer hour;
    @SerializedName("minute")
    private Integer minute;
    @SerializedName("week_instance")
    private Object weekInstance;
    @SerializedName("week_interval")
    private Object weekInterval;
    @SerializedName("month_interval")
    private Object monthInterval;
    @SerializedName("start_date")
    private String startDate;
    @SerializedName("duration")
    private Object duration;
    @SerializedName("end_date")
    private String endDate;
    //@JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    @SerializedName("frequency")
    public String getFrequency() {
        return frequency;
    }

    @SerializedName("frequency")
    public void setFrequency(String frequency) {
        this.frequency = frequency;
    }

    @SerializedName("days")
    public List<Integer> getDays() {
        return days;
    }

    @SerializedName("days")
    public void setDays(List<Integer> days) {
        this.days = days;
    }

    @SerializedName("hour")
    public Integer getHour() {
        return hour;
    }

    @SerializedName("hour")
    public void setHour(Integer hour) {
        this.hour = hour;
    }

    @SerializedName("minute")
    public Integer getMinute() {
        return minute;
    }

    @SerializedName("minute")
    public void setMinute(Integer minute) {
        this.minute = minute;
    }

    @SerializedName("week_instance")
    public Object getWeekInstance() {
        return weekInstance;
    }

    @SerializedName("week_instance")
    public void setWeekInstance(Object weekInstance) {
        this.weekInstance = weekInstance;
    }

    @SerializedName("week_interval")
    public Object getWeekInterval() {
        return weekInterval;
    }

    @SerializedName("week_interval")
    public void setWeekInterval(Object weekInterval) {
        this.weekInterval = weekInterval;
    }

    @SerializedName("month_interval")
    public Object getMonthInterval() {
        return monthInterval;
    }

    @SerializedName("month_interval")
    public void setMonthInterval(Object monthInterval) {
        this.monthInterval = monthInterval;
    }

    @SerializedName("start_date")
    public String getStartDate() {
        return startDate;
    }

    @SerializedName("start_date")
    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    @SerializedName("duration")
    public Object getDuration() {
        return duration;
    }

    @SerializedName("duration")
    public void setDuration(Object duration) {
        this.duration = duration;
    }

    @SerializedName("end_date")
    public String getEndDate() {
        return endDate;
    }

    @SerializedName("end_date")
    public void setEndDate(String endDate) {
        this.endDate = endDate;
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
