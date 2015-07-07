package property.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import property.dao.RepairDao;
import property.entity.Notice;
import property.entity.Repair;
import property.entity.Repairman;
import property.entity.Repairrecord;
import property.entity.Userinfo;

@Repository
public class RepairDaoImpl extends BaseDaoImpl<Repair> implements RepairDao<Repair> {

	@Override
	public List<Repair> query(int id,int page) {
		List<Repair> repair = null;
		int num = 6;
		String sql = "select * from repair where userId = ? limit "+(page-1)*6+","+num;
		Query q = this.getSession().createSQLQuery(sql).addEntity(Repair.class);
		q.setInteger(0, id);
		repair = q.list();
		return repair;
	}

	@Override
	public List<Repair> queryA(int pagenum) {
		int num = 7;
		List<Repair> repair = null;
		String sql = "select * from repair limit "+(pagenum-1)*7+","+num;
		Query q = this.getSession().createSQLQuery(sql).addEntity(Repair.class);
		repair = q.list();
		return repair;
	}

	@Override
	public List<Repair> queryByStatus(int pagenum) {
		List<Repair> repair = null;
		int num = 7;
		String sql = "select * from repair where repairStatus = '未受理' limit "+(pagenum-1)*7+","+num;
		Query q = this.getSession().createSQLQuery(sql).addEntity(Repair.class);
		repair = q.list();
		return repair;
	}

	@Override
	public Repair queryByRepairId(String id) {
		String sql = "select * from repair where repairId = ?";
		Query query = this.getSession().createSQLQuery(sql).addEntity(Repair.class);
		query.setString(0, id);
		List<Repair> lisUser = query.list();
		if (lisUser.size() != 0) {
			return lisUser.get(0);
		} else {
			return null;
		}
	}

	@Override
	public List<Repairman> queryman() {
		List<Repairman> repairman = null;
		String sql = "select * from repairman";
		Query q = this.getSession().createSQLQuery(sql).addEntity(Repairman.class);
		repairman = q.list();
		return repairman;
	}

	@Override
	public Repairman queryByName(String name) {
		String sql = "select * from repairman where repairMan = ?";
		Query query = this.getSession().createSQLQuery(sql).addEntity(Repairman.class);
		query.setString(0, name);
		List<Repairman> Repairman = query.list();
		if (Repairman.size() != 0) {
			return Repairman.get(0);
		} else {
			return null;
		}
	}

	@Override
	public List<Repairrecord> queryRecord(int pagenum) {
		List<Repairrecord> repairrecord = null;
		int num = 7;
		String sql = "select * from repairrecord limit "+(pagenum-1)*7+","+num;
		Query q = this.getSession().createSQLQuery(sql).addEntity(Repairrecord.class);
		repairrecord = q.list();
		return repairrecord;
	}

	@Override
	public Repairrecord queryRecordById(String id) {
		String sql = "select * from repairrecord where repairRecord = ?";
		Query query = this.getSession().createSQLQuery(sql).addEntity(Repairrecord.class);
		query.setString(0, id);
		List<Repairrecord> lisUser = query.list();
		if (lisUser.size() != 0) {
			return lisUser.get(0);
		} else {
			return null;
		}
	}

	@Override
	public int getmax() {
		List<Repair> repair = null;
		String sql = "select * from repair";
		Query q = this.getSession().createSQLQuery(sql).addEntity(Repair.class);
		repair = q.list();
		return repair.size();
	}

	@Override
	public int getmax1() {
		List<Repair> repair = null;
		String sql = "select * from repair where repairStatus = '未受理'";
		Query q = this.getSession().createSQLQuery(sql).addEntity(Repair.class);
		repair = q.list();
		return repair.size();
	}

	@Override
	public int getmax2() {
		List<Repairrecord> repair = null;
		String sql = "select * from repairrecord";
		Query q = this.getSession().createSQLQuery(sql).addEntity(Repairrecord.class);
		repair = q.list();
		return repair.size();
	}

	@Override
	public int getmax3(int id) {
		List<Repair> repair = null;
		String sql = "select * from repair where repair.userId = ?";
		Query q = this.getSession().createSQLQuery(sql).addEntity(Repair.class);
		q.setInteger(0, id);
		repair = q.list();
		return repair.size();
	}

	@Override
	public void deleteR(int i) {
		String hql = "from Repair n where n.id=?";
		Query query =  this.getSession().createQuery(hql);
		query.setInteger(0, i);
		Repair repair = (Repair) query.list().get(0);
		this.getHibernateTemplate().delete(repair);
		System.out.println("执行到这里");
		
	}			
}
