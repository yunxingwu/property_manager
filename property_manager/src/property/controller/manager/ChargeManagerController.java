package property.controller.manager;

import java.io.UnsupportedEncodingException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;

import property.dao.UserDao;
import property.entity.Build;
import property.entity.Charge;
import property.entity.Electric;
import property.entity.Gas;
import property.entity.House;
import property.entity.Renttype;
import property.entity.Userinfo;
import property.entity.Water;
import property.service.ChargeService;
//************************费用管理模块**************************//
@Controller
@Transactional
public class ChargeManagerController {

	@Autowired
	private ChargeService chargeservice;
	
	@Autowired
	private UserDao<Charge> mdao;
	
	@Autowired
	private UserDao<Renttype> rdao;
	
	@RequestMapping("manager/waterInit.do")
	public String buildQuery1(HttpServletRequest request){	  
        List<Build> houselist = chargeservice.queryHouseId();    
        request.getSession().setAttribute("buildlist", houselist);       
		return "../manager/water";
	}
	@RequestMapping("manager/elecInit.do")
	public String buildQuery2(HttpServletRequest request){	  
        List<Build> houselist = chargeservice.queryHouseId();    
        request.getSession().setAttribute("buildlist", houselist);       
		return "../manager/electric";
	}
	@RequestMapping("manager/gasInit.do")
	public String buildQuery3(HttpServletRequest request){	  
        List<Build> houselist = chargeservice.queryHouseId();    
        request.getSession().setAttribute("buildlist", houselist);       
		return "../manager/gas";
	}
	//选择楼栋号
	@RequestMapping("manager/water.do")
	public String houseIdList1(int buildId,String year,String month,HttpServletRequest request){
		String date = year+month;
		List<House> houselist = chargeservice.queryHouseList(buildId);
		request.setAttribute("y", year);
		request.setAttribute("m", month);
		request.setAttribute("houselist", houselist);
		return "../manager/water";
	}
	    //选择楼栋号
		@RequestMapping("manager/electric.do")
		public String houseIdList2(int buildId,String year,String month,HttpServletRequest request){
			List<House> houselist = chargeservice.queryHouseList(buildId);
			request.setAttribute("y", year);
			request.setAttribute("m", month);
			request.setAttribute("houselist", houselist);
			return "../manager/electric";
		}
		//选择楼栋号
		@RequestMapping("manager/gas.do")
		public String houseIdList3(int buildId,String year,String month,HttpServletRequest request){
			List<House> houselist = chargeservice.queryHouseList(buildId);
			request.setAttribute("y", year);
			request.setAttribute("m", month);
			request.setAttribute("houselist", houselist);
			return "../manager/gas";
		}
	//水费录入
	@RequestMapping("manager/waterInput.do")
	public String waterInput(String ret,String year,String month,HttpServletRequest request,HttpServletResponse response){
		String date = year+month;
		String [] a = ret.split(";");
		for(int i = 0;i<a.length;i++){
			Water w = new Water();
			Charge c = new Charge();
			String [] b = a[i].split(",");
			float water = Float.parseFloat(b[0]);
			float rent =(float)mdao.renttypew();
			float rwater = water*rent;
			float propertyfee = (float)mdao.renttypep();
			String houseId = b[1];
			Userinfo user = chargeservice.queryUserId(houseId);//根据账号查找到用户
			if(user!=null){ //说明用户存在
			w.setMonth(date);
			w.setWater(water);
			w.setUserinfo(user);
			Charge r =mdao.judge(user.getId(), date);
			//判断在费用表中是否已存在该用户的不完整费用记录
			if(r!=null){  //说明存在
				Water  wa = mdao.judgeWater(user.getId(), date);//查找用水量表中是否存在用户的数据
				if(wa==null){ //用水量表中不存在用户此月的数据，可以录入
					r.setRwater(rwater);
					r.setWater(water);
					r.setTotal(r.getRgas()+r.getRwater()+r.getRelectric()+r.getPropertyfee());
					mdao.update(r);
				}else{  //该用户此月的数据已录入过数据库，不能重复录入
					return "../manager/fail";
				}				
			}else{
				c.setMonth(date);
				c.setUserinfo(user);
				c.setWater(water);
				c.setRwater(rwater);
				c.setPropertyfee(propertyfee);
				c.setStatus("未交费");
				float rele = 0;
				float rgas = 0;
				c.setRelectric(rele);
				c.setRgas(rgas);
				c.setTotal(rwater+propertyfee);
				mdao.add(c);
			}
			chargeservice.addWater(w);
			}
					
			System.out.println(rwater);
		}
		return "../manager/success";
	}
	
