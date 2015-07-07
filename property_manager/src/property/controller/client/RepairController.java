package property.controller.client;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;

import property.entity.Repair;
import property.entity.Userinfo;
import property.service.RepairService;

//********************在线报修模块*************************//
@Controller
@Transactional
public class RepairController {
	@Autowired
	RepairService repairservice;

	// 新增报修
	@RequestMapping("client/repair.do")
	public String addRepair(HttpServletRequest request) {
		Repair repair = new Repair();
		Userinfo user = (Userinfo) request.getSession().getAttribute("userinfo");
		repair.setRepairContent(request.getParameter("repairContent"));
		repair.setRepairType(request.getParameter("repairType"));
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");// 设置日期格式
		String repairTime = df.format(new Date());// new Date()为获取当前系统时间
		SimpleDateFormat d = new SimpleDateFormat("yyyyMMddHHmmss");
		String repairId = d.format(new Date());
		repair.setRepairStatus("未受理");
		repair.setRepairTime(repairTime);
		repair.setRepairId(repairId);
		repair.setUserinfo(user);
		repairservice.addRepair(repair);	
	return "../client/successRepair";
	}

	// 查询报修记录
	@RequestMapping("client/history.do")
	public String queryRepair(HttpServletRequest request) {
		Userinfo user = (Userinfo) request.getSession().getAttribute("userinfo");
		int shownumber = 6;
		int pageNumber = 1;
		int min = 1;
		int max = (int) Math.ceil(repairservice.getMax3(user.getId())/ (double) shownumber);
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
		List<Repair> list = repairservice.query(user.getId(),pageNumber);
		if(list!=null){
			request.getSession().setAttribute("List", list);
		}
		request.setAttribute("page1", page1);
		request.setAttribute("page2", page2);
		request.setAttribute("p", pageNumber);
		request.setAttribute("max", max);
		return "../client/historyrepair";
	}

}