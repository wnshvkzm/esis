package com.daou.go.cgmetal.component;

import java.util.List;

import com.daou.go.cgmetal.domain.StockStatus;

public class MakeStockTable {

	public MakeStockTable() {
	}

	public String makeTable(List<StockStatus> productList,
			List<StockStatus> semiProductList,
			List<StockStatus> partsProductList,
			List<StockStatus> workingProductList,
			List<StockStatus> materialList, 
			List<StockStatus> subMaterialList,
			List<StockStatus> packingList) {

		StringBuffer buffer = new StringBuffer();
		
		for (int i = 1; i < 8; i++) {
			if (i == 1) {
				buffer.append("<br><strong>").append("(1)제품").append("</strong>");
				content(buffer,productList);
			} else if (i == 2) {
				buffer.append("<strong>").append("(2)반제품").append("</strong>");
				content(buffer,semiProductList);
			} else if (i == 3) {
				buffer.append("<strong>").append("(3)부분품").append("</strong>");
				content(buffer,partsProductList);
			} else if (i == 4) {
				buffer.append("<strong>").append("(4)재공품").append("</strong>");
				content(buffer,workingProductList);
			} else if (i == 5) {
				buffer.append("<strong>").append("(5)원자재").append("</strong>");
				content(buffer,materialList);
			} else if (i == 6) {
				buffer.append("<strong>").append("(6)부자재").append("</strong>");
				content(buffer,subMaterialList);
			} else if (i == 7) {
				buffer.append("<strong>").append("(7)포장재").append("</strong>");
				content(buffer,packingList);
			}
			
		}

		return buffer.toString();
	}

	public void content(StringBuffer buffer, List<StockStatus> list) {
		buffer.append("<table style='border : solid 1px black; width:100%'>")
		.append("<tr style='border : solid 1px black; text-align:center;'>")
		.append("<td style='border : solid 1px black;'><strong>")
		.append("품목코드").append("</strong></td>")
		.append("<td style='border : solid 1px black; '><strong>")
		.append("품명").append("</strong></td>")
		.append("<td style='border : solid 1px black; '><strong>")
		.append("안전부족률").append("</strong></td>")
		.append("<td style='border : solid 1px black; '><strong>")
		.append("수량").append("</strong></td>")
		.append("<td style='border : solid 1px black;'><strong>")
		.append("안전재고").append("</strong></td>");
		
		for (int j = 0; j < list.size(); j++) {
			buffer.append("<tr style='border : solid 1px black; text-align:center '>")
					.append("<td style='border : solid 1px black; text-align: left'>")
					.append(list.get(j).getItemCode()).append("</td>")
					.append("<td style='border : solid 1px black;text-align: left'>")
					.append(list.get(j).getItemName()).append("</td>")
					.append("<td style='border : solid 1px black; text-align:right'>")
					.append(list.get(j).getSafeStockPer()).append("</td>")
					.append("<td style='border : solid 1px black; text-align:right'>")
					.append(list.get(j).getStockQ()).append("</td>")
					.append("<td style='border : solid 1px black; text-align:right'>")
					.append(list.get(j).getSafeStockQ()).append("</td>")
					.append("</tr>");
		}
		buffer.append("</table><br>");
	}

}
