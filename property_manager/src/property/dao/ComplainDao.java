package property.dao;

import java.util.List;

public interface ComplainDao<Complain> extends BaseDao<Complain> {

	public List<Complain> query(int id,int page);
	public List<Complain> queryA(int i);
	public void deletecom(int id);
	public int getmax();
	public int getmax1(int id);
}
