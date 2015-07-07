package property.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import property.dao.ChargeDao;
import property.dao.HouseDao;
import property.entity.Build;
import property.entity.House;
import property.service.HouseService;

@Service
public class HouseServiceImpl implements HouseService {

	@Autowired
	private HouseDao housedao;
	public List<Build> queryHouseId() {
		return housedao.queryHouseid();
	}
	@Override
	public Build queryBuild(int buildId) {	
		return housedao.queryBuild(buildId);
	}
	@Override
	public int addHouse(House h) {
		return housedao.add(h);
	}
	@Override
	public House checkhouse(String hid, int bid) {
		return (House) housedao.checkHo(hid, bid);
	}
	@Override
	public List<House> queryHouse(int i) {	
		return housedao.queryAllHouse(i);
	}
	@Override
	public List<House> queryHouse1() {
		return housedao.queryAllHouse1();
	}
	@Override
	public int getMax() {
		return housedao.getmax();
	}
	@Override
	public House queryHouseById(String hid) {
		return (House) housedao.queryh(hid);
	}
	@Override
	public House queryHouseById(int hid) {
		return (House) housedao.queryh1(hid);
	}
}
