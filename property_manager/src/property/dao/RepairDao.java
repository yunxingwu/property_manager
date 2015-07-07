package property.dao;

import java.util.List;

import property.entity.Repairman;
import property.entity.Repairrecord;

public interface RepairDao<Repair> extends BaseDao<Repair> {

	public List<Repair> query(int id,int p);
	public List<Repair> queryA(int i);
	public List<Repair> queryByStatus(int i);
	public Repair queryByRepairId(String id);
	public List<Repairman> queryman();
	public Repairman queryByName(String name);
	public List<Repairrecord> queryRecord(int i);
	public Repairrecord queryRecordById(String id);
	public int getmax();
	public int getmax1();
	public int getmax2();
	public int getmax3(int i);
	public void deleteR(int i);
}
