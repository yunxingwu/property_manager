package property.dao.impl;



import java.util.List;

import javax.annotation.Resource;


import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;
import property.dao.BaseDao;
import property.entity.Charge;
import property.entity.Electric;
import property.entity.Gas;
import property.entity.Notice;
import property.entity.Userinfo;
import property.entity.Water;


//设置Dao类sessionFactory
@Repository
public class BaseDaoImpl<T> extends HibernateDaoSupport implements BaseDao<T> {
	@Resource(name = "sessionFactory")
	public void setSF(SessionFactory sessionFactory) {
		super.setSessionFactory(sessionFactory);
	}

	@Override
	public int add(T t) {
		return (Integer) getSession().save(t);
	}

	@Override
	public void delete(int id) {
		String hql = "from Notice n where n.id=?";
		Query query =  this.getSession().createQuery(hql);
		query.setInteger(0, id);
		Notice noti = (Notice) query.list().get(0);
		this.getHibernateTemplate().delete(noti);
		System.out.println("执行到这里");
	}

	@Override
	public void update(T t) {
		this.getHibernateTemplate().update(t);
	}

	@Override
	public void save(T t) {
		// TODO Auto-generated method stub

	}

	@Override
	public double renttypew() {
		String sql = "select price from renttype where rentName = '水费'";
		Object o = this.getSession().createSQLQuery(sql).uniqueResult();
		double price = (Double)o;
		return price;
	}

	@Override
	public double renttypee() {
		String sql = "select price from renttype where rentName = '电费'";
		Object o = this.getSession().createSQLQuery(sql).uniqueResult();
		double price = (Double)o;
		return price;
	}

	@Override
	public double renttypeg() {
		String sql = "select price from renttype where rentName = '燃气费'";
		Object o = this.getSession().createSQLQuery(sql).uniqueResult();
		double price = (Double)o;
		return price;
	}

	@Override
	public Charge judge(int userid, String date) {
		String sql = "select * from charge where charge.userId = ? and  charge.`month`=?";
		Query q = this.getSession().createSQLQuery(sql).addEntity(Charge.class);
		q.setInteger(0, userid);
		q.setString(1, date);
		List<Charge> lisUser = q.list();
		if (lisUser.size() != 0) {
			return lisUser.get(0);
		} else {
			return null;
		}
	}

	@Override
	public double renttypep() {
		String sql = "select price from renttype where rentName = '物业管理费'";
		Object o = this.getSession().createSQLQuery(sql).uniqueResult();
		double price = (Double)o;
		return price;
	}

	@Override
	public void update1(T t) {
		this.getHibernateTemplate().update(this.getHibernateTemplate().merge(t));	
	}

	@Override
	public Water judgeWater(int userid, String date) {
		String sql = "select * from water where water.userId = ? and  water.`month`=?";
		Query q = this.getSession().createSQLQuery(sql).addEntity(Water.class);
		q.setInteger(0, userid);
		q.setString(1, date);
		List<Water> lisUser = q.list();
		if (lisUser.size() != 0) {
			return lisUser.get(0);
		} else {
			return null;
		}
	}

	@Override
	public Electric judgeElectric(int userid, String date) {
		String sql = "select * from electric where electric.userId = ? and  electric.`month`=?";
		Query q = this.getSession().createSQLQuery(sql).addEntity(Electric.class);
		q.setInteger(0, userid);
		q.setString(1, date);
		List<Electric> lisUser = q.list();
		if (lisUser.size() != 0) {
			return lisUser.get(0);
		} else {
			return null;
		}
	}

	@Override
	public Gas judgeGas(int userid, String date) {
		String sql = "select * from gas where gas.userId = ? and  gas.`month`=?";
		Query q = this.getSession().createSQLQuery(sql).addEntity(Gas.class);
		q.setInteger(0, userid);
		q.setString(1, date);
		List<Gas> lisUser = q.list();
		if (lisUser.size() != 0) {
			return lisUser.get(0);
		} else {
			return null;
		}
	}

	@Override
	public void dele(T t) {
		this.getHibernateTemplate().delete(t);
		System.out.println("执行删除");
	}

	@Override
	public void dele1(int id) {
		String hql = "delete Userinfo u where u.id = ?";
		Query q =  this.getSession().createQuery(hql);
		q.setInteger(0, id);
		q.executeUpdate();	
		System.out.println("执行删除");
	}

	@Override
	public void dele2(int id) {
		String hql = "delete House u where u.id = ?";
		Query q =  this.getSession().createQuery(hql);
		q.setInteger(0, id);
		q.executeUpdate();	
		System.out.println("执行删除");
		
	}

}
