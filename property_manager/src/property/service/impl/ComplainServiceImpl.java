package property.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import property.dao.ComplainDao;
import property.entity.Complain;
import property.service.ComplainService;

@Service
public class ComplainServiceImpl implements ComplainService {

	@Autowired
	private ComplainDao<Complain> complaindao;
	@Override
	public int addComplain(Complain complain) {
		// TODO Auto-generated method stub
		return complaindao.add(complain);
	}
	@Override
	public List<Complain> query(int id,int page) {
		// TODO Auto-generated method stub
		return complaindao.query(id,page);
	}
	@Override
	public List<Complain> queryAll(int i) {	
		return complaindao.queryA(i);
	}
	@Override
	public void deleteC(int id) {
		complaindao.deletecom(id);	
	}
	@Override
	public int getMax() {
		return complaindao.getmax();
	}
	@Override
	public int getMax1(int id) {
		return complaindao.getmax1(id);
	}

}
