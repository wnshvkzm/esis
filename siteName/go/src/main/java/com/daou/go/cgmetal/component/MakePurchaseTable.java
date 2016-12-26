package com.daou.go.cgmetal.component;

import java.sql.SQLException;
import java.util.List;

import com.daou.go.cgmetal.domain.PurchaseStatus;
import com.daou.go.cgmetal.service.CgMailService;
import com.daou.go.cgmetal.service.CgMailServiceImpl;

public class MakePurchaseTable {

	public MakePurchaseTable() {

	}

	public void makeTable(List<PurchaseStatus> list,
			List<PurchaseStatus> customList) throws SQLException {
		StringBuffer intro = new StringBuffer();
		intro.append("<br>안녕하세요 청구금속 입니다.<br>구매 발주 현황이 아래와 같이 존재합니다.<br>확인 부탁드립니다.<br>감사합니다. ")
		.append("<br><br><strong><h3>****************************************구매발주현황****************************************</h3></strong>");
		for (int i = 0; i < customList.size(); i++) {
			StringBuffer buffer = new StringBuffer();
			buffer.append("<br><strong>")
					.append(customList.get(i).getCustomName())
					.append("</strong>");
			String content = content(buffer, list, customList, i);
			getBean().vmailInsertValue("cgmetal@cg-plus.com",
					/*customList.get(i).getMailId()*/"1998leeeh@cg-plus.com",
					customList.get(i).getCustomName() + " 거래처 구매발주현황", intro+content);
		}
	}

	public String postTable(List<PurchaseStatus> list,
			List<PurchaseStatus> customList) {
		String content = "";
		StringBuffer buffer = new StringBuffer();

		for (int i = 0; i < customList.size(); i++) {
			buffer.append("<br><strong>").append(customList.get(i).getCustomName())
					.append("</strong>");
			content = content(buffer, list, customList, i);
		}

		return content;
	}

	public String content(StringBuffer buffer, List<PurchaseStatus> list,
			List<PurchaseStatus> customList, int i) {
		buffer.append("<table style='border : solid 1px black; width:100%'>")
				.append("<tr style='border : solid 1px black; text-align:center;'>")
				.append("<td style='border : solid 1px black; '><strong>")
				.append("품목계정")
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
				.append("납기일").append("</strong></td>")
				.append("<td style='border : solid 1px black; '><strong>")
				.append("발주일")
				.append("</strong></td>").append("</tr>");

		for (int j = 0; j < list.size(); j++) {
			
			if (customList.get(i).getCustomName()
					.equals(list.get(j).getCustomName())) {
				buffer.append(
						"<tr style='border : solid 1px black;'>")
						.append("<td style='border : solid 1px black; text-align: left'>")
						.append(list.get(j).getItemAccountName())
						.append("</td>")
						.append("<td style='border : solid 1px black; text-align: left'>")
						.append(list.get(j).getItemName())
						.append("</td>")
						.append("<td style='border : solid 1px black;text-align:right'>")
						.append(list.get(j).getOrderQ())
						.append("</td>")
						.append("<td style='border : solid 1px black; text-align:right'>")
						.append(list.get(j).getNotinstockQ())
						.append("</td>")
						.append("<td style='border : solid 1px black; text-align:center'>")
						.append(list.get(j).getDvryDate()).append("</td>")
						.append("<td style='border : solid 1px black; text-align:center'>")
						.append(list.get(j).getMakeDate())
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
