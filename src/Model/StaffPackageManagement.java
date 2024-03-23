package Model;

import java.util.List;

public class StaffPackageManagement implements PackageDeliveryManagement{
    public StaffPackageManagement() {
    }

    @Override
    public PackageDelivery searchPackageDeliveryById(String id) {
        return null;
    }

    @Override
    public DeliveryRequest searchDeliveryRequestById(String id) {
        return null;
    }

    @Override
    public List<PackageDelivery> searchPackageDeliveriesByOwner(String ownerId) {
        return null;
    }

    @Override
    public List<DeliveryRequest> searchDeliveryRequestsByOwner(String ownerId) {
        return null;
    }

    public void changePackageDelivery(String id, PackageDelivery packageDelivery){

    }

    public void deletePackageDelivery(String id){

    }

    public void createPackageDelivery(DeliveryRequest deliveryRequest){

    }
}
