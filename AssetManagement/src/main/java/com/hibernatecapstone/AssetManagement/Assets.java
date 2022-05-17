package com.hibernatecapstone.AssetManagement;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "assets")
public class Assets {

	@Id
	private int assetId;
	private int serialNo;
	private int prNo;
	private String assetType;
	private int assetPrice;
	private String assetLocation;
	 
	public int getAssetId() {
		return assetId;
	}
	public void setAssetId(int assetId) {
		this.assetId = assetId;
	}
	public int getSerialNo() {
		return serialNo;
	}
	public void setSerialNo(int serialNo) {
		this.serialNo = serialNo;
	}
	public int getPrNo() {
		return prNo;
	}
	public void setPrNo(int prNo) {
		this.prNo = prNo;
	}
	public String getAssetType() {
		return assetType;
	}
	public void setAssetType(String assetType) {
		this.assetType = assetType;
	}
	public int getAssetPrice() {
		return assetPrice;
	}
	public void setAssetPrice(int assetPrice) {
		this.assetPrice = assetPrice;
	}
	public String getAssetLocation() {
		return assetLocation;
	}
	public void setAssetLocation(String assetLocation) {
		this.assetLocation = assetLocation;
	}
}
