package Model;

public abstract class BasePackageInformation {
    protected String senderName;
    protected String senderPhone;
    protected String senderAddress;
    protected String recipientName;
    protected String recipientPhone;
    protected String recipientAddress;
    protected float weight;
    protected boolean isFragile;
    protected String description;

    protected BasePackageInformation(String senderName, String senderPhone, String senderAddress, String recipientName, String recipientPhone, String recipientAddress, float weight, boolean isFragile, String stuffDesc) {
        this.senderName = senderName;
        this.senderPhone = senderPhone;
        this.senderAddress = senderAddress;
        this.recipientName = recipientName;
        this.recipientPhone = recipientPhone;
        this.recipientAddress = recipientAddress;
        this.weight = weight;
        this.isFragile = isFragile;
        this.description = stuffDesc;
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

   public void setIsFragile(boolean isFragile) {
	   this.isFragile = isFragile;
   }

   public boolean getIsFragile() {
	   return this.isFragile;
   }
   
    public String getStuffDesc() {
        return description;
    }

    public void setStuffDesc(String stuffDesc) {
        this.description = stuffDesc;
    }
}
