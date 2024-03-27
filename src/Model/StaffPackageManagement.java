package Model;

import java.util.Date;
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

    public void changePackageDelivery(String id, PackageDelivery packageDelivery){

    }

    public void deletePackageDelivery(String id){

    }

    public void createPackageDelivery(DeliveryRequest deliveryRequest, Staff staff) throws Exception{
    	PackageDelivery delivery = new PackageDelivery(deliveryRequest, -1, "IN PROGRESS", staff.getId(), null);
    	
    	PackageDeliveryDao dao = new PackageDeliveryDao();
    	int id = dao.create(null, deliveryRequest.getId());
    	
    	PackageHistory history = new PackageHistory(
    				-1,
    				new Date(),
    				"RECEIVED",
    				String.format("%s %s", staff.getOfficeCity(), staff.getOfficeType()),
    				"Package has been received",
    				staff.getId()
    			);
    	
    	PackageHistoryDao daoHistory = new PackageHistoryDao();
    	daoHistory.create(history, id);
    }
}
