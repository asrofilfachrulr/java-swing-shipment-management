package Model;

public class Staff extends LoggedAccount{
    private StaffPackageManagement packageManagement;
    private String officeCity;
    private String officeType;

    public Staff(String email, String phone, String fullname, String id, String username, StaffPackageManagement packageManagement, String officeCity, String officeType) {
        super(email, phone, fullname, id, username);
        this.packageManagement = packageManagement;
        this.officeCity = officeCity;
        this.officeType = officeType;
    }

    public StaffPackageManagement getPackageManagement() {
        return packageManagement;
    }

    public void setPackageManagement(StaffPackageManagement packageManagement) {
        this.packageManagement = packageManagement;
    }

    public String getOfficeCity() {
        return officeCity;
    }

    public void setOfficeCity(String officeCity) {
        this.officeCity = officeCity;
    }

    public String getOfficeType() {
        return officeType;
    }

    public void setOfficeType(String officeType) {
        this.officeType = officeType;
    }
}
