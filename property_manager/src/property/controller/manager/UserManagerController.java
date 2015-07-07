package property.controller.manager;

import java.util.List;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import property.dao.HouseDao;
import property.dao.UserDao;
import property.entity.Manager;


import property.entity.House;

import property.entity.Userinfo;

import property.service.HouseService;


@Controller
public class UserManagerController {
	@Autowired
	private UserDao<Userinfo> userdao;
	@Autowired
	private UserDao<Manager> mdao;
//	@Autowired
//	private UserDao<Repair> rdao;
//	@Autowired
//	private UserDao<Complain> comdao;
//	@Autowired
//	private UserDao<Water> wdao;
//	@Autowired
//	private UserDao<Electric> edao;
//	@Autowired
//	private UserDao<Gas> gdao;
//	@Autowired
//	private UserDao<Charge> cdao;
	@Autowired
	private HouseService houseservice;
	@Autowired
	private HouseDao<House> hdao;
	@Autowired
	private UserDao<Userinfo> udao;

	//管理员登陆验证
	@RequestMapping("manager/Mlogin.do")
	public String checkMlogin(String username, String password,HttpServletRequest request) {
		Manager m = new Manager();
		m = mdao.Mlogin(username, password);
		if (m != null) {
			request.getSession().setAttribute("manager", m);
			return "../manager/index";
		}
		request.setAttribute("error", "用户名或密码错误");
		return "../manager/login";
	}
	
	
	// 新增用户
	@RequestMapping("manager/adduser.do")
	public String addUser(String uname,String houseId,String sex,String phone,
			String address,String cardId,String unit,String email,HttpServletRequest request) {
		Userinfo user = new Userinfo();
		House house = houseservice.queryHouseById(houseId);
		house.setStatus("已售");
		hdao.update1(house);
		user.setHouseId(houseId);
		user.setUserId("c"+houseId);
		user.setPassword("123");
		user.setAddress(address);
		user.setCardId(cardId);
		user.setEmail(email);
		user.setPhone(phone);
		user.setSex(sex);
		user.setUserName(uname);
		user.setUnit(unit);
		userdao.add(user);
		return "../manager/successAdd";
	}

	//查询用户列表
	@RequestMapping("manager/userlist.do")
	public String userlist(HttpServletRequest request) {
		int shownumber = 8;
		int pageNumber = 1;
		int min = 1;
		int max = (int) Math.ceil(mdao.getMax()/ (double) shownumber);
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
		List<Userinfo> user = userdao.queryUser(pageNumber);
		request.getSession().setAttribute("ulist", user);
		request.setAttribute("page1", page1);
		request.setAttribute("page2", page2);
		request.setAttribute("p", pageNumber);
		return "../manager/userlist";
	}
	//根据姓名查找用户
		@RequestMapping("manager/queryuser.do")
		public String queryuser(String uname,HttpServletRequest request) {
			List<Userinfo> user = userdao.queryByname(uname);
			request.setAttribute("ulist", user);
			return "../manager/userlist1";
		}
		//注销登录
		@RequestMapping("manager/mexit.do")
		public String exitLogin(HttpServletRequest request, HttpServletResponse response){
			request.getSession().removeAttribute("manager");
			return "redirect:../manager/login.jsp";
		}
		//删除用户
				@RequestMapping("manager/deleteU.do")
				public String deleteUser(int uId,HttpServletRequest request, HttpServletResponse response){
					Userinfo user = userdao.queryUserById(uId);
//					System.out.println(user.getUserName());
//					Set<Repair> r=user.getRepairs();
//					for(Repair repair:r){
//						System.out.println(repair.getRepairContent());
//						rdao.dele(repair);
//					}
//					Set<Complain> com = user.getComplains();
//					for(Complain complain:com){
//						comdao.dele(complain);
//					}
//					Set<Water> w = user.getWaters();
//					for(Water water:w){
//						wdao.dele(water);
//					}
//					Set<Electric> e = user.getElectrics();
//					for(Electric electric:e){
//						edao.dele(electric);
//					}
//					Set<Gas> g = user.getGases();
//					for(Gas gas:g){
//						gdao.dele(gas);
//					}
//					Set<Charge> c = user.getCharges();
//					for(Charge charge:c){
//						cdao.dele(charge);
//					}
					House house = houseservice.queryHouseById(user.getHouseId());
					house.setStatus("未售");
					hdao.update1(house);
					udao.dele1(user.getId());
					System.out.println("删除成功");
					return "../manager/userlist";
				}

}
