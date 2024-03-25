package Model;

import java.util.List;

public class PackageDelivery extends BasePackageInformation{
    private String status;
    private List<PackageHistory> packageHistories;

    public PackageDelivery(String senderName, String senderPhone, String senderAddress, String recipientName, String recipientPhone, String recipientAddress, float weight, boolean isFragile, String stuffDesc, String status, List<PackageHistory> packageHistories) {
        super(senderName, senderPhone, senderAddress, recipientName, recipientPhone, recipientAddress, weight, isFragile, stuffDesc);
        this.status = status;
        this.packageHistories = packageHistories;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public List<PackageHistory> getPackageHistories() {
        return packageHistories;
    }

    public void setPackageHistories(List<PackageHistory> packageHistories) {
        this.packageHistories = packageHistories;
    }
}
