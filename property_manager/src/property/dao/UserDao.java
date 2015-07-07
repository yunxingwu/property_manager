package property.dao;

import java.util.List;

import property.entity.Manager;
import property.entity.Notice;
import property.entity.Renttype;
import property.entity.Userinfo;

public interface UserDao<T> extends BaseDao<T> {
	public Manager Mlogin(String username, String password);

	public Userinfo Ulogin(String name, String password);
	
	public List<Notice> queryNoti(int i);
	
    public List<Notice> queryNotice();
    
    public List<Notice> queryNotice1();
    
    public List<Notice> queryNotice2();
    
    public List<Notice> queryNotice3();
    
    public List<Userinfo> queryUser(int i);
    
    public List<Userinfo> queryByname(String name);
    
    public int getmax();
    
    public Renttype queryRent(int id);
    
    public int getMax();
    
    public Notice queryById(int id);
    
    public Userinfo queryUserById(int id);
}
