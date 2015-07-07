package property.entity;

/**
 * Water entity. @author MyEclipse Persistence Tools
 */

public class Water implements java.io.Serializable {

	// Fields

	private Integer id;
	private Userinfo userinfo;
	private Float water;
	private String month;

	// Constructors

	/** default constructor */
	public Water() {
	}

	/** full constructor */
	public Water(Userinfo userinfo, Float water, String month) {
		this.userinfo = userinfo;
		this.water = water;
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

	public Float getWater() {
		return this.water;
	}

	public void setWater(Float water) {
		this.water = water;
	}

	public String getMonth() {
		return this.month;
	}

	public void setMonth(String month) {
		this.month = month;
	}

}