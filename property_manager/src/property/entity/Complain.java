package property.entity;

/**
 * Complain entity. @author MyEclipse Persistence Tools
 */

public class Complain implements java.io.Serializable {

	// Fields

	private Integer id;
	private Userinfo userinfo;
	private String complainId;
	private String complainContent;
	private String complainTime;

	// Constructors

	/** default constructor */
	public Complain() {
	}

	/** full constructor */
	public Complain(Userinfo userinfo, String complainId,
			String complainContent, String complainTime) {
		this.userinfo = userinfo;
		this.complainId = complainId;
		this.complainContent = complainContent;
		this.complainTime = complainTime;
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

	public String getComplainId() {
		return this.complainId;
	}

	public void setComplainId(String complainId) {
		this.complainId = complainId;
	}

	public String getComplainContent() {
		return this.complainContent;
	}

	public void setComplainContent(String complainContent) {
		this.complainContent = complainContent;
	}

	public String getComplainTime() {
		return this.complainTime;
	}

	public void setComplainTime(String complainTime) {
		this.complainTime = complainTime;
	}

}