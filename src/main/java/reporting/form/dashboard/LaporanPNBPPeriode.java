package reporting.form.dashboard;

import java.util.Date;
import java.util.List;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.Path;
import org.zkoss.zk.ui.util.Clients;
import org.zkoss.zk.ui.util.GenericForwardComposer;
import org.zkoss.zul.Datebox;
import org.zkoss.zul.Div;
import org.zkoss.zul.Include;
import org.zkoss.zul.Label;
import org.zkoss.zul.ListModelList;
import org.zkoss.zul.Listbox;
import org.zkoss.zul.Listitem;
import org.zkoss.zul.ListitemRenderer;

import com.metrasys.mybatis.custom.model.LaporanPNBPModel;
import com.metrasys.service.ReportingService;

import reporting.form.util.ListboxUtil;


@org.springframework.stereotype.Component
@Scope("prototype")
public class LaporanPNBPPeriode extends GenericForwardComposer implements ListitemRenderer {
	private static final Logger logger = Logger.getLogger(LaporanPNBPPeriode.class);
	private static final long serialVersionUID = 1L;
	
	public Include content = (Include) Path.getComponent("//main/content");

	private Datebox dtLaporanAwal;
	private Datebox dtLaporanAkhir;
	private List<LaporanPNBPModel> iLsLaporan;
	private String strXML = "";
	private String axisName;
	private int no = 1;
	private Listbox lboxLaporanList;
	private Div divChartLaporan;
	
	
	@Autowired
	private transient ReportingService reportingService;

	public void doAfterCompose(Component win) throws Exception {
		super.doAfterCompose(win);
		
		dtLaporanAwal.setValue(new Date());
		dtLaporanAwal.setConstraint("no empty");
		
		dtLaporanAkhir.setValue(new Date());
		dtLaporanAkhir.setConstraint("no empty");
		
		this.tampilkan();
	}
	
	public void onClick$btnTampilkan() {
		tampilkan();
	}
	
	private void tampilkan() {
		this.iLsLaporan = reportingService.getListLaporanPNBPByPeriode(dtLaporanAwal.getValue(), dtLaporanAkhir.getValue());
		ListModelList lstModel = new ListModelList(this.iLsLaporan);
		this.lboxLaporanList.setModel(lstModel);
		this.lboxLaporanList.setItemRenderer(this);
		
		this.axisName = "Laporan Pertumbuhan Kumulatif Siupal/Siopsus Tahun ke Tahun";
		this.strXML = "<chart caption='' XAxisName='"+this.axisName+"' ";
		
		this.strXML += " exportenabled='1' exportAtClientSide='1' exportformats='PNG=Export as High Quality Image|PDF=Export as Printable|XLS=Export Chart Data' exporttargetwindow='_self' exportfilename='Today_Report' ";
		this.strXML += "palette='2' animation='1' formatNumberScale='0' numberPrefix='' ";
		this.strXML += "showValues='1' numDivLines='3' legendPosition='BOTTOM'>";
		this.strXML += "<categories>";
		this.strXML += "<category label='SIUPAL' />";
		this.strXML += "<category label='SIOPSUS' />";
		this.strXML += "</categories>";
		
		for (LaporanPNBPModel data : this.iLsLaporan) {
			this.strXML += "<dataset seriesName='"+data.getNAMA_LAYANAN()+"'>";
			this.strXML = (this.strXML + "<set value='" + data.getNominal().toString() + "' link='#' />");
			this.strXML += "</dataset>";			
		}

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

		Clients.evalJavaScript("viewBar3DChart(\"" + this.divChartLaporan.getUuid() + "\",\"" + this.strXML + "\",\"data\")");
	}

	@Override
	public void render(Listitem listItem, Object data) throws Exception {
		LaporanPNBPModel laporanModel = (LaporanPNBPModel) data;
		Label lblNo = new Label(String.valueOf(this.no++));
		Label lblColumn1 = new Label(laporanModel.getNAMA_LAYANAN());
		Label lblColumn2 = new Label(laporanModel.getNominal().toString());

		ListboxUtil.setObjectToListCell(listItem, lblNo);
		ListboxUtil.setObjectToListCell(listItem, lblColumn1);
		ListboxUtil.setObjectToListCell(listItem, lblColumn2);
	}
}
