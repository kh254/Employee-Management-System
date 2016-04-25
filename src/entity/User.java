package entity;
/**
 * entity
 * @author kun
 *
 */
public class User {
	private int id;
	private String userName;
	private String pwd;
	private String name;
	private String gender;
	
	

	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getUserName() {
		return userName;
	}


	public void setUserName(String userName) {
		this.userName = userName;
	}


	public String getPwd() {
		return pwd;
	}


	public void setPwd(String pwd) {
		this.pwd = pwd;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getGender() {
		return gender;
	}


	public void setGender(String gender) {
		this.gender = gender;
	}


	public User() {
		super();
	}

	public User(int id, String userName, String pwd, String name, String gender) {
		super();
		this.id = id;
		this.userName = userName;
		this.pwd = pwd;
		this.name = name;
		this.gender = gender;
	}


	@Override
	public String toString() {
		return this.id + " " + this.userName + " " + this.pwd + " " + this.name + " " + this.gender;
	}
}
