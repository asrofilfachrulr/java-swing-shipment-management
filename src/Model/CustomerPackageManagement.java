package Model;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import Model.Dao.DeliveryRequestDao;

public class CustomerPackageManagement extends PackageManagement{
    private List<PackageDelivery> packageDeliveries = new ArrayList<>();
    private List<DeliveryRequest> deliveryRequests = new ArrayList<>();
    
    public List<DeliveryRequest> getDeliveryRequests() {
		return deliveryRequests;
	}

	private int userId;

    public CustomerPackageManagement(){}

    public CustomerPackageManagement(int userId) {
    	this.userId = userId;
    }
    
    public List<PackageDelivery> getPackageDeliveries() {
        return packageDeliveries;
    }

    public void setPackageDeliveries(List<PackageDelivery> packageDeliveries) {
        this.packageDeliveries = packageDeliveries;
    }

    public List<DeliveryRequest> fetchDeliveryRequests() throws Exception {
    	if(deliveryRequests.size() != 0) {
    		return this.getDeliveryRequests();
    	}
    	
    	List<DeliveryRequest> requests = searchDeliveryRequestsByOwner(this.userId);
    	this.setDeliveryRequests(requests);
    	
        return requests;
    }

    public void setDeliveryRequests(List<DeliveryRequest> deliveryRequests) {
        this.deliveryRequests = deliveryRequests;
    }

    public void createDeliveryRequest(DeliveryRequest deliveryRequest) throws SQLException {
    	DeliveryRequestDao dao = new DeliveryRequestDao();
    	dao.add(deliveryRequest);
    }
    
    public List<DeliveryRequest> refreshAndFetchDeliveryRequests() throws Exception {
    	deliveryRequests = new ArrayList<>();
    	return fetchDeliveryRequests();
    }

    public void cancelDeliveryRequest(){

    }

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}
}
