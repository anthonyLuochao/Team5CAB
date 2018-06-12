package sg.iss.team5cab.model;

import java.util.Date;
import java.util.List;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;
@Entity
@Table(name="users")
public class Users {
@Id
private String userID;	
@OneToMany(mappedBy="users")
private List<Booking> bookings;

private String name;
private String email;
private String address;
public boolean isDeleted() {
	return isDeleted;
}
public void setDeleted(boolean isDeleted) {
	this.isDeleted = isDeleted;
}
private String phoneNumber;
@DateTimeFormat(pattern="MM/dd/yyyy")
private Date dob; 
private String role;
private String password;
@Column(columnDefinition="TINYINT")
private boolean isDeleted;
public String getUserID() {
	return userID;
}
public void setUserID(String userID) {
	this.userID = userID;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getEmail() {
	return email;
}
public void setEmail(String email) {
	this.email = email;
}
public String getAddress() {
	return address;
}
public void setAddress(String address) {
	this.address = address;
}
public String getPhoneNumber() {
	return phoneNumber;
}
public void setPhoneNumber(String phoneNumber) {
	this.phoneNumber = phoneNumber;
}
public Date getDob() {
	return dob;
}
public void setDob(Date dob) {
	this.dob = dob;
}
public String getRole() {
	return role;
}
public void setRole(String role) {
	this.role = role;
}
public String getPassword() {
	return password;
}
public void setPassword(String password) {
	this.password = password;
}
@Override
public String toString() {
	return "Users [userID=" + userID + ", name=" + name + ", email=" + email + ", address="
			+ address + ", phoneNumber=" + phoneNumber + ", dob=" + dob + ", role=" + role + ", password=" + password
			+ "]";
}

}