	//电费录入
		@RequestMapping("manager/electricInput.do")
		public String electricInput(String ret,String year,String month,HttpServletRequest request,HttpServletResponse response){
			String date = year+month;
			String [] a = ret.split(";");
			for(int i = 0;i<a.length;i++){
				Electric w = new Electric();
				Charge c = new Charge();
				String [] b = a[i].split(",");
				float electric = Float.parseFloat(b[0]);
				String houseId = b[1];
				float rent =(float)mdao.renttypee();
				float relectric = electric*rent;
				float propertyfee = (float)mdao.renttypep();
				Userinfo user = chargeservice.queryUserId(houseId);
				if(user!=null){
				w.setMonth(date);
				w.setElectric(electric);
				w.setUserinfo(user);
				Charge r =mdao.judge(user.getId(), date);
				if(r!=null){
					Electric e = mdao.judgeElectric(user.getId(), date);
					if(e==null){
						r.setElectric(electric);
						r.setRelectric(relectric);
						r.setTotal(r.getRgas()+r.getRwater()+r.getRelectric()+r.getPropertyfee());
						mdao.update(r);
					}else{
						return "../manager/fail";
					}			
				}else{
					c.setMonth(date);
					c.setUserinfo(user);
					c.setElectric(electric);
					c.setRelectric(relectric);
					c.setPropertyfee(propertyfee);
					c.setStatus("未交费");
					float rwater = 0;
					float rgas = 0;
					c.setRwater(rwater);
					c.setRgas(rgas);
					c.setTotal(relectric+propertyfee);
					mdao.add(c);
				}
				chargeservice.addElectric(w);
				}	
			}
			return "../manager/success";
		}
		
		//燃气费录入
		@RequestMapping("manager/gasInput.do")
		public String gasInput(String ret,String year,String month,HttpServletRequest request,HttpServletResponse response){
			String date = year+month;
			String [] a = ret.split(";");
			for(int i = 0;i<a.length;i++){
				Gas g = new Gas();
				Charge c = new Charge();
				String [] b = a[i].split(",");
				float gas = Float.parseFloat(b[0]);
				String houseId = b[1];
				float rent =(float)mdao.renttypeg();
				float rgas = gas*rent;
				float propertyfee = (float)mdao.renttypep();
				Userinfo user = chargeservice.queryUserId(houseId);
				if(user!=null){
				g.setMonth(date);
				g.setGas(gas);
				g.setUserinfo(user);
				Charge r =mdao.judge(user.getId(), date);
				if(r!=null){
					Gas  ga = mdao.judgeGas(user.getId(), date);
					if(ga==null){
						r.setGas(gas);
						r.setRgas(rgas);
						r.setTotal(r.getRgas()+r.getRwater()+r.getRelectric()+r.getPropertyfee());
						mdao.update(r);
					}else{
						return "../manager/fail";
					}			
				}else{
					c.setMonth(date);
					c.setUserinfo(user);
					c.setGas(gas);
					c.setRgas(rgas);
					c.setStatus("未交费");
					float rwater = 0;
					float rele = 0;
					c.setRwater(rwater);
					c.setRelectric(rele);
					c.setPropertyfee(propertyfee);
					c.setTotal(rgas+propertyfee);
					mdao.add(c);
				}
				chargeservice.addGas(g);
				}	
			}
			return "../manager/success";
		}
		//费用修改
		@RequestMapping("manager/renttype.do")
		public String renttype(HttpServletRequest request){	  
	        List<Renttype> rentlist = chargeservice.queryRentList();    
	        request.getSession().setAttribute("rentlist", rentlist); 
			return "../manager/updaterenttype";
		}
		
