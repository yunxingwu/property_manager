package property.controller.client;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;

import property.entity.Complain;
import property.entity.Userinfo;
import property.service.ComplainService;
//**************在线投诉模块*************************//
@Controller
@Transactional
public class ComplainController {

	@Autowired
	private ComplainService complainservice;
	//新增意见
	@RequestMapping("client/complain.do")
	public String addComplain(String comContent,HttpServletRequest request){
		Userinfo user = (Userinfo) request.getSession().getAttribute("userinfo");
		Complain complain = new Complain();
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");// 设置日期格式
		String complainTime = df.format(new Date());// new Date()为获取当前系统时间
		SimpleDateFormat d = new SimpleDateFormat("yyyyMMddHHmmss");
		String complainId = d.format(new Date());
		complain.setComplainContent(comContent);
		complain.setComplainTime(complainTime);
		complain.setComplainId(complainId);
		complain.setUserinfo(user);
		complainservice.addComplain(complain);
		return "../client/successComplain";
	}
	
	//查看历史记录
	@RequestMapping("client/historycomplain.do")
	public String queryComplainHistory(HttpServletRequest request){
		Userinfo user = (Userinfo) request.getSession().getAttribute("userinfo");
		int shownumber = 6;
		int pageNumber = 1;
		int min = 1;
		int max = (int) Math.ceil(complainservice.getMax1(user.getId())/ (double) shownumber);
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
		List<Complain> list = complainservice.query(user.getId(),pageNumber);
		request.getSession().setAttribute("complainList", list);
		request.setAttribute("page1", page1);
		request.setAttribute("page2", page2);
		request.setAttribute("p", pageNumber);
		request.setAttribute("max", max);
		return "../client/historycomplain";
	}
}
