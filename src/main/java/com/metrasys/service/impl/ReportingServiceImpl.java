package com.metrasys.service.impl;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.metrasys.mybatis.custom.model.LaporanPNBPModel;
import com.metrasys.mybatis.custom.persistence.ReportingServiceMapper;
import com.metrasys.service.ReportingService;

@Service("reportingService")
public class ReportingServiceImpl implements ReportingService {
	private static final Logger logger = Logger.getLogger(ReportingServiceImpl.class);
	
	final static BigDecimal siupalValue = BigDecimal.ZERO;
	final static BigDecimal siopsusValue = BigDecimal.ONE;
	
	@Autowired
	private transient ReportingServiceMapper reportingServiceMapper;

	@Override
	public List<LaporanPNBPModel> getListLaporanPNBPByPeriode(Date dtAwal, Date dtAkhir) {
		return reportingServiceMapper.getListLaporanPNBPByPeriode(dtAwal,dtAkhir);
	}
	

}
