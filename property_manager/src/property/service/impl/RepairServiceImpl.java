package property.service.impl;





import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import property.dao.RepairDao;
import property.entity.Repair;
import property.entity.Repairman;
import property.entity.Repairrecord;
import property.service.RepairService;

@Service
public class RepairServiceImpl implements RepairService {
	@Autowired
	private RepairDao<Repair> repairdao;

	public int addRepair(Repair r) {
		return repairdao.add(r);

	}
	
	public List<Repair> query(int userid,int page){
		return repairdao.query(userid,page);
	}

	@Override
	public List<Repair> queryAll(int i) {	
		return repairdao.queryA(i);
	}

	@Override
	public List<Repair> queryByStatus(int i) {
		return repairdao.queryByStatus(i);
	}

	@Override
	public Repair queryByRepairId(String repairId) {
		return repairdao.queryByRepairId(repairId);
	}

	@Override
	public List<Repairman> queryman() {
		return repairdao.queryman();
	}

	@Override
	public Repairman queryByName(String name) {
		return repairdao.queryByName(name);
	}

	@Override
	public List<Repairrecord> queryRecord(int i) {
		return repairdao.queryRecord(i);
	}

	@Override
	public Repairrecord queryRecordById(String id) {
		return repairdao.queryRecordById(id);
	}

	@Override
	public int getMax() {
		return repairdao.getmax();
	}

	@Override
	public int getMax1() {
		return repairdao.getmax1();
	}

	@Override
	public int getMax2() {
		return repairdao.getmax2();
	}

	@Override
	public int getMax3(int i) {
		return repairdao.getmax3(i);
	}

	@Override
	public void deleteR(int i) {
		repairdao.deleteR(i);
	}



}
