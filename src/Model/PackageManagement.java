package Model;

import java.util.List;

import Model.Dao.DeliveryRequestDao;

public abstract class PackageManagement {

    public PackageDelivery searchPackageDeliveryById(int id) {
    	return null;
    }
    
    public DeliveryRequest searchDeliveryRequestById(int id) {
    	return null;
	}

	public List<PackageDelivery> searchPackageDeliveriesByOwner(int ownerId) {
		return null;
	}

	public List<DeliveryRequest> searchDeliveryRequestsByOwner(int ownerId) throws Exception {
		DeliveryRequestDao dao = new DeliveryRequestDao();
		List<DeliveryRequest> requests = dao.getAll(ownerId);
		
		return requests;
	}
}
