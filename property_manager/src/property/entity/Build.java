package property.entity;

import java.util.HashSet;
import java.util.Set;

/**
 * Build entity. @author MyEclipse Persistence Tools
 */

public class Build implements java.io.Serializable {

	// Fields

	private Integer buildId;
	private Area area;
	private String buildType;
	private String areas;
	private String date;
	private Set houses = new HashSet(0);

	// Constructors

	/** default constructor */
	public Build() {
	}

	/** minimal constructor */
	public Build(Area area, String buildType, String areas, String date) {
		this.area = area;
		this.buildType = buildType;
		this.areas = areas;
		this.date = date;
	}

	/** full constructor */
	public Build(Area area, String buildType, String areas, String date,
			Set houses) {
		this.area = area;
		this.buildType = buildType;
		this.areas = areas;
		this.date = date;
		this.houses = houses;
	}

	// Property accessors

	public Integer getBuildId() {
		return this.buildId;
	}

	public void setBuildId(Integer buildId) {
		this.buildId = buildId;
	}

	public Area getArea() {
		return this.area;
	}

	public void setArea(Area area) {
		this.area = area;
	}

	public String getBuildType() {
		return this.buildType;
	}

	public void setBuildType(String buildType) {
		this.buildType = buildType;
	}

	public String getAreas() {
		return this.areas;
	}

	public void setAreas(String areas) {
		this.areas = areas;
	}

	public String getDate() {
		return this.date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public Set getHouses() {
		return this.houses;
	}

	public void setHouses(Set houses) {
		this.houses = houses;
	}

}