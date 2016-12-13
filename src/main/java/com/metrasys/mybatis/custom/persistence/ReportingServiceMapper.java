package com.metrasys.mybatis.custom.persistence;

import java.util.Date;
import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.metrasys.mybatis.custom.model.LaporanPNBPModel;

public interface ReportingServiceMapper {


	String getListLaporanPNBPByPeriode = "Select LAYANAN_ID,NAMA_LAYANAN,LAYANAN_DESC,KATEGORY from laporanBNBP WHERE PARAM_DATE BETWEEN TRUNC(#{PARAM_DATE_START}) AND TRUNC(#{PARAM_DATE_END}) ";
	@Select(getListLaporanPNBPByPeriode)
	List<LaporanPNBPModel> getListLaporanPNBPByPeriode(@Param("PARAM_DATE_START")Date dtAwal, @Param("PARAM_DATE_END")Date dtAkhir);
	
}
