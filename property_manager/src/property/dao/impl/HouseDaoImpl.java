package property.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import property.dao.HouseDao;
import property.entity.Build;
import property.entity.House;
import property.entity.Userinfo;

@Repository
public class HouseDaoImpl extends BaseDaoImpl<House> implements HouseDao<House> {

	public List<Build> queryHouseid() {
		String sql = "select * from build";
		Query q = this.getSession().createSQLQuery(sql).addEntity(Build.class);	
		return q.list();
	}

	@Override
	public Build queryBuild(int buildId) {
		String sql="select * from build where buildId = ?";
		Query q = this.getSession().createSQLQuery(sql).addEntity(Build.class);	
		q.setInteger(0, buildId);
		List<Build> li = q.list();
		if(li.size()!=0){
		    return  li.get(0);
		}else{
			return null;
		}	
	}

	@Override
	public House checkHo(String h, int b) {
		String sql="select * from house where buildId = ? and houseId = ?";
		Query q = this.getSession().createSQLQuery(sql).addEntity(House.class);	
		q.setInteger(0, b);
		q.setString(1, h);
		List<House> li = q.list();
		if(li.size()!=0){
		    return  li.get(0);
		}else{
			return null;
		}	
	}

	@Override
	public List<House> queryAllHouse(int pagenum) {
		int num = 7;
		String sql = "select * from house limit "+(pagenum-1)*7+","+num;
		Query q = this.getSession().createSQLQuery(sql).addEntity(House.class);	
		return q.list();
	}

	@Override
	public List<House> queryAllHouse1() {
		String sql = "select * from house where house.status = '未售'";
		Query q = this.getSession().createSQLQuery(sql).addEntity(House.class);	
		return q.list();
	}

	@Override
	public int getmax() {
		String sql = "select * from house";
		Query query = this.getSession().createSQLQuery(sql).addEntity(House.class);
		List<House> house = query.list();
	    return house.size();
	}

	@Override
	public House queryh(String hid) {
		String sql="select * from house where houseId = ?";
		Query q = this.getSession().createSQLQuery(sql).addEntity(House.class);	
		q.setString(0, hid);
		List<House> li = q.list();
		if(li.size()!=0){
		    return  li.get(0);
		}else{
			return null;
		}	
	}

	@Override
	public House queryh1(int hid) {
		String sql="select * from house where id = ?";
		Query q = this.getSession().createSQLQuery(sql).addEntity(House.class);	
		q.setInteger(0, hid);
		List<House> li = q.list();
		if(li.size()!=0){
		    return  li.get(0);
		}else{
			return null;
		}	
	}
}
