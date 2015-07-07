package property.service;

import java.util.List;

import property.entity.Complain;


public interface ComplainService {

	public int addComplain(Complain complain);
	public List<Complain> query(int id,int page);
	public List<Complain> queryAll(int i);
	public void deleteC(int id);
	public int getMax();
	public int getMax1(int id);
}
