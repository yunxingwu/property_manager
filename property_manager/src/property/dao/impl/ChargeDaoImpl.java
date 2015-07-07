package property.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import property.dao.ChargeDao;
import property.entity.Build;
import property.entity.Charge;
import property.entity.House;
import property.entity.Renttype;
import property.entity.Userinfo;
import property.entity.Water;


@Repository
public class ChargeDaoImpl extends BaseDaoImpl<Charge> implements ChargeDao<Charge> {

	@Override
	public List<Build> queryHouseid() {
		String sql = "select * from build";
		Query q = this.getSession().createSQLQuery(sql).addEntity(Build.class);	
		return q.list();
	}

	@Override
	public List<House> queryHoustList(int id) {
		String sql = "select * from house where  house.buildId = ? and house.status = '已售'";
		Query query = this.getSession().createSQLQuery(sql).addEntity(House.class);
		query.setInteger(0, id);
		return query.list();
	}

	@Override
	public Userinfo queryUserId(String houseId) {
		String sql="select * from userinfo where houseId = ?";
		Query q = this.getSession().createSQLQuery(sql).addEntity(Userinfo.class);	
		q.setString(0, houseId);
		List<Userinfo> li = q.list();
		if(li.size()!=0){
		    return li.get(0);
		}else{
			return null;
		}	
	}

	@Override
	public String addWater(Water w) {
		
		return null;
	}

	@Override
	public List<Charge> queryCharge(int id,int page) {
		int num =6;
		String sql = "select * from charge where charge.userId = ? limit "+(page-1)*6+","+num;
		System.out.println(sql);
		Query query = this.getSession().createSQLQuery(sql).addEntity(Charge.class);
		query.setInteger(0, id);
		return query.list();
	}

	@Override
	public List<Charge> queryCharge1(int id, String date) {
		String sql="select * from charge where userId = ? and charge.`month`= ?";
		Query q = this.getSession().createSQLQuery(sql).addEntity(Charge.class);	
		q.setInteger(0, id);
		q.setString(1, date);
		List<Charge> li = q.list();
		return li;
	}

	@Override
	public List<Renttype> queryRent() {
		String sql = "select * from renttype";
		Query q = this.getSession().createSQLQuery(sql).addEntity(Renttype.class);	
		return q.list();
	}

	@Override
	public List<Charge> queryAll(int pagenum) {
		int num = 8;
		String sql = "select * from charge limit "+(pagenum-1)*8+","+num;
		Query q = this.getSession().createSQLQuery(sql).addEntity(Charge.class);	
		return q.list();
	}

	@Override
	public List<Charge> queryCharge2(int pagenum,String date) {
		int num = 8;
		String sql="select * from charge where charge.`month`= ? limit "+(pagenum-1)*8+","+num;
		Query q = this.getSession().createSQLQuery(sql).addEntity(Charge.class);	
		q.setString(0, date);
		List<Charge> li = q.list();
		return li;
	}

	@Override
	public Charge queryByUserId(int id,String date) {
		String sql="select * from charge where userId = ? and charge.`month`= ?";
		Query q = this.getSession().createSQLQuery(sql).addEntity(Userinfo.class);	
		q.setInteger(0, id);
		q.setString(1, date);
		List<Charge> li = q.list();
		if(li.size()!=0){
		    return li.get(0);
		}else{
			return null;
		}	
	}

	@Override
	public Charge queryById(int id) {
		String sql="select * from charge where id = ?";
		Query q = this.getSession().createSQLQuery(sql).addEntity(Charge.class);	
		q.setInteger(0, id);
		List<Charge> li = q.list();
		if(li.size()!=0){
		    return li.get(0);
		}else{
			return null;
		}	
	}

	@Override
	public int getMaxcount() {
		String sql = "select * from charge";
		Query q = this.getSession().createSQLQuery(sql).addEntity(Charge.class);
		List<Charge> c = q.list();
		return c.size();
	}

	@Override
	public int getMaxcount1(String date) {
		String sql = "select * from charge where charge.`month`= ?";
		Query q = this.getSession().createSQLQuery(sql).addEntity(Charge.class);
		q.setString(0, date);
		List<Charge> c = q.list();
		return c.size();
	}

	@Override
	public int getMax2(int id) {
		String sql = "select * from charge where charge.userId = ?";
		Query q = this.getSession().createSQLQuery(sql).addEntity(Charge.class);
		q.setInteger(0, id);
		List<Charge> c = q.list();
		return c.size();
	}
	
	

}
