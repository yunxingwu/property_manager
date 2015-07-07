package property.entity;

/**
 * Electric entity. @author MyEclipse Persistence Tools
 */

public class Electric implements java.io.Serializable {

	// Fields

	private Integer id;
	private Userinfo userinfo;
	private Float electric;
	private String month;

	// Constructors

	/** default constructor */
	public Electric() {
	}

	/** full constructor */
	public Electric(Userinfo userinfo, Float electric, String month) {
		this.userinfo = userinfo;
		this.electric = electric;
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

	public Float getElectric() {
		return this.electric;
	}

	public void setElectric(Float electric) {
		this.electric = electric;
	}

	public String getMonth() {
		return this.month;
	}

	public void setMonth(String month) {
		this.month = month;
	}

}