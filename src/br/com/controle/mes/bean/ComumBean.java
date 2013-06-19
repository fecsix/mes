package br.com.controle.mes.bean;

import javax.enterprise.context.RequestScoped;
import javax.faces.model.SelectItem;
import javax.inject.Named;

import br.com.controle.mes.enumerate.SimNao;
import br.com.controle.mes.enumerate.TipoCentroTrabalho;
import br.com.controle.mes.model.enumerate.StatusOP;

@RequestScoped
@Named
public class ComumBean {
	
	public SelectItem[] getTipoCentroTrabalho() {
		SelectItem[] items = new SelectItem[TipoCentroTrabalho.values().length];
		int i = 0;
		for (TipoCentroTrabalho item : TipoCentroTrabalho.values())
			items[i++] = new SelectItem(item, item.getDescricao());
		return items;
	}

	public SelectItem[] getSimNao() {
		SelectItem[] items = new SelectItem[SimNao.values().length];
		int i = 0;
		for (SimNao item : SimNao.values())
			items[i++] = new SelectItem(item, item.getDescricao());
		return items;
	}

	public SelectItem[] getStatusOP() {
		SelectItem[] items = new SelectItem[StatusOP.values().length];
		int i = 0;
		for (StatusOP item : StatusOP.values())
			items[i++] = new SelectItem(item, item.getDescricao());
		return items;
	}
	
