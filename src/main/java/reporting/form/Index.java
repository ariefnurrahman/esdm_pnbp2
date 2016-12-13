package reporting.form;

import org.springframework.context.annotation.Scope;
import org.zkoss.zk.ui.event.ForwardEvent;
import org.zkoss.zk.ui.util.GenericForwardComposer;
import org.zkoss.zul.Include;
import org.zkoss.zul.Menuitem;

@org.springframework.stereotype.Component
@Scope("prototype")
public class Index extends GenericForwardComposer {
	private static final long serialVersionUID = 1L;
	Include content;
	org.zkoss.zul.Menubar menuBar;
	Menuitem lblBtnPenerimaanBNBP;
	Menuitem lblBtnLaporanPNBPPerperiode;

	

	public void doAfterCompose(org.zkoss.zk.ui.Component win) throws Exception {
		super.doAfterCompose(win);

		//---PNBP Perperiode--
		this.lblBtnPenerimaanBNBP.addForward("onClick", this.content, 
				"onRedirectPenerimaanBNBP", null);
		this.lblBtnLaporanPNBPPerperiode.addForward("onClick", this.content, 
				"onRedirectPNBPPerperiode", null);
	}

	
	public void onRedirectPenerimaanBNBP$content(ForwardEvent evt) {
		this.content.setSrc("laporanPNBPDirjen.zul");
	}

	public void lblBtnLaporanPNBPPerperiode$content(ForwardEvent evt) {
		this.content.setSrc("dashboard-pnbp-periode.zul");
	}

}