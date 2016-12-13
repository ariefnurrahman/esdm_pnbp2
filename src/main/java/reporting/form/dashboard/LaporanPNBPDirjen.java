package reporting.form.dashboard;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.Path;
import org.zkoss.zk.ui.util.Clients;
import org.zkoss.zk.ui.util.GenericForwardComposer;
import org.zkoss.zul.Div;
import org.zkoss.zul.Include;
import org.zkoss.zul.Label;
import org.zkoss.zul.ListModelList;
import org.zkoss.zul.Listbox;
import org.zkoss.zul.Listitem;
import org.zkoss.zul.ListitemRenderer;

import com.metrasys.mybatis.custom.model.LaporanPNBPDirjenModel;
import com.metrasys.service.ReportingService;

import reporting.form.constants.DefaultConstant;
import reporting.form.util.ListboxUtil;


@org.springframework.stereotype.Component
@Scope("prototype")
public class LaporanPNBPDirjen extends GenericForwardComposer implements ListitemRenderer {
	private static final Logger logger = Logger.getLogger(LaporanPNBPDirjen.class);
	private static final long serialVersionUID = 1L;
	
	public Include content = (Include) Path.getComponent("//main/content");
	
	private List<String> iLsBulanParam;
	private List<String> iLsTahunParam;
	private Listbox lsBoxBulan;
	private Listbox lsBoxTahun;
	private List<LaporanPNBPDirjenModel> iLsLaporan;
	private String strXML = "";
	private String axisName;
	private int no = 1;
	private Div divChartLaporan;
	private Listbox lboxLaporanList;
	
	@Autowired
	private transient ReportingService reportingService;

	public void doAfterCompose(Component win) throws Exception {
		super.doAfterCompose(win);
		
		System.out.println("dodol");
		
		Calendar cal = Calendar.getInstance();
		
		int month = cal.get(Calendar.MONTH);
		
		//Set Month Parameter list
		this.iLsBulanParam = Arrays.asList(DefaultConstant.NAMA_BULAN_ARRAY);
		ListModelList lstModelBln = new ListModelList(this.iLsBulanParam);
		lstModelBln.addSelection(lstModelBln.get(0));
		
		this.lsBoxBulan.setModel(lstModelBln);
		this.lsBoxBulan.setSelectedIndex(month);
		
		//Set Year Parameter list
		int currentYear = cal.get(Calendar.YEAR);
		cal.add(Calendar.YEAR, -1);
		int lastYear = cal.get(Calendar.YEAR);
		
		String[] yearParamArr = {String.valueOf(currentYear), String.valueOf(lastYear)};
		
		this.iLsTahunParam = Arrays.asList(yearParamArr);
		ListModelList lstModelThn = new ListModelList(this.iLsTahunParam);
		lstModelThn.addSelection(lstModelThn.get(0));
		
		this.lsBoxTahun.setModel(lstModelThn);
		this.lsBoxTahun.setSelectedIndex(0);
		
		this.setDataModel();
		
		this.generateCharView();
		

	}
	
	public void onClick$btnTampilkan() {
		this.setDataModel();
		this.generateCharView();
	}
	
	@Override
	public void render(Listitem listItem, Object data) throws Exception {
		LaporanPNBPDirjenModel laporanModel = (LaporanPNBPDirjenModel) data;
		Label lblNo = new Label(String.valueOf(this.no++));
		Label lblColumn1 = new Label(laporanModel.getKODE_DIRJEN());
		Label lblColumn2 = new Label(laporanModel.getNAMA_DIRJEN());
		Label lblColumn3 = new Label(laporanModel.getNOMINAL().toString());
		Label lblColumn4 = new Label(laporanModel.getFREKUENSI().toString());

		ListboxUtil.setObjectToListCell(listItem, lblNo);
		ListboxUtil.setObjectToListCell(listItem, lblColumn1);
		ListboxUtil.setObjectToListCell(listItem, lblColumn2);
		ListboxUtil.setObjectToListCell(listItem, lblColumn3);
		ListboxUtil.setObjectToListCell(listItem, lblColumn4);
	}
	
