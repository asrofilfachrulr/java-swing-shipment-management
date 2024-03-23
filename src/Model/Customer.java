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

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Customer [");
        sb.append("email=").append(email);
        sb.append(", phone=").append(phone);
        sb.append(", fullname=").append(fullname);
        sb.append(", id=").append(id);
        sb.append(", username=").append(username);
        sb.append(", returnAddress=").append(returnAddress);
        sb.append(", packageManagement=").append(packageManagement); // Assuming packageManagement has a suitable toString() implementation
        sb.append("]");
        return sb.toString();
    }

}

