package property.entity;

/**
 * Repairrecord entity. @author MyEclipse Persistence Tools
 */

public class Repairrecord implements java.io.Serializable {

	// Fields

	private Integer id;
	private String repairRecord;
	private String repairMan;
	private String repairTime;
	private String phone;
	private String result;

	// Constructors

	/** default constructor */
	public Repairrecord() {
	}

	/** full constructor */
	public Repairrecord(String repairRecord, String repairMan,
			String repairTime, String phone, String result) {
		this.repairRecord = repairRecord;
		this.repairMan = repairMan;
		this.repairTime = repairTime;
		this.phone = phone;
		this.result = result;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getRepairRecord() {
		return this.repairRecord;
	}

	public void setRepairRecord(String repairRecord) {
		this.repairRecord = repairRecord;
	}

	public String getRepairMan() {
		return this.repairMan;
	}

	public void setRepairMan(String repairMan) {
		this.repairMan = repairMan;
	}

	public String getRepairTime() {
		return this.repairTime;
	}

	public void setRepairTime(String repairTime) {
		this.repairTime = repairTime;
	}

	public String getPhone() {
		return this.phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getResult() {
		return this.result;
	}

	public void setResult(String result) {
		this.result = result;
	}

}