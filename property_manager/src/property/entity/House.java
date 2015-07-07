package property.entity;

/**
 * House entity. @author MyEclipse Persistence Tools
 */

public class House implements java.io.Serializable {

	// Fields

	private Integer id;
	private Build build;
	private String houseId;
	private String houseType;
	private String areas;
	private String remark;
	private String status;

	// Constructors

	/** default constructor */
	public House() {
	}

	/** minimal constructor */
	public House(Build build, String houseId, String houseType, String areas,
			String status) {
		this.build = build;
		this.houseId = houseId;
		this.houseType = houseType;
		this.areas = areas;
		this.status = status;
	}

	/** full constructor */
	public House(Build build, String houseId, String houseType, String areas,
			String remark, String status) {
		this.build = build;
		this.houseId = houseId;
		this.houseType = houseType;
		this.areas = areas;
		this.remark = remark;
		this.status = status;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Build getBuild() {
		return this.build;
	}

	public void setBuild(Build build) {
		this.build = build;
	}

	public String getHouseId() {
		return this.houseId;
	}

	public void setHouseId(String houseId) {
		this.houseId = houseId;
	}

	public String getHouseType() {
		return this.houseType;
	}

	public void setHouseType(String houseType) {
		this.houseType = houseType;
	}

	public String getAreas() {
		return this.areas;
	}

	public void setAreas(String areas) {
		this.areas = areas;
	}

	public String getRemark() {
		return this.remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

}