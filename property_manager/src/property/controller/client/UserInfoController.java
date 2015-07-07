package property.controller.client;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import property.dao.UserDao;
import property.entity.Notice;
import property.entity.Userinfo;
import property.service.UserService;
import util.MD5Util;

@Controller
public class UserInfoController {
	@Autowired
	private UserService usersevice;
	@Autowired
	private UserDao<Userinfo> userdao;
    //业主登陆验证
	@RequestMapping("client/Ulogin.do")
	public String Ulogin(String username, String password,
			HttpServletRequest request,HttpServletResponse response) {
		System.out.println(username);
		System.out.println(password);
		Userinfo user = new Userinfo();
		user = usersevice.checkULogin(username, password);
		if (user != null) {
			request.getSession().setAttribute("userinfo", user);
			setAutoLogin(username,password,response);
			return "../client/index";
		}
		request.setAttribute("error", "用户名或密码错误");    
     	return "../client/index";
	}
	public void setAutoLogin(String userName, String password, HttpServletResponse response) {
		String value = userName+":"+MD5Util.md5(password);
		Cookie cookie = new Cookie("loginInfo", value);
		cookie.setMaxAge(3600*24*30);
		cookie.setPath("/");
		response.addCookie(cookie);
	}
	//注销登录
	@RequestMapping("client/exit.do")
	public String exitLogin(HttpServletRequest request, HttpServletResponse response){
		Cookie cookie = new Cookie("loginInfo",null);
		cookie.setMaxAge(0);
		cookie.setPath("/");
		response.addCookie(cookie);
		request.getSession().removeAttribute("userinfo");
		return "redirect:../client/index.jsp";
	}
	//公告列表
			@RequestMapping("client/index.do")
			public String queryNotice(HttpServletRequest request,HttpServletResponse response){
				System.out.println("aaaaa");
				List<Notice> notice = usersevice.queryN();
				List<Notice> notice1 = usersevice.queryN1();
				List<Notice> notice2= usersevice.queryN2();
				List<Notice> notice3 = usersevice.queryN3();
				System.out.println("bbb");
				request.getSession().setAttribute("noticeList", notice);
				request.getSession().setAttribute("noticeList1", notice1);
				request.getSession().setAttribute("noticeList2", notice2);
				request.getSession().setAttribute("noticeList3", notice3);
				return "../client/index";
			}
			//修改密码
			@RequestMapping("client/password.do")
			public String updatepassword(String id,String pwd1,String pwd2,String pwd3,HttpServletRequest request){
				Userinfo user =(Userinfo) request.getSession().getAttribute("userinfo");
				System.out.println(pwd1);
				System.out.println(pwd2);
				System.out.println(pwd3);
				if(user.getPassword().equals(pwd1)){
					if(pwd2.equals(pwd3)){
						user.setPassword(pwd2);
						userdao.update1(user);
						return "../client/successpassword";
					}
			}
				return "../client/failedpassword";		
			}
			//用户信息修改
			@RequestMapping("client/updateuser.do")
			public String updateuser(String cardId,String phone,String email,String address,String unit,HttpServletRequest request){
				Userinfo user =(Userinfo) request.getSession().getAttribute("userinfo");
				user.setCardId(cardId);
				user.setAddress(address);
				user.setPhone(phone);
				user.setEmail(email);
				user.setUnit(unit);
				userdao.update1(user);
				return "../client/successupdateuser";
			}
}
