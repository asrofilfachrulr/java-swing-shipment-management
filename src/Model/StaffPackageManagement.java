package Model;

import java.util.List;

import Model.Dao.DeliveryRequestDao;

public class StaffPackageManagement extends PackageManagement{
    public StaffPackageManagement() {
    }
    
    public List<DeliveryRequest> fetchAllDeliveryRequests(int staffId) throws Exception {
    	DeliveryRequestDao dao = new DeliveryRequestDao();
    	return dao.adminGetAll(staffId);
    }

    public void changePackageDelivery(String id, PackageDelivery packageDelivery){

    }

    public void deletePackageDelivery(String id){

    }

    public void createPackageDelivery(DeliveryRequest deliveryRequest){

    }
}
