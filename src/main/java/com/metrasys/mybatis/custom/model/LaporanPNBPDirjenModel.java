package com.metrasys.mybatis.custom.model;

import java.io.Serializable;
import java.math.BigDecimal;

import com.metrasys.mybatis.model.CommonModel;

public class LaporanPNBPDirjenModel extends CommonModel implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private String NAMA_DIRJEN;
	private String KODE_DIRJEN;
	private BigDecimal NOMINAL;
	private Integer FREKUENSI;
	public String getNAMA_DIRJEN() {
		return NAMA_DIRJEN;
	}
	public void setNAMA_DIRJEN(String nAMA_DIRJEN) {
		NAMA_DIRJEN = nAMA_DIRJEN;
	}
	public String getKODE_DIRJEN() {
		return KODE_DIRJEN;
	}
	public void setKODE_DIRJEN(String kODE_DIRJEN) {
		KODE_DIRJEN = kODE_DIRJEN;
	}
	public BigDecimal getNOMINAL() {
		return NOMINAL;
	}
	public void setNOMINAL(BigDecimal nOMINAL) {
		NOMINAL = nOMINAL;
	}
	public Integer getFREKUENSI() {
		return FREKUENSI;
	}
	public void setFREKUENSI(Integer fREKUENSI) {
		FREKUENSI = fREKUENSI;
	}
	
	

}
