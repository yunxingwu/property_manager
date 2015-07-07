package property.dao;

import java.util.List;

import property.entity.Build;
import property.entity.Charge;
import property.entity.House;
import property.entity.Renttype;
import property.entity.Userinfo;
import property.entity.Water;

public interface ChargeDao<T> extends BaseDao<T> {

	public List<Build> queryHouseid();
	
	public List<House> queryHoustList(int id);
	
	public Userinfo queryUserId(String houseId);
	
	public String addWater(Water w);
	
	public List<Charge> queryCharge(int id,int page);
	
	public List<Charge> queryCharge1(int id,String date);
	
	public List<Charge> queryCharge2(int i,String date);
	
	public List<Renttype> queryRent();
	
	public List<Charge> queryAll(int i);
	
	public Charge queryByUserId(int id,String date);
	
	public Charge queryById(int id);
	
	public int getMaxcount();
	
	public int getMaxcount1(String date);
	
	public int getMax2(int id);
}