		//费用查询
		@RequestMapping("manager/mcharge.do")
		public String queryall(HttpServletRequest request){	
			int shownumber = 8;
			int pageNumber = 1;
			int min = 1;
			int max = (int) Math.ceil(chargeservice.getMax()/ (double) shownumber);
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

			    List<Charge> charge = chargeservice.queryAllCharge(pageNumber);    
			    request.getSession().setAttribute("chargelist", charge);   
			    request.setAttribute("page1", page1);
				request.setAttribute("page2", page2);
				request.setAttribute("p", pageNumber);
				request.setAttribute("max", max);
				return "../manager/chargelist";
			}
		//按年月查询费用信息
		@RequestMapping("manager/chargequery.do")
		public String chargeQuery(String year,String month,String d,HttpServletRequest request){			
			String date = d;		
			if(date==null){
				date = year+month;
			}
			System.out.println("date"+date);
			int shownumber = 8;
			int pageNumber = 1;
			int min = 1;
			int max = (int) Math.ceil(chargeservice.getMax1(date)/ (double) shownumber);
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
            System.out.println("ppppp:"+pageNumber+max);
            
			int page1 = pageNumber - 1 < min ? pageNumber : pageNumber - 1;
			int page2 = pageNumber + 1 > max ? pageNumber : pageNumber + 1;
			List<Charge> list = chargeservice.queryCharge2(pageNumber,date);
			request.setAttribute("chargelist", list);
			request.setAttribute("y", year);
			request.setAttribute("m", month);
			request.setAttribute("page1", page1);
		    request.setAttribute("page2", page2);
			request.setAttribute("p", pageNumber);
			request.setAttribute("date", date);
			request.setAttribute("max", max);
			return "../manager/chargelist1";
		}
		//缴费用户查询
		@RequestMapping("manager/payment.do")
		public String payment(String year,String month,String houseId,HttpServletRequest request){
			String date = "";
			String hou = "";
			date = year+month;
			hou = houseId;
			Userinfo user = chargeservice.queryUserId(hou);
			if(user!=null){
			List<Charge> charge = chargeservice.queryCharge1(user.getId(), date);
			request.setAttribute("y", year);
			request.setAttribute("m", month);
			request.setAttribute("chargel", charge);
			}	
			return "../manager/payment";
		}
		//确认缴费
		@RequestMapping("manager/achievepay.do")
		public String achievepay(int id,HttpServletRequest request) throws UnsupportedEncodingException{
			String cname = new String(request.getParameter("cname").getBytes("iso8859-1"),"utf-8");
			SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");// 设置日期格式
			String cdate = df.format(new Date());// new Date()为获取当前系统时间
			Charge charge = chargeservice.queryById(id);
			charge.setCdate(cdate);
			charge.setCname(cname);
			charge.setStatus("已缴费");
			mdao.update1(charge); 	
			return "../manager/paysuccess";
		}
		//费用修改
				@RequestMapping("manager/updaterent.do")
				public String updaterenttype(String ret,HttpServletRequest request){
					System.out.println(ret);
					String [] a = ret.split(";");
					for(int i = 0;i<a.length;i++){
						String [] b = a[i].split(",");
						int id =Integer.parseInt(b[1]);
						double price = Double.parseDouble(b[0]);
						Renttype type = rdao.queryRent(id);
						type.setId(id);
						type.setPrice(price);
						rdao.update(type);
					}
					
					return "../manager/paysuccess";
				}
		
}
