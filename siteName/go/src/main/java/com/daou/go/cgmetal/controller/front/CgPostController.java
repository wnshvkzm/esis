package com.daou.go.cgmetal.controller.front;

import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.daou.go.cgmetal.component.MakeManufactureTable;
import com.daou.go.cgmetal.component.MakeOutSourcingTable;
import com.daou.go.cgmetal.component.MakePurchaseTable;
import com.daou.go.cgmetal.component.MakeStockTable;
import com.daou.go.cgmetal.dao.ConnectionMaker;
import com.daou.go.cgmetal.dao.ErpConnectionMaker;
import com.daou.go.cgmetal.dao.ErpDao;
import com.daou.go.cgmetal.domain.ManufactureStatus;
import com.daou.go.cgmetal.domain.OutsourceStatus;
import com.daou.go.cgmetal.domain.PurchaseStatus;
import com.daou.go.cgmetal.domain.StockStatus;
import com.daou.go.cgmetal.service.CgPostService;

@Controller
public class CgPostController {

	@Autowired
	private CgPostService cgPostService;

	@RequestMapping(value = "/make/stock/cmds", method = { RequestMethod.GET,
			RequestMethod.POST })
	public void makeStockCmds() throws SQLException, ClassNotFoundException {

		ConnectionMaker connection = new ErpConnectionMaker();
		ErpDao dao = new ErpDao(connection);

		List<StockStatus> productList = dao.getStockCondition("10");
		List<StockStatus> semiProductList = dao.getStockCondition("20");
		List<StockStatus> partsProductList = dao.getStockCondition("25");
		List<StockStatus> workingProductList = dao.getStockCondition("28");
		List<StockStatus> materialList = dao.getStockCondition("40");
		List<StockStatus> subMaterialList = dao.getStockCondition("50");
		List<StockStatus> packingList = dao.getStockCondition("55");

		if (productList.size() != 0 || semiProductList.size() != 0
				|| partsProductList.size() != 0
				|| workingProductList.size() != 0 || materialList.size() != 0
				|| subMaterialList.size() != 0 || packingList.size() != 0) {

			String content = new MakeStockTable().makeTable(productList,
					semiProductList, partsProductList, workingProductList,
					materialList, subMaterialList, packingList);

			cgPostService.makeCmdsFile(content, 50L, "1998leeeh", Date()
					+ " 재고현황", null, null, "S");
		}
	}

	@RequestMapping(value = "/make/purchase/cmds", method = {
			RequestMethod.GET, RequestMethod.POST })
	public void makePurchaseCmds() throws Exception {
		ConnectionMaker connection = new ErpConnectionMaker();
		ErpDao dao = new ErpDao(connection);

		List<PurchaseStatus> list = dao.getPurchaseCondition();
		List<PurchaseStatus> customList = dao.getCustomName();

		if (list.size() != 0) {
			String content = new MakePurchaseTable()
					.postTable(list, customList);
			cgPostService.makeCmdsFile(content, 52L, "1998leeeh", Date()
					+ " 구매발주현황", null, null, "P");
		}
	}

	@RequestMapping(value = "/make/outsourcing/cmds", method = {
			RequestMethod.GET, RequestMethod.POST })
	public void makeOutsourcingCmds() throws Exception {
		ConnectionMaker connection = new ErpConnectionMaker();
		ErpDao dao = new ErpDao(connection);

		List<OutsourceStatus> decoList = dao.getOutsourceCondition();
		List<OutsourceStatus> customList = dao.getOutsourceCustomName();

		if (decoList.size() != 0 || customList.size() != 0) {
			String content = new MakeOutSourcingTable().postTable(decoList,
					customList);
			cgPostService.makeCmdsFile(content, 53L, "1998leeeh", Date()
					+ " 외주발주현황", null, null, "O");
		}
	}

	@RequestMapping(value = "/make/manufacture/cmds", method = {
			RequestMethod.GET, RequestMethod.POST })
	public void makeManufactureCmds() throws Exception {
		ConnectionMaker connection = new ErpConnectionMaker();
		ErpDao dao = new ErpDao(connection);

		List<ManufactureStatus> shapeList = dao.getManufacture("1MA1-11");
		List<ManufactureStatus> holeList = dao.getManufacture("2MA1-11");
		List<ManufactureStatus> tabList = dao.getManufacture("3MA1-11");
		List<ManufactureStatus> assemblyList = dao.getManufacture("6MA1-11");
		List<ManufactureStatus> packList = dao.getManufacture("7MA1-11");

		if (shapeList.size() != 0 || holeList.size() != 0
				|| tabList.size() != 0 || assemblyList.size() != 0
				|| packList.size() != 0) {
			String content = new MakeManufactureTable().postTable(shapeList,
					holeList, tabList, assemblyList, packList);

			cgPostService.makeCmdsFile(content, 51L, "1998leeeh", Date()
					+ " 생산작업현황", null, null, "M");
		}
	}

	public String Date() {
		Date date = new Date();
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy.MM.dd");

		String today = dateFormat.format(date);

		return today;
	}
}
