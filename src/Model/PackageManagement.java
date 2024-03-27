package Model;

import java.util.List;

import Model.Dao.DeliveryRequestDao;
import Model.Dao.PackageDeliveryDao;
import Model.Dao.PackageHistoryDao;

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
	
	public PackageDelivery fetchPackageDeliveryByDeliveryRequest(DeliveryRequest request) throws Exception {
		if(request.getPickupTime() == null)
			return null;
		
		PackageDeliveryDao packageDeliveryDao = new PackageDeliveryDao();
		PackageHistoryDao packageHistoryDao = new PackageHistoryDao();
		
		PackageDelivery delivery = packageDeliveryDao.getByDeliveryReq(request);
		
		if(delivery == null)
			return null;
		
		List<PackageHistory> histories = packageHistoryDao.getByPackageDelivery(delivery);
		delivery.setPackageHistories(histories);
		
		return delivery;
	}

	public List<DeliveryRequest> searchDeliveryRequestsByOwner(int ownerId) throws Exception {
		DeliveryRequestDao dao = new DeliveryRequestDao();
		List<DeliveryRequest> requests = dao.getAll(ownerId);
		
		return requests;
	}
}
