package property.controller.manager;


import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;

import property.entity.Notice;
import property.service.UserService;
//*********************公告管理模块************************//
@Controller
@Transactional
public class NoticeManagerController {

	@Autowired
	private UserService userservice;
	
	//发布公告
	@RequestMapping("manager/notice.do")
	public String addNotice(String title,String content,String type,HttpServletRequest request){
		Notice noti = new Notice();
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");// 设置日期格式
		String noticeTime = df.format(new Date());// new Date()为获取当前系统时间
		noti.setTitle(title);
		noti.setContent(content);
		noti.setType(type);
		noti.setNoticeTime(noticeTime);		
		userservice.addNotice(noti);
		return "../manager/successNotice";
	}
	//公告列表
	@RequestMapping("manager/noticehistory.do")
	public String queryHistory(HttpServletRequest request){
		int shownumber = 8;
		int pageNumber = 1;
		int min = 1;
		int max = (int) Math.ceil(userservice.getMax()/ (double) shownumber);
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
		List<Notice> notice = userservice.queryNoti(pageNumber);
		request.getSession().setAttribute("notiList", notice);
		request.setAttribute("page1", page1);
		request.setAttribute("page2", page2);
		request.setAttribute("p", pageNumber);
		request.setAttribute("max", max);
		return "../manager/historypublish";
	}
	//删除公告
	@RequestMapping("manager/deleteN.do")
	public String deleteNoti(int NoticeId,HttpServletRequest request,HttpServletResponse response){
		userservice.deleteNotice(NoticeId);	
		return "../manager/historypublish";
	}
	//浏览公告
		@RequestMapping("client/content.do")
		public String lookNoti(int id,HttpServletRequest request){
			System.out.println("aaaaaaaaaaaa");
			Notice notice = userservice.queryById(id);
			request.setAttribute("noti", notice);
			return "../client/content";
		}
	
}
