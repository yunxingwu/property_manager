package property.service;

import java.util.List;

import property.entity.Build;
import property.entity.Charge;
import property.entity.Electric;
import property.entity.Gas;
import property.entity.House;
import property.entity.Renttype;
import property.entity.Userinfo;
import property.entity.Water;

public interface ChargeService {

	public List<Build> queryHouseId();
	public List<House> queryHouseList(int buildId);
	public Userinfo queryUserId(String houseId);
	public int addWater(Water w);
	public int addElectric(Electric e);
	public int addGas(Gas g);
	public int addProper();
	public List<Charge> queryCharge(int id,int page);
	public  List<Charge> queryCharge1(int id,String date);
	public List<Renttype> queryRentList();
	public List<Charge> queryAllCharge(int i);
	public List<Charge> queryCharge2(int i,String date);
	public Charge queryByUserId(int id,String date);
    public Charge queryById(int id);
    public int getMax();
    public int getMax1(String date);
    public int getMax2(int id);
	
}
