package reporting.form.util;

public class WorkflowService {
	public static String APPROVE = "A";
	public static String REJECT = "R";
	public static String CURRENT = "C";
	public static String CURRENT_USER = "U";
	public static String START = "S";
	public static String STOP = "E";
	public static String DEFAULT = "D";
	public static String SIUPAL = "FS001";
	public static String SIOPSUS = "FS002";
	public static String KANTOR_CABANG = "FS003";
	public static String SPEK_KAPAL = "FS004";
	public static String RPT_LINER_SDI = "FR001";
	public static String RPT_TRAMPER_SDI = "FR002";
	public static String RPT_TRAMPER_SDIII = "FR003";
	public static String RPT_LINER_SDIII = "FR004";
	public static String PKKA = "FP001";
	public static String PPKM = "FP003";
	public static String STATUS_LINER = "FP004";
	public static String OWNER_REPRESENTATIF = "FP002";
	public static String IPKA = "FI001";
	public static String RPT_OMISI_DEVIASI = "FR005";
	public static String PERUBAHAN_IZIN = "FS005";

	public static String getDescription(String flag) {
		String desc = "";
		if (flag.equalsIgnoreCase(SIUPAL)) {
			desc = "SIUPAL";
		} else if (flag.equalsIgnoreCase(SIOPSUS)) {
			desc = "SIOPSUS";
		} else if (flag.equalsIgnoreCase(KANTOR_CABANG)) {
			desc = "KANTOR CABANG";
		} else if (flag.equalsIgnoreCase(SPEK_KAPAL)) {
			desc = "SPEK KAPAL";
		} else if (flag.equalsIgnoreCase(RPT_LINER_SDI)) {
			desc = "RPT - LINER (SDI)";
		} else if (flag.equalsIgnoreCase(RPT_TRAMPER_SDI)) {
			desc = "RPT - TRAMPER (SDI)";
		} else if (flag.equalsIgnoreCase(RPT_LINER_SDIII)) {
			desc = "RPT - LINER (SDIII)";
		} else if (flag.equalsIgnoreCase(RPT_TRAMPER_SDIII)) {
			desc = "RPT - TRAMPER (SDIII)";
		} else if (flag.equalsIgnoreCase(PKKA)) {
			desc = "PKKA";
		} else if (flag.equalsIgnoreCase(PPKM)) {
			desc = "PPK MILIK,CARTER,KEAGENAN";
		} else if (flag.equalsIgnoreCase(STATUS_LINER)) {
			desc = "STATUS LINER";
		} else if (flag.equalsIgnoreCase(OWNER_REPRESENTATIF)) {
			desc = "OWNER REPRESNTATIVE";
		} else if (flag.equalsIgnoreCase(IPKA)) {
			desc = "IPKA";
		} else if (flag.equalsIgnoreCase(START)) {
			desc = "Start";
		} else if (flag.equalsIgnoreCase(APPROVE)) {
			desc = "Approve";
		} else if (flag.equalsIgnoreCase(REJECT)) {
			desc = "Reject";
		} else if (flag.equalsIgnoreCase(STOP)) {
			desc = "Stop";
		} else if (flag.equalsIgnoreCase(RPT_OMISI_DEVIASI)) {
			desc = "RPT - OMISI - DEVIASI";
		} else if (flag.equalsIgnoreCase(PERUBAHAN_IZIN)) {
			desc = "PERUBAHAN IZIN";
		} else {
			desc = "UNKNOWN";
		}
		return desc;
	}

	public static String getPnbpDescription(String flag) {
		String desc = "";
		if (flag.equalsIgnoreCase(SIUPAL)) {
			desc = "Surat Ijin Usaha Perusahaan Angkutan Laut / SIUPAL (PNBP-JAL 01) ";
		} else if (flag.equalsIgnoreCase(SIOPSUS)) {
			desc = "Surat Ijin Usaha Perusahaan Angkutan Laut Khusus / SIOPSUS (PNBP-JAL 02)";
		} else if (flag.equalsIgnoreCase(KANTOR_CABANG)) {
			desc = "Pembukaan Kantor Cabang Perusahaan AngkutanLaut (PNBP-JAL 05)";
		} else if (flag.equalsIgnoreCase(SPEK_KAPAL)) {
			desc = "Spesifikasi Kapal / Spek (PNBP-JAL 04)";
		} else if (flag.equalsIgnoreCase(RPT_LINER_SDI)) {
			desc = "Registrasi Laporan Penempatan Kapal Dalam Trayek Lines Angkutan Laut Dalam Negeri (PNBP-JAL 06)";
		} else if (flag.equalsIgnoreCase(RPT_TRAMPER_SDI)) {
			desc = "Registrasi Laporan Penempatan Kapal Dalam Trayek Tramper Angkutan Laut Dalam Negeri (PNBP-JAL 06)";
		} else if (flag.equalsIgnoreCase(RPT_LINER_SDIII)) {
			desc = "Registrasi Laporan Penempatan Kapal Dalam Trayek Lines Angkutan Laut Dalam Negeri (PNBP-JAL 06)";
		} else if (flag.equalsIgnoreCase(RPT_TRAMPER_SDIII)) {
			desc = "Registrasi Laporan Penempatan Kapal Dalam Trayek Tramper Angkutan Laut Dalam Negeri (PNBP-JAL 06)";
		} else if (flag.equalsIgnoreCase(PKKA)) {
			desc = "Pemberithuan Keagenan Kapal Asing (PKKA) (PNBP-JAL 08)";
		} else if (flag.equalsIgnoreCase(IPKA)) {
			desc = "Ijin Penggunaan Kapal Asing (IPKA) Angkutan Dalam Negeri (PNBP-JAL 09) Permittion of Using For Foreign Ship";
		} else if (flag.equalsIgnoreCase(RPT_OMISI_DEVIASI)) {
			desc = "Perubahan pada RPT Liner atau Tramper";
		} else if (flag.equalsIgnoreCase(PERUBAHAN_IZIN)) {
			desc = "Perubahan pada SIUPAL / SIOPSUS (PNBP-JAL 03)";
		} else {
			desc = "UNKNOWN";
		}
		return desc;
	}
}