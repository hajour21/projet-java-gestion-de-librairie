package addition;

public class User {
private String login ;
private String password ;
private String fname;
private String lname;
private String gendre;
private String grade;
private String address;
private String email;
private int telephone ;
public String getLogin() {
	return login;
}

public void setLogin(String login) {
	this.login = login;
}
public String getPassword() {
	return password;
}
public void setPassword(String password) {
	this.password = password;
}
public String getFname() {
	return fname;
}

public void setFname(String fname) {
	this.fname = fname;
}
public String getLname() {
	return lname;
}
public void setLname(String lname) {
	this.lname = lname;
}
public String getGendre() {
	return gendre;
}
public void setGendre(String gendre) {
	this.gendre = gendre;
}
public String getGrade() {
	return grade;
}
public void setGrade(String grade) {
	this.grade = grade;
}
public String getAddress() {
	return address;
}
public void setAddress(String address) {
	this.address = address;
}
public String getEmail() {
	return email;
}
public void setEmail(String email) {
	this.email = email;
}
public int getTelephone() {
	return telephone;
}
public void setTelephone(int telephone) {
	this.telephone = telephone;
} 
public User() {}
public User( String login , String password , String fname, String lname, String gendre , String grade ,String address , String email , int telephone )
{
this.login = login;
this.password = password ;
this.fname = fname;
this.lname = lname;
this.gendre = gendre; 
this.grade = grade;
this.email = email ; 
this.telephone = telephone;
}
}
