package org.fundaciobit.basecamp.api3.beans;

import java.util.Date;

/**
 * 
 * @author anadal
 *
 */
public class Root {
    public int id;
    public String status;
    public boolean visible_to_clients;
    public Date created_at;
    public Date updated_at;
    public String title;
    public boolean inherits_status;
    public String type;
    public String url;
    public String app_url;
    public String bookmark_url;
    public int position;
    public Bucket bucket;
    public Creator creator;
    public boolean include_due_assignments;
    public int entries_count;
    public String entries_url;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public boolean isVisible_to_clients() {
        return visible_to_clients;
    }

    public void setVisible_to_clients(boolean visible_to_clients) {
        this.visible_to_clients = visible_to_clients;
    }

    public Date getCreated_at() {
        return created_at;
    }

    public void setCreated_at(Date created_at) {
        this.created_at = created_at;
    }

    public Date getUpdated_at() {
        return updated_at;
    }

    public void setUpdated_at(Date updated_at) {
        this.updated_at = updated_at;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public boolean isInherits_status() {
        return inherits_status;
    }

    public void setInherits_status(boolean inherits_status) {
        this.inherits_status = inherits_status;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getApp_url() {
        return app_url;
    }

    public void setApp_url(String app_url) {
        this.app_url = app_url;
    }

    public String getBookmark_url() {
        return bookmark_url;
    }

    public void setBookmark_url(String bookmark_url) {
        this.bookmark_url = bookmark_url;
    }

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }

    public Bucket getBucket() {
        return bucket;
    }

    public void setBucket(Bucket bucket) {
        this.bucket = bucket;
    }

    public Creator getCreator() {
        return creator;
    }

    public void setCreator(Creator creator) {
        this.creator = creator;
    }

    public boolean isInclude_due_assignments() {
        return include_due_assignments;
    }

    public void setInclude_due_assignments(boolean include_due_assignments) {
        this.include_due_assignments = include_due_assignments;
    }

    public int getEntries_count() {
        return entries_count;
    }

    public void setEntries_count(int entries_count) {
        this.entries_count = entries_count;
    }

    public String getEntries_url() {
        return entries_url;
    }

    public void setEntries_url(String entries_url) {
        this.entries_url = entries_url;
    }

}
