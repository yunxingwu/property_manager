package property.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import property.dao.ChargeDao;
import property.entity.Build;
import property.entity.Charge;
import property.entity.Electric;
import property.entity.Gas;
import property.entity.House;
import property.entity.Renttype;
import property.entity.Userinfo;
import property.entity.Water;
import property.service.ChargeService;

@Service
public class ChargeServiceImpl implements ChargeService {

	@Autowired
	private ChargeDao chargedao;
	@Override
	public List<Build> queryHouseId() {
		return chargedao.queryHouseid();
	}
	@Override
	public List<House> queryHouseList(int buildId) {     
		return chargedao.queryHoustList(buildId);
	}
	@Override
	public Userinfo queryUserId(String houseId) {
		return chargedao.queryUserId(houseId);
	}
	@Override
	public int addWater(Water w) {	
		return chargedao.add(w);
	}
	@Override
	public int addElectric(Electric e) {
		return chargedao.add(e);
	}
	@Override
	public int addGas(Gas g) {
		return chargedao.add(g);
	}
	@Override
	public int addProper() {
		return 0;
	}
	@Override
	public List<Charge> queryCharge(int id,int page) {
		return chargedao.queryCharge(id,page);
	}
	@Override
	public List<Charge> queryCharge1(int id, String date) {
		return chargedao.queryCharge1(id, date);
	}
	@Override
	public List<Renttype> queryRentList() {
		return chargedao.queryRent();
	}
	@Override
	public List<Charge> queryAllCharge(int i) {	
		return chargedao.queryAll(i);
	}
	@Override
	public List<Charge> queryCharge2(int i,String date) {
		return chargedao.queryCharge2(i,date);
	}
	@Override
	public Charge queryByUserId(int id,String date) {
		return chargedao.queryByUserId(id,date);
	}
	@Override
	public Charge queryById(int id) {
		return chargedao.queryById(id);
	}
	@Override
	public int getMax() {
		return chargedao.getMaxcount();
	}
	@Override
	public int getMax1(String date) {
		return chargedao.getMaxcount1(date);
	}
	@Override
	public int getMax2(int id) {
		return chargedao.getMax2(id);
	}

}
