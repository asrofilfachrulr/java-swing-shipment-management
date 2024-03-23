package Model;

public abstract class BasePackageInformation {
    protected String senderName;
    protected String senderPhone;
    protected String senderAddress;
    protected String recipientName;
    protected String recipientPhone;
    protected String recipientAddress;
    protected float weight;
    protected String type;
    protected String stuffDesc;

    protected BasePackageInformation(String senderName, String senderPhone, String senderAddress, String recipientName, String recipientPhone, String recipientAddress, float weight, String type, String stuffDesc) {
        this.senderName = senderName;
        this.senderPhone = senderPhone;
        this.senderAddress = senderAddress;
        this.recipientName = recipientName;
        this.recipientPhone = recipientPhone;
        this.recipientAddress = recipientAddress;
        this.weight = weight;
        this.type = type;
        this.stuffDesc = stuffDesc;
    }

    public String getSenderName() {
        return senderName;
    }

    public void setSenderName(String senderName) {
        this.senderName = senderName;
    }

    public String getSenderPhone() {
        return senderPhone;
    }

    public void setSenderPhone(String senderPhone) {
        this.senderPhone = senderPhone;
    }

    public String getSenderAddress() {
        return senderAddress;
    }

    public void setSenderAddress(String senderAddress) {
        this.senderAddress = senderAddress;
    }

    public String getRecipientName() {
        return recipientName;
    }

    public void setRecipientName(String recipientName) {
        this.recipientName = recipientName;
    }

    public String getRecipientPhone() {
        return recipientPhone;
    }

    public void setRecipientPhone(String recipientPhone) {
        this.recipientPhone = recipientPhone;
    }

    public String getRecipientAddress() {
        return recipientAddress;
    }

    public void setRecipientAddress(String recipientAddress) {
        this.recipientAddress = recipientAddress;
    }

    public float getWeight() {
        return weight;
    }

    public void setWeight(float weight) {
        this.weight = weight;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getStuffDesc() {
        return stuffDesc;
    }

    public void setStuffDesc(String stuffDesc) {
        this.stuffDesc = stuffDesc;
    }
}
