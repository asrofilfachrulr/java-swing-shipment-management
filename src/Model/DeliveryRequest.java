package Model;

import java.util.Date;

public class DeliveryRequest extends BasePackageInformation{
    private float cost;
    private String paymentMethod;
    private boolean paymentStatus;
    private Date time;

    public DeliveryRequest(String senderName, String senderPhone, String senderAddress, String recipientName, String recipientPhone, String recipientAddress, float weight, String type, String stuffDesc, float cost, String paymentMethod, boolean paymentStatus, Date time) {
        super(senderName, senderPhone, senderAddress, recipientName, recipientPhone, recipientAddress, weight, type, stuffDesc);
        this.cost = cost;
        this.paymentMethod = paymentMethod;
        this.paymentStatus = paymentStatus;
        this.time = time;
    }

    public float getCost() {
        return cost;
    }

    public void setCost(float cost) {
        this.cost = cost;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public boolean isPaymentStatus() {
        return paymentStatus;
    }

    public void setPaymentStatus(boolean paymentStatus) {
        this.paymentStatus = paymentStatus;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }
}
