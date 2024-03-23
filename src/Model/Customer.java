package Model;

public class Customer extends LoggedAccount {
    private String returnAddress;
    CustomerPackageManagement packageManagement;

    public Customer(String email, String phone, String fullname, String id, String username, String returnAddress, CustomerPackageManagement packageManagement) {
        super(email, phone, fullname, id, username);
        this.returnAddress = returnAddress;
        this.packageManagement = packageManagement;
    }

    public String getReturnAddress() {
        return returnAddress;
    }

    public void setReturnAddress(String returnAddress) {
        this.returnAddress = returnAddress;
    }

    public CustomerPackageManagement getPackageManagement() {
        return packageManagement;
    }

    public void setPackageManagement(CustomerPackageManagement packageManagement) {
        this.packageManagement = packageManagement;
    }
}

