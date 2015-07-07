package property.controller.manager;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;

import property.entity.Complain;
import property.entity.Userinfo;
import property.service.ComplainService;

//********************投诉管理模块*************************//
@Controller
@Transactional
public class ComplainManagerController {

	@Autowired
	private ComplainService complainservice;
	//查询投诉列表
	@RequestMapping("manager/mcomplain.do")
	public String queryComplain(HttpServletRequest request){
		int shownumber = 8;
		int pageNumber = 1;
		int min = 1;
		int max = (int) Math.ceil(complainservice.getMax()/ (double) shownumber);
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
			List<Complain> list = complainservice.queryAll(pageNumber);
			request.getSession().setAttribute("complainlist", list);
			request.setAttribute("page1", page1);
			request.setAttribute("page2", page2);
			request.setAttribute("p", pageNumber);
			request.setAttribute("max",max);
			return "../manager/complainlist";
	}
	//删除投诉信息
	@RequestMapping("manager/deleteC.do")
	public String deleteNoti(int complainId,HttpServletRequest request,HttpServletResponse response){
		complainservice.deleteC(complainId);
		return "../manager/complainlist";
	}
}
