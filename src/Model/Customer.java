package Model;

public class Customer {
    private int id;
    private String email;
    private String phone;
    private String fullname;
    private String returnAddress;
    private String password;
    private String username;

    public Customer() {
        // Default constructor
    }

    // Constructor with all fields
    public Customer(int id, String email, String phone, String fullname, String returnAddress, String password, String username) {
        this.id = id;
        this.email = email;
        this.phone = phone;
        this.fullname = fullname;
        this.returnAddress = returnAddress;
        this.password = password;
        this.username = username;
    }


    // Getters and setters for all fields
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getReturnAddress() {
        return returnAddress;
    }

    public void setReturnAddress(String returnAddress) {
        this.returnAddress = returnAddress;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    // toString() method to represent the object as a string
    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                ", fullname='" + fullname + '\'' +
                ", returnAddress='" + returnAddress + '\'' +
                ", password='" + password + '\'' +
                ", username='" + username + '\'' +
                '}';
    }
}

