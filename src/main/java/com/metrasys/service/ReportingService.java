package com.metrasys.service;

import java.util.Date;
import java.util.List;
import com.metrasys.mybatis.custom.model.LaporanPNBPModel;


public interface ReportingService {

	List<LaporanPNBPModel> getListLaporanPNBPByPeriode(Date dtAwal, Date dtAkhir);

}
