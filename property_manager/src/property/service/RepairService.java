package property.service;

import java.util.List;

import property.entity.Repair;
import property.entity.Repairman;
import property.entity.Repairrecord;

public interface RepairService {

	public int addRepair(Repair r);
	public List<Repair> query(int id,int p);
	public List<Repair> queryAll(int i);
    public List<Repair> queryByStatus(int i);
    public Repair queryByRepairId(String repairId);
    public List<Repairman> queryman();
    public Repairman queryByName(String name);
    public List<Repairrecord> queryRecord(int i);
    public Repairrecord queryRecordById(String id);
    public int getMax();
    public int getMax1();
    public int getMax2();
    public int getMax3(int i);
    public void deleteR(int i);
}
