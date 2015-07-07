package property.entity;

import java.util.HashSet;
import java.util.Set;

/**
 * Area entity. @author MyEclipse Persistence Tools
 */

public class Area implements java.io.Serializable {

	// Fields

	private Integer id;
	private String areaName;
	private String remark;
	private Set builds = new HashSet(0);

	// Constructors

	/** default constructor */
	public Area() {
	}

	/** minimal constructor */
	public Area(String areaName) {
		this.areaName = areaName;
	}

	/** full constructor */
	public Area(String areaName, String remark, Set builds) {
		this.areaName = areaName;
		this.remark = remark;
		this.builds = builds;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getAreaName() {
		return this.areaName;
	}

	public void setAreaName(String areaName) {
		this.areaName = areaName;
	}

	public String getRemark() {
		return this.remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public Set getBuilds() {
		return this.builds;
	}

	public void setBuilds(Set builds) {
		this.builds = builds;
	}

}