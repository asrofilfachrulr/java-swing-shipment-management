package Model;

import java.util.Date;

public class PackageHistory {
    private Date time;
    private String status;
    private String location;
    private String description;

    public PackageHistory(Date time, String status, String location, String description) {
        this.time = time;
        this.status = status;
        this.location = location;
        this.description = description;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getMetadataUrl() {
        return description;
    }

    public void setMetadataUrl(String metadataUrl) {
        this.description = metadataUrl;
    }
}
