package Model;

import java.util.Date;
import java.util.HashMap;
import java.util.List;

import Model.Dao.DeliveryRequestDao;
import Model.Dao.PackageDeliveryDao;
import Model.Dao.PackageHistoryDao;

public class StaffPackageManagement extends PackageManagement{
    public StaffPackageManagement() {
    }
    
    public List<DeliveryRequest> fetchAllDeliveryRequests(int staffId) throws Exception {
    	DeliveryRequestDao dao = new DeliveryRequestDao();
    	return dao.adminGetAll(staffId);
    }
    
    public void changePickupTimeEst(int requestId, Date date) throws Exception {
    	DeliveryRequestDao dao = new DeliveryRequestDao();
    	dao.updatePickupEst(requestId, date);
    }
    
    public void changePickupTime(int requestId, Date date) throws Exception {
    	DeliveryRequestDao dao = new DeliveryRequestDao();
    	dao.updatePickup(requestId, date);
    }
    
    public DeliveryRequest fetchDeliveryRequestByDeliveryId(int id) throws Exception {
    	DeliveryRequestDao dao = new DeliveryRequestDao();
    	return dao.getByDeliveryId(id);
    }

    public void createPackageDelivery(DeliveryRequest deliveryRequest, Staff staff) throws Exception{
    	PackageDelivery delivery = new PackageDelivery(deliveryRequest, -1, "IN PROGRESS", staff.getId(), null);
    	
    	PackageDeliveryDao dao = new PackageDeliveryDao();
    	int id = dao.create(delivery, deliveryRequest.getId());
    	
    	PackageHistory history = new PackageHistory(
    				-1,
    				new Date(),
    				"RECEIVED",
    				String.format("%s %s", staff.getOfficeCity(), staff.getOfficeType()),
    				"Package has been received",
    				staff.getId()
    			);
    	
    	PackageHistoryDao daoHistory = new PackageHistoryDao();
    	daoHistory.add(history, id);
    }
    
    public void addHistory(
    		String type, 
    		boolean atRecipient,
    		String placeDepart, 
    		String locationType,
    		Date date, 
    		int id, 
    		Staff staff
    	) throws Exception {
    	String status, location, description;
    	
    	HashMap<String, String> officeAbbrFullMap = new HashMap<>();
    	officeAbbrFullMap.put("HUB", "Hub");
    	officeAbbrFullMap.put("WH", "Warehouse");
    	officeAbbrFullMap.put("DC", "Drop Center");
    	
    	location = String.format("%s %s", staff.getOfficeCity(), staff.getOfficeType());
    	
    	if(type.equals("Receive")) {
    		status = "RECEIVED";
    		if(atRecipient) {
    			description = "Package has been received by recipient";
    			location = "RECIPIENT";
    		}
    		else {
    			description = String.format("Package has been received at local %s", officeAbbrFullMap.get(staff.getOfficeType()));
    		}
    	} else {
    		status = "DEPARTED";
    		description = String.format("Package has been departed to %s %s",
    				locationType.equals("Local") ? "local" : "other", placeDepart);
    	}
    	
    	PackageHistory history = new PackageHistory(-1, date, status, location, description, staff.getId());
    	PackageHistoryDao dao = new PackageHistoryDao();
    	dao.add(history, id);
    }
}
