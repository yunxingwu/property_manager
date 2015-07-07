package property.controller.client;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;

import property.entity.Charge;
import property.entity.Userinfo;
import property.service.ChargeService;

//*********************费用查询模块*************************//
@Controller
@Transactional
public class ChargeController {
	@Autowired
	ChargeService chargeservice;
	//按年月查询费用信息
	@RequestMapping("client/chargequery.do")
	public String chargeQuery(String year,String month,HttpServletRequest request){
		String date = year+month;
		Userinfo user = (Userinfo) request.getSession().getAttribute("userinfo");
		List<Charge> list = chargeservice.queryCharge1(user.getId(),date);
		request.setAttribute("chargelist", list);
		System.out.println("date==="+date);
		return "../client/chargequery1";
	}
	//按查询本人费用信息
	@RequestMapping("client/charge.do")
	public String chargeQuery1(HttpServletRequest request){
		Userinfo user = (Userinfo) request.getSession().getAttribute("userinfo");
		int shownumber = 6;
		int pageNumber = 1;
		int min = 1;
		int max = (int) Math.ceil(chargeservice.getMax2(user.getId())/ (double) shownumber);
		String p = request.getParameter("pageNumber");
		String p1 = (String)request.getAttribute("pnum");
		if(p1 != null){
			pageNumber = Integer.parseInt(p1);
		}		   
		if (p != null) {
			// 如果第一次访问这个页面，那么是没有pageNumber这个参数的
			// 如果不为空，说明是通过上一页，下一页的标签过来的，有pageNumber参数
			pageNumber = Integer.parseInt(p);
		}
		int page1 = pageNumber - 1 < min ? pageNumber : pageNumber - 1;
		int page2 = pageNumber + 1 > max ? pageNumber : pageNumber + 1;
		List<Charge> list = chargeservice.queryCharge(user.getId(),pageNumber);
		request.setAttribute("chargelist", list);
		request.setAttribute("page1", page1);
		request.setAttribute("page2", page2);
		request.setAttribute("p", pageNumber);
		request.setAttribute("max", max);
		return "../client/chargequery";
	}

}
