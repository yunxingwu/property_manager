package property.entity;

/**
 * Repair entity. @author MyEclipse Persistence Tools
 */

public class Repair implements java.io.Serializable {

	// Fields

	private Integer id;
	private Userinfo userinfo;
	private String repairId;
	private String repairType;
	private String repairContent;
	private String repairTime;
	private String repairStatus;
	private String repairMan;
	private String declareTime;
	private String phone;
	private String result;

	// Constructors

	/** default constructor */
	public Repair() {
	}

	/** minimal constructor */
	public Repair(Userinfo userinfo, String repairId, String repairType,
			String repairContent, String repairTime, String repairStatus) {
		this.userinfo = userinfo;
		this.repairId = repairId;
		this.repairType = repairType;
		this.repairContent = repairContent;
		this.repairTime = repairTime;
		this.repairStatus = repairStatus;
	}

	/** full constructor */
	public Repair(Userinfo userinfo, String repairId, String repairType,
			String repairContent, String repairTime, String repairStatus,
			String repairMan, String declareTime, String phone, String result) {
		this.userinfo = userinfo;
		this.repairId = repairId;
		this.repairType = repairType;
		this.repairContent = repairContent;
		this.repairTime = repairTime;
		this.repairStatus = repairStatus;
		this.repairMan = repairMan;
		this.declareTime = declareTime;
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

	public Userinfo getUserinfo() {
		return this.userinfo;
	}

	public void setUserinfo(Userinfo userinfo) {
		this.userinfo = userinfo;
	}

	public String getRepairId() {
		return this.repairId;
	}

	public void setRepairId(String repairId) {
		this.repairId = repairId;
	}

	public String getRepairType() {
		return this.repairType;
	}

	public void setRepairType(String repairType) {
		this.repairType = repairType;
	}

	public String getRepairContent() {
		return this.repairContent;
	}

	public void setRepairContent(String repairContent) {
		this.repairContent = repairContent;
	}

	public String getRepairTime() {
		return this.repairTime;
	}

	public void setRepairTime(String repairTime) {
		this.repairTime = repairTime;
	}

	public String getRepairStatus() {
		return this.repairStatus;
	}

	public void setRepairStatus(String repairStatus) {
		this.repairStatus = repairStatus;
	}

	public String getRepairMan() {
		return this.repairMan;
	}

	public void setRepairMan(String repairMan) {
		this.repairMan = repairMan;
	}

	public String getDeclareTime() {
		return this.declareTime;
	}

	public void setDeclareTime(String declareTime) {
		this.declareTime = declareTime;
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