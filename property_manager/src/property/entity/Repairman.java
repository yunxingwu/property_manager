package property.entity;

/**
 * Repairman entity. @author MyEclipse Persistence Tools
 */

public class Repairman implements java.io.Serializable {

	// Fields

	private Integer id;
	private String repairMan;
	private String phone;

	// Constructors

	/** default constructor */
	public Repairman() {
	}

	/** full constructor */
	public Repairman(String repairMan, String phone) {
		this.repairMan = repairMan;
		this.phone = phone;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getRepairMan() {
		return this.repairMan;
	}

	public void setRepairMan(String repairMan) {
		this.repairMan = repairMan;
	}

	public String getPhone() {
		return this.phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

}