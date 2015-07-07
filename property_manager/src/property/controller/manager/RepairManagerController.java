package property.controller.manager;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;

import property.dao.UserDao;
import property.entity.Repair;
import property.entity.Repairman;
import property.entity.Repairrecord;
import property.service.RepairService;

//********************报修管理模块*************************//
@Controller
@Transactional
public class RepairManagerController {

	@Autowired
	RepairService repairservice;
	@Autowired
	private UserDao<Repairrecord> mdao;
	@Autowired
	private UserDao<Repair> rdao;
    //报修列表
	@RequestMapping("manager/mrepair.do")
	public String queryRepair(HttpServletRequest request) {
		int shownumber = 7;
		int pageNumber = 1;
		int min = 1;
		int max = (int) Math.ceil(repairservice.getMax()/ (double) shownumber);
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
		List<Repair> list = repairservice.queryAll(pageNumber);
		if(list!=null){
			request.getSession().setAttribute("repairList", list);
		}
		request.setAttribute("page1", page1);
		request.setAttribute("page2", page2);
		request.setAttribute("p", pageNumber);
		request.setAttribute("max", max);
		return "../manager/repairlist";
	}
	//安排维修列表
	@RequestMapping("manager/dealrepair.do")
	public String dealRepair(HttpServletRequest request) {
		int shownumber = 7;
		int pageNumber = 1;
		int min = 1;
		int max = (int) Math.ceil(repairservice.getMax1()/ (double) shownumber);
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
		System.out.println("ppppp:"+pageNumber);
		int page1 = pageNumber - 1 < min ? pageNumber : pageNumber - 1;
		int page2 = pageNumber + 1 > max ? pageNumber : pageNumber + 1;
		List<Repair> list = repairservice.queryByStatus(pageNumber);
		if(list!=null){
			request.getSession().setAttribute("drepairList", list);
		}
		request.setAttribute("page1", page1);
		request.setAttribute("page2", page2);
		request.setAttribute("p", pageNumber);
		request.setAttribute("max", max);
		return "../manager/dealrepair";
	}
	//安排维修
		@RequestMapping("manager/detailrepair.do")
		public String detailRepair(String reid,HttpServletRequest request) {
			System.out.println(reid);
			Repair repair = repairservice.queryByRepairId(reid);
			List<Repairman> list=repairservice.queryman();
			request.getSession().setAttribute("repairman", list);
				request.getSession().setAttribute("r", repair);
			return "../manager/detailrepair";
		}
		//确认维修
		@RequestMapping("manager/drepair.do")
		public String detailRepai1r(String man,String rid,HttpServletRequest request) {
			System.out.println("come on");
			Repairman repairman = repairservice.queryByName(man);
			SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");// 设置日期格式
			String declareTime = df.format(new Date());// new Date()为获取当前系统时间
			Repairrecord record = new Repairrecord();
			record.setRepairMan(man);
			record.setRepairTime(declareTime);
			record.setPhone(repairman.getPhone());
			record.setResult("已派修");
			record.setRepairRecord(rid);
			mdao.add(record);
			Repair repair = repairservice.queryByRepairId(rid);
			repair.setDeclareTime(declareTime);
			repair.setPhone(repairman.getPhone());
			repair.setRepairMan(man);
			repair.setRepairStatus("已派修");
			rdao.update1(repair);
			System.out.println("ok!");
			return "../manager/successdorepair";
		}
		//维修记录
		@RequestMapping("manager/repairrecord.do")
			public String recordRepair(HttpServletRequest request) {
			int shownumber = 7;
			int pageNumber = 1;
			int min = 1;
			int max = (int) Math.ceil(repairservice.getMax2()/ (double) shownumber);
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
			List<Repairrecord> record = repairservice.queryRecord(pageNumber);
				request.getSession().setAttribute("repairrecord", record);
				request.setAttribute("page1", page1);
				request.setAttribute("page2", page2);
				request.setAttribute("p", pageNumber);
				request.setAttribute("max", max);
				return "../manager/recordlist";
			}
		//处理完成
		@RequestMapping("manager/achieverepair.do")
		public String achieveRepair(String reid,HttpServletRequest request) {
			System.out.println(reid);
			Repair repair = repairservice.queryByRepairId(reid);
			repair.setRepairStatus("已处理");
			rdao.update1(repair);
			Repairrecord record = repairservice.queryRecordById(reid);
			record.setResult("已处理");
			mdao.update1(record);
			return "../manager/successachieve";
		}
		//删除报修记录
				@RequestMapping("manager/deleteR.do")
				public String deleteRepair(int reId,HttpServletRequest request) {
					System.out.println(reId);
					repairservice.deleteR(reId);				
					return "../manager/repairlist";
				}
}
