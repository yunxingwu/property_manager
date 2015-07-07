package property.vo;

public class ChargeInfo {
	private String date;      //年月
	private float water;     //用水量
	private float electric;  //用电量
	private float gas;       //燃气量
	private float wrent;     //水费
	private float erent;     //电费
	private float grent;     //燃气费
	private float prent;     //物业管理费
	private float total;     //费用总计
	private String state;     //缴纳状态
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public float getWater() {
		return water;
	}
	public void setWater(float water) {
		this.water = water;
	}
	public float getElectric() {
		return electric;
	}
	public void setElectric(float electric) {
		this.electric = electric;
	}
	public float getGas() {
		return gas;
	}
	public void setGas(float gas) {
		this.gas = gas;
	}
	public float getWrent() {
		return wrent;
	}
	public void setWrent(float wrent) {
		this.wrent = wrent;
	}
	public float getErent() {
		return erent;
	}
	public void setErent(float erent) {
		this.erent = erent;
	}
	public float getGrent() {
		return grent;
	}
	public void setGrent(float grent) {
		this.grent = grent;
	}
	public float getPrent() {
		return prent;
	}
	public void setPrent(float prent) {
		this.prent = prent;
	}
	public float getTotal() {
		return total;
	}
	public void setTotal(float total) {
		this.total = total;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	 
	

}
