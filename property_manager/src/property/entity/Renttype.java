package property.entity;

/**
 * Renttype entity. @author MyEclipse Persistence Tools
 */

public class Renttype implements java.io.Serializable {

	// Fields

	private Integer id;
	private String rentName;
	private Double price;

	// Constructors

	/** default constructor */
	public Renttype() {
	}

	/** full constructor */
	public Renttype(String rentName, Double price) {
		this.rentName = rentName;
		this.price = price;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getRentName() {
		return this.rentName;
	}

	public void setRentName(String rentName) {
		this.rentName = rentName;
	}

	public Double getPrice() {
		return this.price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

}