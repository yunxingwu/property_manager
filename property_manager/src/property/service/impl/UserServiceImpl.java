package property.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import property.dao.UserDao;
import property.entity.Manager;
import property.entity.Notice;
import property.entity.Userinfo;
import property.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDao<Manager> Mlogindao;
	@Autowired
	private UserDao<Userinfo> Userdao;
	@Autowired
	private UserDao<Notice> noticedao;

	public Manager checkLogin(String username, String password) {
		return Mlogindao.Mlogin(username, password);
	}

	@Override
	public Userinfo checkULogin(String name, String password) {
		// TODO Auto-generated method stub
		System.out.println("11111");
		System.out.println(name);
		System.out.println(password);
		return Userdao.Ulogin(name, password);
	}

	@Override
	public int addNotice(Notice n) {
		// TODO Auto-generated method stub
		return noticedao.add(n);
	}

	@Override
	public List<Notice> queryN() {
		// TODO Auto-generated method stub
		return noticedao.queryNotice();
	}

	@Override
	public List<Notice> queryN1() {
		return noticedao.queryNotice1();
	}

	@Override
	public List<Notice> queryN2() {
		return noticedao.queryNotice2();
	}

	@Override
	public List<Notice> queryN3() {
		return noticedao.queryNotice3();
	}

	@Override
	public List<Notice> queryNoti(int i) {
		return noticedao.queryNoti(i);
	}

	@Override
	public void deleteNotice(int id) {
		 noticedao.delete(id);	
	}

	@Override
	public int getMax() {
		 return noticedao.getmax();
	}

	@Override
	public Notice queryById(int id) {
		return noticedao.queryById(id);
	}

}
