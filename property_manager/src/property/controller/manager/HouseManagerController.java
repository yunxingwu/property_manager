package property.controller.manager;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;

import property.dao.HouseDao;
import property.entity.Build;
import property.entity.House;
import property.entity.Userinfo;
import property.service.ChargeService;
import property.service.HouseService;
//********************房产管理模块********************//
@Controller
@Transactional
public class HouseManagerController {
	@Autowired
	private HouseService houseservice;
	@Autowired
	private HouseDao<House> hdao;
	@Autowired
	private ChargeService chargeservice;
	
	//跳转到新增房间页面
	@RequestMapping("manager/addhouse.do")
    public String addhouse(HttpServletRequest request){
		List<Build> buildlist = houseservice.queryHouseId();  
//		System.out.println(buildlist);
        request.getSession().setAttribute("buildlist", buildlist);       
		return "../manager/addhouse";
	}
	
	//新增住房
	@RequestMapping("manager/house.do")
	public String addHouse(String hid,int builid,String houseType,String area,String remark,HttpServletRequest request){
		String houId = builid+"#"+hid;
		House ho = houseservice.checkhouse(houId, builid);
		if(ho==null){
		House h = new House();
		h.setAreas(area);
		h.setHouseId(houId);
		h.setHouseType(houseType);
		h.setRemark(remark);
		h.setStatus("未售");
		h.setBuild(houseservice.queryBuild(builid));
		houseservice.addHouse(h);
		return "../manager/successAddhouse";
		}
		return "../manager/failedAddhouse";
	}
	//检查房间是否已存在
	@RequestMapping("manager/check.do")
	public String checkHouse(String hid,int builid,HttpServletRequest request,HttpServletResponse response){
		System.out.println(hid+builid);
		String houId = builid+"#"+hid;
		House h = houseservice.checkhouse(houId, builid);
		if(h!=null){
			
			try {
				PrintWriter out = response.getWriter();
				out.write("创建房间失败");
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return "../manager/addhouse";
	}
	
	//查询房间列表
	@RequestMapping("manager/houselist.do")
    public String queryhouse(HttpServletRequest request){
		int shownumber = 7;
		int pageNumber = 1;
		int min = 1;
		int max = (int) Math.ceil(houseservice.getMax()/ (double) shownumber);
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
		List<House> h = houseservice.queryHouse(pageNumber);
		request.getSession().setAttribute("houlist", h);
		request.setAttribute("page1", page1);
		request.setAttribute("page2", page2);
		request.setAttribute("p", pageNumber);
		request.setAttribute("max", max);
		return "../manager/houselist";
	}
	
	//跳转到添加用户界面
		@RequestMapping("manager/toAddUser.do")
		public String toAddUser(HttpServletRequest request){
			List<House> h = houseservice.queryHouse1();
			request.setAttribute("hlist", h);
			return "../manager/adduser";
		}
		//删除房间
		@RequestMapping("manager/deleteH.do")
		public String deleteHouse(int hId,HttpServletRequest request, HttpServletResponse response){
			House house = houseservice.queryHouseById(hId);
			
			Userinfo user = chargeservice.queryUserId(house.getHouseId());
			if(user!=null){//说明该房间号有业主
				return "../manager/fail";
			}else{
				hdao.dele2(house.getId());
				System.out.println("删除成功");
			}
			
			return "../manager/userlist";
		}
}
