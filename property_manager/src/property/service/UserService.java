package property.service;

import java.util.List;

import property.entity.Manager;
import property.entity.Notice;
import property.entity.Userinfo;

public interface UserService {

	public Manager checkLogin(String username, String password);

	public Userinfo checkULogin(String name, String password);
	
	public int addNotice(Notice n);
	
	public List<Notice> queryNoti(int i);
	public List<Notice> queryN();
	public List<Notice> queryN1();
	public List<Notice> queryN2();
	public List<Notice> queryN3();
	public void deleteNotice(int id);
	public int getMax();
	public Notice queryById(int id);
	
}
