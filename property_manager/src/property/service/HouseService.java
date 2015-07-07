package property.service;

import java.util.List;

import property.entity.Build;
import property.entity.House;

public interface HouseService {

	public List<Build> queryHouseId();
	public Build queryBuild(int buildId);
	public int addHouse(House h);
	public House checkhouse(String hid,int bid);
	public List<House> queryHouse(int i);
	public List<House> queryHouse1();
	public int getMax();
	public House queryHouseById(String hid);
	public House queryHouseById(int hid);
}
