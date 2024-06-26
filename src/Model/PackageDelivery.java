package Model;

import java.util.List;

import Model.Dao.DeliveryRequestDao;
import Model.Dao.PackageDeliveryDao;
import Model.Dao.PackageHistoryDao;

public class PackageDelivery extends BasePackageInformation {
	int id;
	int staffId;
	private String status;
	private List<PackageHistory> packageHistories;

	public PackageDelivery(String senderName, String senderPhone, String senderAddress, String recipientName,
			String recipientPhone, String recipientAddress, float weight, boolean isFragile, String stuffDesc, int id,
			String status, int staffId, List<PackageHistory> packageHistories) {
		super(senderName, senderPhone, senderAddress, recipientName, recipientPhone, recipientAddress, weight,
				isFragile, stuffDesc);
		this.id = id;
		this.status = status;
		this.staffId = staffId;
		this.packageHistories = packageHistories;
	}

	public PackageDelivery(DeliveryRequest deliveryRequest, int id, String status, int staffId,
			List<PackageHistory> packageHistories) {
		super(deliveryRequest.getSenderName(), deliveryRequest.getSenderPhone(), deliveryRequest.getSenderAddress(),
				deliveryRequest.getRecipientName(), deliveryRequest.getRecipientPhone(),
				deliveryRequest.getRecipientAddress(), deliveryRequest.getWeight(), deliveryRequest.getIsFragile(),
				deliveryRequest.getStuffDesc());
		this.id = id;
		this.status = status;
		this.staffId = staffId;
		this.packageHistories = packageHistories;
	}

	public int getStaffId() {
		return staffId;
	}

	public void setStaffId(int staffId) {
		this.staffId = staffId;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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