	private void setDataModel(){
		LaporanPNBPDirjenModel model1 = new LaporanPNBPDirjenModel();
		model1.setNAMA_DIRJEN("Minyak dan Gas Bumi");
		model1.setKODE_DIRJEN("20");
		model1.setNOMINAL(new BigDecimal("7000000000"));
		model1.setFREKUENSI(new Integer("100"));
		
		LaporanPNBPDirjenModel model2 = new LaporanPNBPDirjenModel();
		model2.setNAMA_DIRJEN("Ketenagalistrikan");
		model2.setKODE_DIRJEN("30");
		model2.setNOMINAL(new BigDecimal("5000000"));
		model2.setFREKUENSI(new Integer("50"));
		
		LaporanPNBPDirjenModel model3 = new LaporanPNBPDirjenModel();
		model3.setNAMA_DIRJEN("Mineral dan Batubara");
		model3.setKODE_DIRJEN("40");
		model3.setNOMINAL(new BigDecimal("9000000000"));
		model3.setFREKUENSI(new Integer("250"));
		
		LaporanPNBPDirjenModel model4 = new LaporanPNBPDirjenModel();
		model4.setNAMA_DIRJEN("Energi Baru,Terbarukan&Konservasi Energi");
		model4.setKODE_DIRJEN("50");
		model4.setNOMINAL(new BigDecimal("10000000"));
		model4.setFREKUENSI(new Integer("150"));
		
		this.iLsLaporan = new ArrayList<>();
		this.iLsLaporan.add(model1);
		this.iLsLaporan.add(model2);
		this.iLsLaporan.add(model3);
		this.iLsLaporan.add(model4);
		
		
	}
	
	private void generateCharView(){
		//this.iLsLaporan = reportingService.getListLaporanPNBPByPeriode(dtLaporanAwal.getValue(), dtLaporanAkhir.getValue());
		ListModelList lstModel = new ListModelList(this.iLsLaporan);
		this.lboxLaporanList.setModel(lstModel);
		this.lboxLaporanList.setItemRenderer(this);
		
		this.axisName = "Rekap Penerimaan PNBP per Dirjen";
		this.strXML = "<chart caption='' XAxisName='"+this.axisName+"' ";
		
		this.strXML += " exportenabled='1' exportAtClientSide='1' exportformats='PNG=Export as High Quality Image|PDF=Export as Printable|XLS=Export Chart Data' exporttargetwindow='_self' exportfilename='Today_Report' ";
		this.strXML += "palette='2' animation='1' formatNumberScale='0' numberPrefix='' ";
		this.strXML += "showValues='1' numDivLines='3' legendPosition='BOTTOM'>";
		this.strXML += "<categories>";
		this.strXML += "<category label='Minyak dan Gas Bumi' />";
		this.strXML += "<category label='Ketenagalistrikan' />";
		this.strXML += "<category label='Mineral dan Batubara' />";
		this.strXML += "<category label='Energi Baru,Terbarukan&Konservasi Energi' />";
		this.strXML += "</categories>";
		
		this.strXML += "<dataset seriesName='Data'>";
		
		for (LaporanPNBPDirjenModel data : this.iLsLaporan) {
			
			
			this.strXML = (this.strXML + "<set value='" + String.valueOf(data.getNOMINAL()) + "' link='#' />");
					
		}
		
		this.strXML += "</dataset>";	

		this.strXML += "<styles>";
		this.strXML += "<definition>";
		this.strXML += "<style type='font' name='CaptionFont' color='666666' size='15' />";
		this.strXML += "<style type='font' name='SubCaptionFont' bold='0' />";
		this.strXML += "</definition>";
		this.strXML += "<application>";
		this.strXML += "<apply toObject='caption' styles='CaptionFont' />";
		this.strXML += "<apply toObject='SubCaption' styles='SubCaptionFont' />";
		this.strXML += "</application>";
		this.strXML += "</styles>";
		this.strXML += "</chart>";
		
		System.out.println("strXML : " + strXML);

		Clients.evalJavaScript("viewBar3DChart(\"" + this.divChartLaporan.getUuid() + "\",\"" + this.strXML + "\",\"data\")");
	}
}
