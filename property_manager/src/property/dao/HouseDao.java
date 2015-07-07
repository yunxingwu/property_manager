package property.dao;

import java.util.List;

import property.entity.Build;

public interface HouseDao<House> extends BaseDao<House> {

	public List<Build> queryHouseid();
	public Build queryBuild(int buildId);
	public House checkHo(String h,int b);
	public List<House> queryAllHouse(int i);
	public List<House> queryAllHouse1();
	public int getmax();
	public House queryh(String hid);
	public House queryh1(int hid);
}
