package sg.iss.team5cab.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="booking")
public class Booking {
	
@Id
@GeneratedValue(strategy=GenerationType.IDENTITY)
private int bookingID;

@ManyToOne
@JoinColumn(name="userID",nullable=false)
private Users users;

@ManyToOne
@JoinColumn(name="facilityID",nullable=false)
private Facility facility;

@DateTimeFormat(pattern = "MM/dd/yyyy") 
@Column(name="start_Date",columnDefinition="DATE")
private Date startDate;

@DateTimeFormat(pattern = "MM/dd/yyyy") 
@Column(name="end_Date",columnDefinition="DATE")
private Date endDate;

@Column(columnDefinition="TINYINT")
private boolean isUnderMaintenance;  

@Column(columnDefinition="TINYINT")
private boolean isCancel;

public Users getUsers() {
	return users;
}

public void setUsers(Users users) {
	this.users = users;
}
public Facility getFacility() {
	return facility;
}
public void setFacility(Facility facility) {
	this.facility = facility;
}
public int getBookingID() {
	return bookingID;
}
public void setBookingID(int bookingID) {
	this.bookingID = bookingID;
}

public Date getStartDate() {
	return startDate;
}
public void setStartDate(Date startDate) {
	this.startDate = startDate;
}
public Date getEndDate() {
	return endDate;
}
public void setEndDate(Date endDate) {
	this.endDate = endDate;
}
public boolean getIsUnderMaintenance() {
	return isUnderMaintenance;
}
public void setIsUnderMaintenance(boolean isUnderMaintenance) {
	this.isUnderMaintenance = isUnderMaintenance;
}
public boolean getIsCancel() {
	return isCancel;
}

public void setIsCancel(boolean isCancel) {
	this.isCancel = isCancel;
}
@Override
public String toString() {
	return "Booking [bookingID=" + bookingID + ", usersID=" + users.getUserID() + ", facilityID=" + facility.getFacilityID() + ", startDate="
			+ startDate + ", endDate=" + endDate + ", isUnderMaintenance=" + isUnderMaintenance + ", isCancel="
			+ isCancel + "]";
}


}
