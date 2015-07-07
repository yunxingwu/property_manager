package property.entity;

/**
 * Charge entity. @author MyEclipse Persistence Tools
 */

public class Charge implements java.io.Serializable {

	// Fields

	private Integer id;
	private Userinfo userinfo;
	private String month;
	private Float water;
	private Float electric;
	private Float gas;
	private Float rwater;
	private Float relectric;
	private Float rgas;
	private Float propertyfee;
	private Float total;
	private String cname;
	private String status;
	private String cdate;

	// Constructors

	/** default constructor */
	public Charge() {
	}

	/** minimal constructor */
	public Charge(Userinfo userinfo, String month) {
		this.userinfo = userinfo;
		this.month = month;
	}

	/** full constructor */
	public Charge(Userinfo userinfo, String month, Float water, Float electric,
			Float gas, Float rwater, Float relectric, Float rgas,
			Float propertyfee, Float total, String cname, String status,
			String cdate) {
		this.userinfo = userinfo;
		this.month = month;
		this.water = water;
		this.electric = electric;
		this.gas = gas;
		this.rwater = rwater;
		this.relectric = relectric;
		this.rgas = rgas;
		this.propertyfee = propertyfee;
		this.total = total;
		this.cname = cname;
		this.status = status;
		this.cdate = cdate;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Userinfo getUserinfo() {
		return this.userinfo;
	}

	public void setUserinfo(Userinfo userinfo) {
		this.userinfo = userinfo;
	}

	public String getMonth() {
		return this.month;
	}

	public void setMonth(String month) {
		this.month = month;
	}

	public Float getWater() {
		return this.water;
	}

	public void setWater(Float water) {
		this.water = water;
	}

	public Float getElectric() {
		return this.electric;
	}

	public void setElectric(Float electric) {
		this.electric = electric;
	}

	public Float getGas() {
		return this.gas;
	}

	public void setGas(Float gas) {
		this.gas = gas;
	}

	public Float getRwater() {
		return this.rwater;
	}

	public void setRwater(Float rwater) {
		this.rwater = rwater;
	}

	public Float getRelectric() {
		return this.relectric;
	}

	public void setRelectric(Float relectric) {
		this.relectric = relectric;
	}

	public Float getRgas() {
		return this.rgas;
	}

	public void setRgas(Float rgas) {
		this.rgas = rgas;
	}

	public Float getPropertyfee() {
		return this.propertyfee;
	}

	public void setPropertyfee(Float propertyfee) {
		this.propertyfee = propertyfee;
	}

	public Float getTotal() {
		return this.total;
	}

	public void setTotal(Float total) {
		this.total = total;
	}

	public String getCname() {
		return this.cname;
	}

	public void setCname(String cname) {
		this.cname = cname;
	}

	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getCdate() {
		return this.cdate;
	}

	public void setCdate(String cdate) {
		this.cdate = cdate;
	}

}