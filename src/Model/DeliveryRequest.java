package Model;

import java.util.Date;

public class DeliveryRequest extends BasePackageInformation{
    private float cost;
    private Date time;
    private City originCity;
    private City destCity;
    private Date pickupTime;
    private Date pickupTimeEst;
    private int customerId;
    private int id;
    private boolean isCanceled;
    
    public DeliveryRequest(String senderName, String senderPhone, String senderAddress, String recipientName, String recipientPhone, String recipientAddress, float weight, boolean isFragile, String stuffDesc, float cost, Date time, City originCity, City destCity) {
        super(senderName, senderPhone, senderAddress, recipientName, recipientPhone, recipientAddress, weight, isFragile, stuffDesc);
        this.cost = cost;
        this.time = time;
        this.originCity = originCity;
        this.destCity = destCity;
        this.isCanceled = false;
    }

    public boolean isCanceled() {
		return isCanceled;
	}

	public void setCanceled(boolean isCanceled) {
		this.isCanceled = isCanceled;
	}

	public Date getPickupTime() {
		return pickupTime;
	}

	public void setPickupTime(Date pickupTime) {
		this.pickupTime = pickupTime;
	}

	public Date getPickupTimeEst() {
		return pickupTimeEst;
	}

	public void setPickupTimeEst(Date pickupTimeEst) {
		this.pickupTimeEst = pickupTimeEst;
	}

	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

    public float getCost() {
        return cost;
    }

    public void setCost(float cost) {
        this.cost = cost;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }
    
    public City getOriginCity() {
    	return originCity;
    }
    
    public void setOriginCity(City originCity) {
    	this.originCity = originCity;
    }
    
    public City getDestCity() {
    	return destCity;
    }
    
    public void setDestCity(City destCity) {
    	this.destCity = destCity;
    }
    
    @Override
    public String toString() {
        return "DeliveryRequest{" +
                "senderName='" + senderName + '\'' +
                ", senderPhone='" + senderPhone + '\'' +
                ", senderAddress='" + senderAddress + '\'' +
                ", recipientName='" + recipientName + '\'' +
                ", recipientPhone='" + recipientPhone + '\'' +
                ", recipientAddress='" + recipientAddress + '\'' +
                ", weight=" + weight +
                ", isFragile=" + isFragile +
                ", stuffDesc='" + description + '\'' +
                ", cost=" + cost +
                ", time=" + time +
                ", originCity=" + originCity +
                ", destCity=" + destCity +
                ", pickupTime=" + pickupTime +
                ", pickupTimeEst=" + pickupTimeEst +
                ", customerId=" + customerId +
                ", id=" + id +
                ", isCanceled=" + isCanceled +
                '}';
    }    
}
