package Model;

public abstract class LoggedAccount extends Account {
    protected String email;
    protected String phone;
    protected String fullname;
    protected String id;
    protected String username;

    protected LoggedAccount(String email, String phone, String fullname, String id, String username) {
        this.email = email;
        this.phone = phone;
        this.fullname = fullname;
        this.id = id;
        this.username = username;
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

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void logout() {

    }
}
