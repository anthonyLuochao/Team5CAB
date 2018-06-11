package sg.iss.team5cab.model;

import java.time.LocalDate;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="booking")
public class Booking {
@Id
private int bookingID;
@ManyToOne
@JoinColumn(name="userID",nullable=false)
private Users users;
@ManyToOne
@JoinColumn(name="facilityID",nullable=false)
private Facility facility;

//private int facilityID;
//private String userID;
@Column(name="start_Date",columnDefinition="DATE")
private LocalDate startDate;
@Column(name="end_Date",columnDefinition="DATE")
private LocalDate endDate;
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

public LocalDate getStartDate() {
	return startDate;
}
public void setStartDate(LocalDate startDate) {
	this.startDate = startDate;
}
public LocalDate getEndDate() {
	return endDate;
}
public void setEndDate(LocalDate endDate) {
	this.endDate = endDate;
}
public boolean isUnderMaintenance() {
	return isUnderMaintenance;
}
public void setUnderMaintenance(boolean isUnderMaintenance) {
	this.isUnderMaintenance = isUnderMaintenance;
}
public boolean isCancel() {
	return isCancel;
}
public void setCancel(boolean isCancel) {
	this.isCancel = isCancel;
}
@Override
public String toString() {
	return "Booking [bookingID=" + bookingID + ", usersID=" + users.getUserID() + ", facilityID=" + facility.getFacilityID() + ", startDate="
			+ startDate + ", endDate=" + endDate + ", isUnderMaintenance=" + isUnderMaintenance + ", isCancel="
			+ isCancel + "]";
}


}
