package com.daou.go.cgmetal.component;

import java.sql.SQLException;
import java.util.List;

import com.daou.go.cgmetal.domain.ManufactureStatus;
import com.daou.go.cgmetal.service.CgMailService;
import com.daou.go.cgmetal.service.CgMailServiceImpl;

public class MakeManufactureTable {

	public MakeManufactureTable() {

	}

	public void makeTable(List<ManufactureStatus> shapeList,
			List<ManufactureStatus> holeList, List<ManufactureStatus> tabList,
			List<ManufactureStatus> assemblyList,
			List<ManufactureStatus> packList, List<String> shapeU,
			List<String> holeU, List<String> tabU, List<String> assemblyU,
			List<String> packU) throws SQLException {

/*		String shape = shapeU.toString();
		String hole = holeU.toString();
		String tab = tabU.toString();
		String assembly = assemblyU.toString();
		String pack = packU.toString();
*/
		StringBuffer intro = new StringBuffer();
		intro.append(
				"안녕하세요 청구금속 입니다.<br>생산 작업 현황이 아래와 같이 존재합니다.<br>확인 부탁드립니다.<br>감사합니다. ")
				.append("<br><br><strong><h3>**********************************************생산 작업현황**********************************************</h3></strong>");

		for (int i = 1; i < 6; i++) {
			StringBuffer buffer = new StringBuffer();
			if (i == 1) {
				buffer.append("<br><strong>").append("성형 작업장")
						.append("</strong>");
				String content = content(buffer, i, shapeList).toString();
				getBean().vmailInsertValue("cgmetal@cg-plus.com",
						/*shape.substring(1, shape.length() - 1)*/"1998leeeh@cg-plus.com", "성형 작업장 생산현황",
						intro + content);
			}

			if (i == 2) {
				buffer.append("<br><strong>").append("홀 작업장")
						.append("</strong>");
				String content = content(buffer, i, holeList).toString();
				getBean().vmailInsertValue("cgmetal@cg-plus.com",
						/*hole.substring(1, hole.length() - 1)*/"1998leeeh@cg-plus.com", "홀 작업장 생산현황",
						intro + content);
			}

			if (i == 3) {
				buffer.append("<br><strong>").append("탭 작업장")
						.append("</strong>");
				String content = content(buffer, i, tabList).toString();
				getBean().vmailInsertValue("cgmetal@cg-plus.com",
						/*tab.substring(1, tab.length() - 1)*/"1998leeeh@cg-plus.com", "탭 작업장 생산현황",
						
						intro + content);
			}

			if (i == 4) {
				buffer.append("<br><strong>").append("조립 작업장")
						.append("</strong>");
				String content = content(buffer, i, assemblyList).toString();
				getBean().vmailInsertValue("cgmetal@cg-plus.com",
						/*assembly.substring(1, assembly.length() - 1)*/"1998leeeh@cg-plus.com",
						"조립 작업장 생산현황", intro + content);
			}

			if (i == 5) {
				buffer.append("<br><strong>").append("포장 작업장")
						.append("</strong>");
				String content = content(buffer, i, packList).toString();
				getBean().vmailInsertValue("cgmetal@cg-plus.com",
						"1998leeeh@cg-plus.com"/*pack.substring(1, pack.length() - 1)*/, "포장 작업장 생산현황",
						intro + content);
			}
		}

	}

	public String postTable(List<ManufactureStatus> shapeList,
			List<ManufactureStatus> holeList, List<ManufactureStatus> tabList,
			List<ManufactureStatus> assemblyList,
			List<ManufactureStatus> packList) {
		String content = "";
		StringBuffer buffer = new StringBuffer();

		for (int i = 1; i < 6; i++) {
			if (i == 1) {
				buffer.append("<br><strong>").append("(1) 성형 작업장")
						.append("</strong>");
				content = content(buffer, i, shapeList).toString();
			}

			if (i == 2) {
				buffer.append("<strong>").append("(2) 홀 작업장")
						.append("</strong>");
				content = content(buffer, i, holeList).toString();
			}

			if (i == 3) {
				buffer.append("<strong>").append("(3) 탭 작업장")
						.append("</strong>");
				content = content(buffer, i, tabList).toString();
			}

			if (i == 4) {
				buffer.append("<strong>").append("(4) 조립 작업장")
						.append("</strong>");
				content = content(buffer, i, assemblyList).toString();
			}

			if (i == 5) {
				buffer.append("<strong>").append("(5) 포장 작업장")
						.append("</strong>");
				content = content(buffer, i, packList).toString();
			}
		}
		return content;
	}

	public String content(StringBuffer buffer, int i,
			List<ManufactureStatus> list) {
		buffer.append("<table style='border : solid 1px black; width:100%'>")
				.append("<tr style='border : solid 1px black; text-align:center;'>")
				.append("<td style='border : solid 1px black;' ><strong>")
				.append("품명")
				.append("</strong></td>")
				.append("<td style='border : solid 1px black;' ><strong>")
				.append("작업자")
				.append("</strong></td>")
				.append("<td style='border : solid 1px black;' ><strong>")
				.append("지시량")
				.append("</strong></td>")
				.append("<td style='border : solid 1px black;' ><strong>")
				.append("시간가동률")
				.append("</strong></td>")
				.append("<td style='border : solid 1px black;'><strong>")
				.append("성능가동률")
				.append("</strong></td>")
				.append("<td style='border : solid 1px black;' ><strong>")
				.append("양품률")
				.append("</strong></td>")
				.append("<td style='border : solid 1px black;'><strong>")
				.append("종합효율")
				.append("</strong></td>")
				.append("<td style='border : solid 1px black;'><strong>")
				.append("비고").append("</strong></td></tr>");

		switch (i) {
		case 1:
			realData(list, buffer);
			break;
		case 2:
			realData(list, buffer);
			break;
		case 3:
			realData(list, buffer);
			break;
		case 4:
			realData(list, buffer);
			break;
		case 5:
			realData(list, buffer);
			break;
		}

		buffer.append("</table><br>");

		return buffer.toString();
	}

	public void realData(List<ManufactureStatus> list, StringBuffer buffer) {
		for (int j = 0; j < list.size(); j++) {
			buffer.append("<tr style='border : solid 1px black; '>")
					.append("<td style='border : solid 1px black; text-align: left'>")
					.append(list.get(j).getItemName())
					.append("</td>")
					.append("<td style='border : solid 1px black; text-align: left'>")
					.append("")
					.append("</td>")
					.append("<td style='border : solid 1px black; text-align: right'>")
					.append(list.get(j).getWkordQ())
					.append("</td>")
					.append("<td style='border : solid 1px black; text-align:right'>")
					.append(list.get(j).getTimeRate())
					.append("</td>")
					.append("<td style='border : solid 1px black; text-align:right'>")
					.append(list.get(j).getTempn03())
					.append("</td>")
					.append("<td style='border : solid 1px black; text-align:right'>")
					.append(list.get(j).getGoodRate())
					.append("</td>")
					.append("<td style='border : solid 1px black; text-align:right'>")
					.append(list.get(j).getTotalRate())
					.append("</td>")
					.append("<td style='border : solid 1px black; text-align:center'>")
					.append("").append("</td>").append("</tr>");
		}
	}

	public CgMailService getBean() {
		CgMailService cgMailService = ApplicationContextHolder.getContext()
				.getBean(CgMailServiceImpl.class);
		return cgMailService;
	}
}
