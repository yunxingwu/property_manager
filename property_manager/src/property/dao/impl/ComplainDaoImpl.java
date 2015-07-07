package property.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import property.dao.ComplainDao;
import property.entity.Charge;
import property.entity.Complain;
import property.entity.Notice;
import property.entity.Repair;

@Repository
public class ComplainDaoImpl extends BaseDaoImpl<Complain> implements ComplainDao<Complain> {

	@Override
	public List<Complain> query(int id,int page) {
		List<Complain> complain = null;
		int num = 6;
		String sql = "select * from complain where userId = ? limit "+(page-1)*6+","+num;
		Query q = this.getSession().createSQLQuery(sql).addEntity(Complain.class);
		q.setInteger(0, id);
		complain = q.list();
		return complain;
	}

	@Override
	public List<Complain> queryA(int pagenum) {
		List<Complain> complain = null;
		int num = 8;
		String sql = "select * from complain limit "+(pagenum-1)*8+","+num;
		Query q = this.getSession().createSQLQuery(sql).addEntity(Complain.class);
		complain = q.list();
		return complain;
	}

	@Override
	public void deletecom(int id) {
		String hql = "from Complain c where c.id=?";
		Query query =  this.getSession().createQuery(hql);
		query.setInteger(0, id);
		Complain com = (Complain) query.list().get(0);
		this.getHibernateTemplate().delete(com);	
	}

	@Override
	public int getmax() {
		String sql = "select * from complain";
		Query q = this.getSession().createSQLQuery(sql).addEntity(Complain.class);
		List<Complain> c = q.list();
		return c.size();
	}

	@Override
	public int getmax1(int id) {
		String sql = "select * from complain where complain.userId = ?";
		Query q = this.getSession().createSQLQuery(sql).addEntity(Complain.class);
		q.setInteger(0, id);
		List<Complain> c = q.list();
		return c.size();
	}

}
