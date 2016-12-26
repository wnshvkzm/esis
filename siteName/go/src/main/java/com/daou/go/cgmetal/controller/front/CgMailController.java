package com.daou.go.cgmetal.controller.front;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.daou.go.cgmetal.component.MakeManufactureTable;
import com.daou.go.cgmetal.component.MakeOutSourcingTable;
import com.daou.go.cgmetal.component.MakePurchaseTable;
import com.daou.go.cgmetal.dao.ConnectionMaker;
import com.daou.go.cgmetal.dao.ErpConnectionMaker;
import com.daou.go.cgmetal.dao.ErpDao;
import com.daou.go.cgmetal.domain.ManufactureStatus;
import com.daou.go.cgmetal.domain.OutsourceStatus;
import com.daou.go.cgmetal.domain.PurchaseStatus;
import com.daou.go.cgmetal.service.CgMailService;
import com.daou.go.core.controller.front.FrontController;

@Controller
public class CgMailController extends FrontController {

	@Autowired
	private CgMailService cgMailService;

	@RequestMapping(value = "/purchase/insert/mail/entity", method = {
			RequestMethod.GET, RequestMethod.POST })
	public void insertPurchase() throws Exception {
		ConnectionMaker connection = new ErpConnectionMaker();
		ErpDao dao = new ErpDao(connection);

		List<PurchaseStatus> list = dao.getPurchaseCondition();
		List<PurchaseStatus> customList = dao.getCustomName();

		if (list.size() != 0) {
			MakePurchaseTable table = new MakePurchaseTable();
			table.makeTable(list, customList);
		}
	}

	@RequestMapping(value = "/outsourcing/insert/mail/entity", method = {
			RequestMethod.GET, RequestMethod.POST })
	public void insertOursourcing() throws Exception {

		ConnectionMaker connection = new ErpConnectionMaker();
		ErpDao dao = new ErpDao(connection);

		List<OutsourceStatus> decoList = dao.getOutsourceCondition();
		List<OutsourceStatus> customList = dao.getOutsourceCustomName();

		if (decoList.size() != 0 || customList.size() != 0) {
			MakeOutSourcingTable table = new MakeOutSourcingTable();
			table.makeTable(decoList, customList);
		}
	}

	@RequestMapping(value = "/manufacture/insert/mail/entity", method = {
			RequestMethod.GET, RequestMethod.POST })
	public void insertManufacture() throws Exception {

		ConnectionMaker connection = new ErpConnectionMaker();
		ErpDao dao = new ErpDao(connection);

		List<ManufactureStatus> shapeList = dao.getManufacture("1MA1-11");
		List<ManufactureStatus> holeList = dao.getManufacture("2MA1-11");
		List<ManufactureStatus> tabList = dao.getManufacture("3MA1-11");
		List<ManufactureStatus> assemblyList = dao.getManufacture("6MA1-11");
		List<ManufactureStatus> packList = dao.getManufacture("7MA1-11");

		List<String> shapeU = dao.getMailUser("1MA1-11");
		List<String> holeU = dao.getMailUser("2MA1-11");
		List<String> tabU = dao.getMailUser("3MA1-11");
		List<String> assemblyU = dao.getMailUser("6MA1-11");
		List<String> packU = dao.getMailUser("7MA1-11");

		if (shapeList.size() != 0 || holeList.size() != 0
				|| tabList.size() != 0 || assemblyList.size() != 0
				|| packList.size() != 0) {
			MakeManufactureTable table = new MakeManufactureTable();
			table.makeTable(shapeList, holeList, tabList, assemblyList,
					packList, shapeU, holeU, tabU, assemblyU, packU);
		}
	}
}
