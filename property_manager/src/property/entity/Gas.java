package property.entity;

/**
 * Gas entity. @author MyEclipse Persistence Tools
 */

public class Gas implements java.io.Serializable {

	// Fields

	private Integer id;
	private Userinfo userinfo;
	private Float gas;
	private String month;

	// Constructors

	/** default constructor */
	public Gas() {
	}

	/** full constructor */
	public Gas(Userinfo userinfo, Float gas, String month) {
		this.userinfo = userinfo;
		this.gas = gas;
		this.month = month;
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

	public Float getGas() {
		return this.gas;
	}

	public void setGas(Float gas) {
		this.gas = gas;
	}

	public String getMonth() {
		return this.month;
	}

	public void setMonth(String month) {
		this.month = month;
	}

}