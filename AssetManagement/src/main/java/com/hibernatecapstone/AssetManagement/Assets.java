package com.hibernatecapstone.AssetManagement;

import org.hibernate.annotations.NamedQuery;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "assets")
@NamedQuery(name = "Assets.getAvgPerLocation", 
			query = "Select avg(assetPrice),assetLocation from Assets group by assetLocation ")
public class Assets {

	@Id
	@Column(name="asset_id")
	private int assetId;
	@Column(name="serial_no")
	private int serialNo;
	@Column(name="pr_no")
	private int prNo;
	@Column(name="asset_type")
	private String assetType;
	@Column(name="asset_price")
	private int assetPrice;
	@Column(name="asset_location")
	private String assetLocation;
	
	public Assets(int assetId,int serialNo,int prNo,String assetType,int assetPrice,String assetLocation) {
		this.assetId = assetId;
		this.serialNo = serialNo;
		this.prNo = prNo;
		this.assetType = assetType;
		this.assetPrice = assetPrice;
		this.assetLocation = assetLocation;
	}
	 
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
