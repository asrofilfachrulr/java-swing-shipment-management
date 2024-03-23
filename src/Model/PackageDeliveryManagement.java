package Model;

import java.util.List;

public interface PackageDeliveryManagement {
    PackageDelivery searchPackageDeliveryById(String id);
    DeliveryRequest searchDeliveryRequestById(String id);
    List<PackageDelivery> searchPackageDeliveriesByOwner(String ownerId);
    List<DeliveryRequest> searchDeliveryRequestsByOwner(String ownerId);
}
