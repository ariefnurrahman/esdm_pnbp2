package com.metrasys.mybatis.custom.model;

import java.io.Serializable;
import java.math.BigDecimal;

import com.metrasys.mybatis.model.CommonModel;

public class LaporanPNBPModel extends CommonModel implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private String LAYANAN_ID;
	private String NAMA_LAYANAN;
	private String LAYANAN_DESC;
	private String KATEGORY;
	private BigDecimal Nominal;
	
	public String getLAYANAN_ID() {
		return LAYANAN_ID;
	}
	public void setLAYANAN_ID(String lAYANAN_ID) {
		LAYANAN_ID = lAYANAN_ID;
	}
	public String getNAMA_LAYANAN() {
		return NAMA_LAYANAN;
	}
	public void setNAMA_LAYANAN(String nAMA_LAYANAN) {
		NAMA_LAYANAN = nAMA_LAYANAN;
	}
	public String getLAYANAN_DESC() {
		return LAYANAN_DESC;
	}
	public void setLAYANAN_DESC(String lAYANAN_DESC) {
		LAYANAN_DESC = lAYANAN_DESC;
	}
	public String getKATEGORY() {
		return KATEGORY;
	}
	public void setKATEGORY(String kATEGORY) {
		KATEGORY = kATEGORY;
	}
	public BigDecimal getNominal() {
		return Nominal;
	}
	public void setNominal(BigDecimal nominal) {
		Nominal = nominal;
	}
	
	
	
	

}
