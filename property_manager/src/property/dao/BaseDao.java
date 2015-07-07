package property.dao;

import property.entity.Charge;
import property.entity.Electric;
import property.entity.Gas;
import property.entity.Water;



public interface BaseDao<T> {
	public int add(T t);

	public void delete(int id);

	public void update(T t);
	
	public void update1(T t);

	public void save(T t);
	
	public double renttypew();
	
	public double renttypee();
	
	public double renttypeg();
	
	public double renttypep();
	
	public Charge judge(int userid,String date);
	
	public Water judgeWater(int userid,String date);
	
	public Electric judgeElectric(int userid,String date);
	
	public Gas judgeGas(int userid,String date);
	
    public void dele(T t);
    
    public void dele1(int id);
    
    public void dele2(int id);

}