	public SelectItem[] getIcone() {
		SelectItem[] items = new SelectItem[170];
		items[0] = new SelectItem("ui-icon-carat-1-n", "ui-icon-carat-1-n");
		items[1] = new SelectItem("ui-icon-carat-1-ne", "ui-icon-carat-1-ne");
		items[2] = new SelectItem("ui-icon-carat-1-e", "ui-icon-carat-1-e");
		items[3] = new SelectItem("ui-icon-carat-1-se", "ui-icon-carat-1-se");
		items[4] = new SelectItem("ui-icon-carat-1-s", "ui-icon-carat-1-s");
		items[5] = new SelectItem("ui-icon-carat-1-sw", "ui-icon-carat-1-sw");
		items[6] = new SelectItem("ui-icon-carat-1-w", "ui-icon-carat-1-w");
		items[7] = new SelectItem("ui-icon-carat-1-nw", "ui-icon-carat-1-nw");
		items[8] = new SelectItem("ui-icon-carat-2-n-s", "ui-icon-carat-2-n-s");
		items[9] = new SelectItem("ui-icon-carat-2-e-w", "ui-icon-carat-2-e-w");
		items[10] = new SelectItem("ui-icon-triangle-1-n",
				"ui-icon-triangle-1-n");
		items[11] = new SelectItem("ui-icon-triangle-1-ne",
				"ui-icon-triangle-1-ne");
		items[12] = new SelectItem("ui-icon-triangle-1-e",
				"ui-icon-triangle-1-e");
		items[13] = new SelectItem("ui-icon-triangle-1-se",
				"ui-icon-triangle-1-se");
		items[14] = new SelectItem("ui-icon-triangle-1-s",
				"ui-icon-triangle-1-s");
		items[15] = new SelectItem("ui-icon-triangle-1-sw",
				"ui-icon-triangle-1-sw");
		items[16] = new SelectItem("ui-icon-triangle-1-w",
				"ui-icon-triangle-1-w");
		items[17] = new SelectItem("ui-icon-triangle-1-nw",
				"ui-icon-triangle-1-nw");
		items[18] = new SelectItem("ui-icon-triangle-2-n-s",
				"ui-icon-triangle-2-n-s");
		items[19] = new SelectItem("ui-icon-triangle-2-e-w",
				"ui-icon-triangle-2-e-w");
		items[20] = new SelectItem("ui-icon-arrow-1-n", "ui-icon-arrow-1-n");
		items[21] = new SelectItem("ui-icon-arrow-1-ne", "ui-icon-arrow-1-ne");
		items[22] = new SelectItem("ui-icon-arrow-1-e", "ui-icon-arrow-1-e");
		items[23] = new SelectItem("ui-icon-arrow-1-se", "ui-icon-arrow-1-se");
		items[24] = new SelectItem("ui-icon-arrow-1-s", "ui-icon-arrow-1-s");
		items[25] = new SelectItem("ui-icon-arrow-1-sw", "ui-icon-arrow-1-sw");
		items[26] = new SelectItem("ui-icon-arrow-1-w", "ui-icon-arrow-1-w");
		items[27] = new SelectItem("ui-icon-arrow-1-nw", "ui-icon-arrow-1-nw");
		items[28] = new SelectItem("ui-icon-arrow-2-n-s", "ui-icon-arrow-2-n-s");
		items[29] = new SelectItem("ui-icon-arrow-2-ne-sw",
				"ui-icon-arrow-2-ne-sw");
		items[30] = new SelectItem("ui-icon-arrow-2-e-w", "ui-icon-arrow-2-e-w");
		items[31] = new SelectItem("ui-icon-arrow-2-se-nw",
				"ui-icon-arrow-2-se-nw");
		items[32] = new SelectItem("ui-icon-arrowstop-1-n",
				"ui-icon-arrowstop-1-n");
		items[33] = new SelectItem("ui-icon-arrowstop-1-e",
				"ui-icon-arrowstop-1-e");
		items[34] = new SelectItem("ui-icon-arrowstop-1-s",
				"ui-icon-arrowstop-1-s");
		items[35] = new SelectItem("ui-icon-arrowstop-1-w",
				"ui-icon-arrowstop-1-w");
		items[36] = new SelectItem("ui-icon-arrowthick-1-n",
				"ui-icon-arrowthick-1-n");
		items[37] = new SelectItem("ui-icon-arrowthick-1-ne",
				"ui-icon-arrowthick-1-ne");
		items[38] = new SelectItem("ui-icon-arrowthick-1-e",
				"ui-icon-arrowthick-1-e");
		items[39] = new SelectItem("ui-icon-arrowthick-1-se",
				"ui-icon-arrowthick-1-se");
		items[40] = new SelectItem("ui-icon-arrowthick-1-s",
				"ui-icon-arrowthick-1-s");
		items[41] = new SelectItem("ui-icon-arrowthick-1-sw",
				"ui-icon-arrowthick-1-sw");
		items[42] = new SelectItem("ui-icon-arrowthick-1-w",
				"ui-icon-arrowthick-1-w");
		items[43] = new SelectItem("ui-icon-arrowthick-1-nw",
				"ui-icon-arrowthick-1-nw");
		items[44] = new SelectItem("ui-icon-arrowthick-2-n-s",
				"ui-icon-arrowthick-2-n-s");
		items[45] = new SelectItem("ui-icon-arrowthick-2-ne-sw",
				"ui-icon-arrowthick-2-ne-sw");
		items[46] = new SelectItem("ui-icon-arrowthick-2-e-w",
				"ui-icon-arrowthick-2-e-w");
		items[47] = new SelectItem("ui-icon-arrowthick-2-se-nw",
				"ui-icon-arrowthick-2-se-nw");
		items[48] = new SelectItem("ui-icon-arrowthickstop-1-n",
				"ui-icon-arrowthickstop-1-n");
		items[49] = new SelectItem("ui-icon-arrowthickstop-1-e",
				"ui-icon-arrowthickstop-1-e");
		items[50] = new SelectItem("ui-icon-arrowthickstop-1-s",
				"ui-icon-arrowthickstop-1-s");
		items[51] = new SelectItem("ui-icon-arrowthickstop-1-w",
				"ui-icon-arrowthickstop-1-w");
		items[52] = new SelectItem("ui-icon-arrowreturnthick-1-w",
				"ui-icon-arrowreturnthick-1-w");
		items[53] = new SelectItem("ui-icon-arrowreturnthick-1-n",
				"ui-icon-arrowreturnthick-1-n");
		items[54] = new SelectItem("ui-icon-arrowreturnthick-1-e",
				"ui-icon-arrowreturnthick-1-e");
		items[55] = new SelectItem("ui-icon-arrowreturnthick-1-s",
				"ui-icon-arrowreturnthick-1-s");
		items[56] = new SelectItem("ui-icon-arrowreturn-1-w",
				"ui-icon-arrowreturn-1-w");
		items[57] = new SelectItem("ui-icon-arrowreturn-1-n",
				"ui-icon-arrowreturn-1-n");
		items[58] = new SelectItem("ui-icon-arrowreturn-1-e",
				"ui-icon-arrowreturn-1-e");
		items[59] = new SelectItem("ui-icon-arrowreturn-1-s",
				"ui-icon-arrowreturn-1-s");
		items[60] = new SelectItem("ui-icon-arrowrefresh-1-w",
				"ui-icon-arrowrefresh-1-w");
		items[61] = new SelectItem("ui-icon-arrowrefresh-1-n",
				"ui-icon-arrowrefresh-1-n");
		items[62] = new SelectItem("ui-icon-arrowrefresh-1-e",
				"ui-icon-arrowrefresh-1-e");
		items[63] = new SelectItem("ui-icon-arrowrefresh-1-s",
				"ui-icon-arrowrefresh-1-s");
		items[64] = new SelectItem("ui-icon-arrow-4", "ui-icon-arrow-4");
		items[65] = new SelectItem("ui-icon-arrow-4-diag",
				"ui-icon-arrow-4-diag");
		items[66] = new SelectItem("ui-icon-extlink", "ui-icon-extlink");
		items[67] = new SelectItem("ui-icon-newwin", "ui-icon-newwin");
		items[68] = new SelectItem("ui-icon-refresh", "ui-icon-refresh");
		items[69] = new SelectItem("ui-icon-shuffle", "ui-icon-shuffle");
		items[70] = new SelectItem("ui-icon-transfer-e-w",
				"ui-icon-transfer-e-w");
		items[71] = new SelectItem("ui-icon-transferthick-e-w",
				"ui-icon-transferthick-e-w");
		items[72] = new SelectItem("ui-icon-folder-collapsed",
				"ui-icon-folder-collapsed");
		items[73] = new SelectItem("ui-icon-folder-open", "ui-icon-folder-open");
		items[74] = new SelectItem("ui-icon-document", "ui-icon-document");
		items[75] = new SelectItem("ui-icon-document-b", "ui-icon-document-b");
		items[76] = new SelectItem("ui-icon-note", "ui-icon-note");
		items[77] = new SelectItem("ui-icon-mail-closed", "ui-icon-mail-closed");
		items[78] = new SelectItem("ui-icon-mail-open", "ui-icon-mail-open");
		items[79] = new SelectItem("ui-icon-suitcase", "ui-icon-suitcase");
		items[80] = new SelectItem("ui-icon-comment", "ui-icon-comment");
		items[81] = new SelectItem("ui-icon-person", "ui-icon-person");
		items[82] = new SelectItem("ui-icon-print", "ui-icon-print");
		items[83] = new SelectItem("ui-icon-trash", "ui-icon-trash");
		items[84] = new SelectItem("ui-icon-locked", "ui-icon-locked");
		items[85] = new SelectItem("ui-icon-unlocked", "ui-icon-unlocked");
		items[86] = new SelectItem("ui-icon-bookmark", "ui-icon-bookmark");
		items[87] = new SelectItem("ui-icon-tag", "ui-icon-tag");
		items[88] = new SelectItem("ui-icon-home", "ui-icon-home");
		items[89] = new SelectItem("ui-icon-flag", "ui-icon-flag");
		items[90] = new SelectItem("ui-icon-calculator", "ui-icon-calculator");
		items[91] = new SelectItem("ui-icon-cart", "ui-icon-cart");
		items[92] = new SelectItem("ui-icon-pencil", "ui-icon-pencil");
		items[93] = new SelectItem("ui-icon-clock", "ui-icon-clock");
		items[94] = new SelectItem("ui-icon-disk", "ui-icon-disk");
		items[95] = new SelectItem("ui-icon-calendar", "ui-icon-calendar");
		items[96] = new SelectItem("ui-icon-zoomin", "ui-icon-zoomin");
		items[97] = new SelectItem("ui-icon-zoomout", "ui-icon-zoomout");
		items[98] = new SelectItem("ui-icon-search", "ui-icon-search");
		items[99] = new SelectItem("ui-icon-wrench", "ui-icon-wrench");
		items[100] = new SelectItem("ui-icon-gear", "ui-icon-gear");
		items[101] = new SelectItem("ui-icon-heart", "ui-icon-heart");
		items[102] = new SelectItem("ui-icon-star", "ui-icon-star");
		items[103] = new SelectItem("ui-icon-link", "ui-icon-link");
		items[104] = new SelectItem("ui-icon-cancel", "ui-icon-cancel");
		items[105] = new SelectItem("ui-icon-plus", "ui-icon-plus");
		items[106] = new SelectItem("ui-icon-plusthick", "ui-icon-plusthick");
		items[107] = new SelectItem("ui-icon-minus", "ui-icon-minus");
		items[108] = new SelectItem("ui-icon-minusthick", "ui-icon-minusthick");
		items[109] = new SelectItem("ui-icon-close", "ui-icon-close");
		items[110] = new SelectItem("ui-icon-closethick", "ui-icon-closethick");
		items[111] = new SelectItem("ui-icon-key", "ui-icon-key");
		items[112] = new SelectItem("ui-icon-lightbulb", "ui-icon-lightbulb");
		items[113] = new SelectItem("ui-icon-scissors", "ui-icon-scissors");
		items[114] = new SelectItem("ui-icon-clipboard", "ui-icon-clipboard");
		items[115] = new SelectItem("ui-icon-copy", "ui-icon-copy");
		items[116] = new SelectItem("ui-icon-contact", "ui-icon-contact");
		items[117] = new SelectItem("ui-icon-image", "ui-icon-image");
		items[118] = new SelectItem("ui-icon-video", "ui-icon-video");
		items[119] = new SelectItem("ui-icon-alert", "ui-icon-alert");
		items[120] = new SelectItem("ui-icon-info", "ui-icon-info");
		items[121] = new SelectItem("ui-icon-notice", "ui-icon-notice");
		items[122] = new SelectItem("ui-icon-help", "ui-icon-help");
		items[123] = new SelectItem("ui-icon-check", "ui-icon-check");
		items[124] = new SelectItem("ui-icon-bullet", "ui-icon-bullet");
		items[125] = new SelectItem("ui-icon-radio-off", "ui-icon-radio-off");
		items[126] = new SelectItem("ui-icon-radio-on", "ui-icon-radio-on");
		items[127] = new SelectItem("ui-icon-play", "ui-icon-play");
		items[128] = new SelectItem("ui-icon-pause", "ui-icon-pause");
		items[129] = new SelectItem("ui-icon-seek-next", "ui-icon-seek-next");
		items[130] = new SelectItem("ui-icon-seek-prev", "ui-icon-seek-prev");
		items[131] = new SelectItem("ui-icon-seek-end", "ui-icon-seek-end");
		items[132] = new SelectItem("ui-icon-seek-first", "ui-icon-seek-first");
		items[133] = new SelectItem("ui-icon-stop", "ui-icon-stop");
		items[134] = new SelectItem("ui-icon-eject", "ui-icon-eject");
		items[135] = new SelectItem("ui-icon-volume-off", "ui-icon-volume-off");
		items[136] = new SelectItem("ui-icon-volume-on", "ui-icon-volume-on");
		items[137] = new SelectItem("ui-icon-power", "ui-icon-power");
		items[138] = new SelectItem("ui-icon-signal-diag",
				"ui-icon-signal-diag");
		items[139] = new SelectItem("ui-icon-signal", "ui-icon-signal");
		items[140] = new SelectItem("ui-icon-battery-0", "ui-icon-battery-0");
		items[141] = new SelectItem("ui-icon-battery-1", "ui-icon-battery-1");
		items[142] = new SelectItem("ui-icon-battery-2", "ui-icon-battery-2");
		items[143] = new SelectItem("ui-icon-battery-3", "ui-icon-battery-3");
		items[144] = new SelectItem("ui-icon-circle-plus",
				"ui-icon-circle-plus");
		items[145] = new SelectItem("ui-icon-circle-minus",
				"ui-icon-circle-minus");
		items[146] = new SelectItem("ui-icon-circle-close",
				"ui-icon-circle-close");
		items[147] = new SelectItem("ui-icon-circle-triangle-e",
				"ui-icon-circle-triangle-e");
		items[148] = new SelectItem("ui-icon-circle-triangle-s",
				"ui-icon-circle-triangle-s");
		items[149] = new SelectItem("ui-icon-circle-triangle-w",
				"ui-icon-circle-triangle-w");
		items[150] = new SelectItem("ui-icon-circle-triangle-n",
				"ui-icon-circle-triangle-n");
		items[151] = new SelectItem("ui-icon-circle-arrow-e",
				"ui-icon-circle-arrow-e");
		items[152] = new SelectItem("ui-icon-circle-arrow-s",
				"ui-icon-circle-arrow-s");
		items[153] = new SelectItem("ui-icon-circle-arrow-w",
				"ui-icon-circle-arrow-w");
		items[154] = new SelectItem("ui-icon-circle-arrow-n",
				"ui-icon-circle-arrow-n");
		items[155] = new SelectItem("ui-icon-circle-zoomin",
				"ui-icon-circle-zoomin");
		items[156] = new SelectItem("ui-icon-circle-zoomout",
				"ui-icon-circle-zoomout");
		items[157] = new SelectItem("ui-icon-circle-check",
				"ui-icon-circle-check");
		items[158] = new SelectItem("ui-icon-circlesmall-plus",
				"ui-icon-circlesmall-plus");
		items[159] = new SelectItem("ui-icon-circlesmall-minus",
				"ui-icon-circlesmall-minus");
		items[160] = new SelectItem("ui-icon-circlesmall-close",
				"ui-icon-circlesmall-close");
		items[161] = new SelectItem("ui-icon-squaresmall-plus",
				"ui-icon-squaresmall-plus");
		items[162] = new SelectItem("ui-icon-squaresmall-minus",
				"ui-icon-squaresmall-minus");
		items[163] = new SelectItem("ui-icon-squaresmall-close",
				"ui-icon-squaresmall-close");
		items[164] = new SelectItem("ui-icon-grip-dotted-vertical",
				"ui-icon-grip-dotted-vertical");
		items[165] = new SelectItem("ui-icon-grip-dotted-horizontal",
				"ui-icon-grip-dotted-horizontal");
		items[166] = new SelectItem("ui-icon-grip-solid-vertical",
				"ui-icon-grip-solid-vertical");
		items[167] = new SelectItem("ui-icon-grip-solid-horizontal",
				"ui-icon-grip-solid-horizontal");
		items[168] = new SelectItem("ui-icon-gripsmall-diagonal-se",
				"ui-icon-gripsmall-diagonal-se");
		items[169] = new SelectItem("ui-icon-grip-diagonal-se",
				"ui-icon-grip-diagonal-se");
		return items;
	}
}