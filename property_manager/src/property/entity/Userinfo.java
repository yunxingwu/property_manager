package property.entity;

import java.util.HashSet;
import java.util.Set;

/**
 * Userinfo entity. @author MyEclipse Persistence Tools
 */

public class Userinfo implements java.io.Serializable {

	// Fields

	private Integer id;
	private String houseId;
	private String userId;
	private String userName;
	private String password;
	private String sex;
	private String cardId;
	private String phone;
	private String address;
	private String unit;
	private String email;
	private Set gases = new HashSet(0);
	private Set charges = new HashSet(0);
	private Set repairs = new HashSet(0);
	private Set complains = new HashSet(0);
	private Set electrics = new HashSet(0);
	private Set waters = new HashSet(0);

	// Constructors

	/** default constructor */
	public Userinfo() {
	}

	/** minimal constructor */
	public Userinfo(String houseId, String userId, String userName,
			String password, String sex, String cardId) {
		this.houseId = houseId;
		this.userId = userId;
		this.userName = userName;
		this.password = password;
		this.sex = sex;
		this.cardId = cardId;
	}

	/** full constructor */
	public Userinfo(String houseId, String userId, String userName,
			String password, String sex, String cardId, String phone,
			String address, String unit, String email, Set gases, Set charges,
			Set repairs, Set complains, Set electrics, Set waters) {
		this.houseId = houseId;
		this.userId = userId;
		this.userName = userName;
		this.password = password;
		this.sex = sex;
		this.cardId = cardId;
		this.phone = phone;
		this.address = address;
		this.unit = unit;
		this.email = email;
		this.gases = gases;
		this.charges = charges;
		this.repairs = repairs;
		this.complains = complains;
		this.electrics = electrics;
		this.waters = waters;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getHouseId() {
		return this.houseId;
	}

	public void setHouseId(String houseId) {
		this.houseId = houseId;
	}

	public String getUserId() {
		return this.userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return this.userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getSex() {
		return this.sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getCardId() {
		return this.cardId;
	}

	public void setCardId(String cardId) {
		this.cardId = cardId;
	}

	public String getPhone() {
		return this.phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getAddress() {
		return this.address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getUnit() {
		return this.unit;
	}

	public void setUnit(String unit) {
		this.unit = unit;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Set getGases() {
		return this.gases;
	}

	public void setGases(Set gases) {
		this.gases = gases;
	}

	public Set getCharges() {
		return this.charges;
	}

	public void setCharges(Set charges) {
		this.charges = charges;
	}

	public Set getRepairs() {
		return this.repairs;
	}

	public void setRepairs(Set repairs) {
		this.repairs = repairs;
	}

	public Set getComplains() {
		return this.complains;
	}

	public void setComplains(Set complains) {
		this.complains = complains;
	}

	public Set getElectrics() {
		return this.electrics;
	}

	public void setElectrics(Set electrics) {
		this.electrics = electrics;
	}

	public Set getWaters() {
		return this.waters;
	}

	public void setWaters(Set waters) {
		this.waters = waters;
	}

}