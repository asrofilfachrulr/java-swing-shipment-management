package Model;

import java.util.List;

public class CustomerPackageManagement implements PackageDeliveryManagement{
    private List<PackageDelivery> packageDeliveries;
    private List<DeliveryRequest> deliveryRequests;

    public CustomerPackageManagement(){}

    public CustomerPackageManagement(List<PackageDelivery> packageDeliveries, List<DeliveryRequest> deliveryRequests) {
        this.packageDeliveries = packageDeliveries;
        this.deliveryRequests = deliveryRequests;
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

    public List<PackageDelivery> getPackageDeliveries() {
        return packageDeliveries;
    }

    public void setPackageDeliveries(List<PackageDelivery> packageDeliveries) {
        this.packageDeliveries = packageDeliveries;
    }

    public List<DeliveryRequest> getDeliveryRequests() {
        return deliveryRequests;
    }

    public void setDeliveryRequests(List<DeliveryRequest> deliveryRequests) {
        this.deliveryRequests = deliveryRequests;
    }

    public void createDeliveryRequest(DeliveryRequest deliveryRequest) {

    }

    public void payDeliveryRequest(){

    }

    public void cancelDeliveryRequest(){

    }
}
