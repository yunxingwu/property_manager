package property.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import property.dao.UserDao;
import property.entity.*;

@Repository
public class UserDaoImpl<T> extends BaseDaoImpl<T> implements UserDao<T> {

	// 管理员登陆
	public Manager Mlogin(String username, String password) {
		String hql = "select m from Manager m where m.managerId = ? and m.password = ?";
		Query query = this.getSession().createQuery(hql);
		query.setString(0, username);
		query.setString(1, password);
		List<Manager> lisUser = query.list();
		if (lisUser.size() != 0) {
			return lisUser.get(0);
		} else {
			return null;
		}
	}

	//用户登陆
	public Userinfo Ulogin(String name, String password) {
		String hql = "select u from Userinfo u where u.userId = ? and u.password = ?";
		Query query = this.getSession().createQuery(hql);
		query.setString(0, name);
		query.setString(1, password);
		List<Userinfo> lisUser = query.list();
		if (lisUser.size() != 0) {
			return lisUser.get(0);
		} else {
			return null;
		}

	}

	public void save(Manager manager) {
		getSession().save(manager);
	}

	//新增用户
	public void save(Userinfo user) {
		getSession().save(user);
	}

    //公告列表
	@Override
	public List<Notice> queryNotice() {
		List<Notice> notice = null;
		String sql = "select * from notice where type = '最新动态' order by id desc limit 0,5";
		Query q = this.getSession().createSQLQuery(sql).addEntity(Notice.class);
		notice = q.list();
		return notice;
	}

	//用户列表
	@Override
	public List<Userinfo> queryUser(int pagenum) {
		List<Userinfo> userinfo = null;
		int num = 8;
		String sql = "select * from userinfo limit "+(pagenum-1)*8+","+num;
		Query q = this.getSession().createSQLQuery(sql).addEntity(Userinfo.class);
		userinfo = q.list();
		return userinfo;
	}

	@Override
	public List<Notice> queryNotice1() {
		List<Notice> notice = null;
		String sql = "select * from notice where type = '时事热点' order by id desc limit 0,5";
		Query q = this.getSession().createSQLQuery(sql).addEntity(Notice.class);
		notice = q.list();
		return notice;
	}

	@Override
	public List<Notice> queryNotice2() {
		List<Notice> notice = null;
		String sql = "select * from notice where type = '便民信息' order by id desc limit 0,5";
		Query q = this.getSession().createSQLQuery(sql).addEntity(Notice.class);
		notice = q.list();
		return notice;
	}

	@Override
	public List<Notice> queryNotice3() {
		List<Notice> notice = null;
		String sql = "select * from notice where type = '生活健康' order by id desc limit 0,5";
		Query q = this.getSession().createSQLQuery(sql).addEntity(Notice.class);
		notice = q.list();
		return notice;
	}

	@Override
	public List<Notice> queryNoti(int pagenum) {
		int num = 8;
		List<Notice> notice = null;
		System.out.println("dfdfd");
		String sql = "select * from notice limit "+(pagenum-1)*8+","+num;
		System.out.println(sql);
		Query q = this.getSession().createSQLQuery(sql).addEntity(Notice.class);
		notice = q.list();
		return notice;
	}

	@Override
	public List<Userinfo> queryByname(String name) {
		String hql = "select u from Userinfo u where u.userName = ? ";
		Query query = this.getSession().createQuery(hql);
		query.setString(0, name);
		List<Userinfo> lisUser = query.list();
	    return lisUser;
	}

	@Override
	public int getmax() {
		String sql = "select * from notice";
		Query query = this.getSession().createSQLQuery(sql).addEntity(Notice.class);
		List<Notice> notice = query.list();
	    return notice.size();
	}

	@Override
	public Renttype queryRent(int id) {
		String hql = "select r from Renttype r where r.id = ?";
		Query query = this.getSession().createQuery(hql);
		query.setInteger(0, id);
		List<Renttype> lisUser = query.list();
		if (lisUser.size() != 0) {
			return lisUser.get(0);
		} else {
			return null;
		}
	}

	@Override
	public int getMax() {
		String sql = "select * from userinfo";
		Query query = this.getSession().createSQLQuery(sql).addEntity(Userinfo.class);
		List<Userinfo> user = query.list();
	    return user.size();
	}

	@Override
	public Notice queryById(int id) {
		String hql = "select r from Notice r where r.id = ?";
		Query query = this.getSession().createQuery(hql);
		query.setInteger(0, id);
		List<Notice> lisUser = query.list();
		if (lisUser.size() != 0) {
			return lisUser.get(0);
		} else {
			return null;
		}
	}

	@Override
	public Userinfo queryUserById(int id) {
		String hql = "select r from Userinfo r where r.id = ?";
		Query query = this.getSession().createQuery(hql);
		query.setInteger(0, id);
		List<Userinfo> lisUser = query.list();
		if (lisUser.size() != 0) {
			return lisUser.get(0);
		} else {
			return null;
		}
	}

}
