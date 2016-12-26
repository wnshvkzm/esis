package com.daou.go.cgmetal.component;

import java.sql.SQLException;
import java.util.List;

import com.daou.go.cgmetal.domain.OutsourceStatus;
import com.daou.go.cgmetal.service.CgMailService;
import com.daou.go.cgmetal.service.CgMailServiceImpl;

public class MakeOutSourcingTable {

	public MakeOutSourcingTable() {

	}

	public void makeTable(List<OutsourceStatus> decoList, List<OutsourceStatus> customList)
			throws SQLException {
		StringBuffer intro = new StringBuffer();
		intro.append("안녕하세요 청구금속 입니다.<br>외주 발주 현황이 아래와 같이 존재합니다.<br>확인 부탁드립니다.<br>감사합니다. ")
		.append("<br><br><strong><h3>****************************************외주발주현황****************************************</h3></strong>");
		for (int i = 0; i < customList.size(); i++) {
			StringBuffer buffer = new StringBuffer();
			String content = content(buffer, decoList, customList, i);
			getBean().vmailInsertValue("cgmetal@cg-plus.com",
					"1998leeeh@cg-plus.com"/*customList.get(i).getMailId()*/,
					customList.get(i).getCustomName() + " 외주발주현황", intro+content);
		}
	}

	public String postTable(List<OutsourceStatus> decoList,
			List<OutsourceStatus> customList) {
		String content = "";
		StringBuffer buffer = new StringBuffer();

		for (int i = 0; i < customList.size(); i++) {
			buffer.append("<br><h2><strong>[ ")
					.append(customList.get(i).getCustomName())
					.append(" ]</strong></h2>");
			content = content(buffer, decoList, customList, i);
		}

		return content;
	}

	public String content(StringBuffer buffer, List<OutsourceStatus> decoList,
			List<OutsourceStatus> customList, int i) {

		buffer.append("<table style='border : solid 1px black; width:100%'>")
				.append("<tr style='border : solid 1px black; text-align:center;'>")
				.append("<td style='border : solid 1px black; '><strong>")
				.append("작업명")
				.append("</strong></td>")
				.append("<td style='border : solid 1px black; '><strong>")
				.append("품목명")
				.append("</strong></td>")
				.append("<td style='border : solid 1px black; '><strong>")
				.append("발주량")
				.append("</strong></td>")
				.append("<td style='border : solid 1px black;'><strong>")
				.append("미입고량")
				.append("</strong></td>")
				.append("<td style='border : solid 1px black; '><strong>")
				.append("납기일")
				.append("</strong></td>")
				.append("<td style='border : solid 1px black; '><strong>")
				.append("발주일")
				.append("</strong></td>")
				.append("</tr>");

		for (int j = 0; j < decoList.size(); j++) {
			if (customList.get(i).getCustomName()
					.equals(decoList.get(j).getCustomName())) {
				buffer.append("<tr style='border : solid 1px black;'>")
						.append("<td style='border : solid 1px black; text-align: left'>")
						.append(decoList.get(j).getTreeName())
						.append("</td>")
						.append("<td style='border : solid 1px black; text-align: left'>")
						.append(decoList.get(j).getItemName())
						.append("</td>")
						.append("<td style='border : solid 1px black; text-align:right'>")
						.append(decoList.get(j).getOrderQ())
						.append("</td>")
						.append("<td style='border : solid 1px black; text-align:right'>")
						.append(decoList.get(j).getNotinstockQ())
						.append("</td>")
						.append("<td style='border : solid 1px black; text-align:center;'>")
						.append(decoList.get(j).getDvryDate())
						.append("</td>")
						.append("<td style='border : solid 1px black; text-align:center'>")
						.append(decoList.get(j).getMakeDate())
						.append("</td>")
						.append("</tr>");
			}
		}
		buffer.append("</table><br>");

		return buffer.toString();
	}

	public CgMailService getBean() {
		CgMailService cgMailService = ApplicationContextHolder.getContext()
				.getBean(CgMailServiceImpl.class);
		return cgMailService;
	}
}
