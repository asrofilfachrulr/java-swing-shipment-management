package Model;

import java.util.Date;

public class PackageHistory {
	private int id;
	private Date time;
	private String status;
	private String location;
	private String description;
	private int staffId;

	public PackageHistory(int id, Date time, String status, String location, String description, int staffId) {
		this.id = id;
		this.time = time;
		this.status = status;
		this.location = location;
		this.description = description;
		this.staffId = staffId;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getStaffId() {
		return staffId;
	}

	public void setStaffId(int staffId) {
		this.staffId = staffId;
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
