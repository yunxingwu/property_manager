package property.entity;

import java.util.HashSet;
import java.util.Set;

/**
 * Power entity. @author MyEclipse Persistence Tools
 */

public class Power implements java.io.Serializable {

	// Fields

	private Integer powerId;
	private String powerType;
	private Set managers = new HashSet(0);

	// Constructors

	/** default constructor */
	public Power() {
	}

	/** minimal constructor */
	public Power(String powerType) {
		this.powerType = powerType;
	}

	/** full constructor */
	public Power(String powerType, Set managers) {
		this.powerType = powerType;
		this.managers = managers;
	}

	// Property accessors

	public Integer getPowerId() {
		return this.powerId;
	}

	public void setPowerId(Integer powerId) {
		this.powerId = powerId;
	}

	public String getPowerType() {
		return this.powerType;
	}

	public void setPowerType(String powerType) {
		this.powerType = powerType;
	}

	public Set getManagers() {
		return this.managers;
	}

	public void setManagers(Set managers) {
		this.managers = managers;
	}

}