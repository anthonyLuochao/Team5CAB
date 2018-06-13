package sg.iss.team5cab.model;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table(name="facility")
public class Facility {
	
@Id@GeneratedValue(strategy=GenerationType.IDENTITY)
private int facilityID;

@OneToMany(mappedBy="facility")
private List<Booking> bookings;

@ManyToOne
@JoinColumn(name="typeID",nullable=false)
private FacilityType facilityType;

private String facilityName;
private String description;
private String address;

//private String typeID;
@Column(columnDefinition="TINYINT")
private boolean isDamaged;
private String damageReason;
@Column(columnDefinition="TINYINT")
private boolean isDeleted;

public boolean getIsDeleted() {
	return isDeleted;
}
public void setIsDeleted(boolean isDeleted) {
	this.isDeleted = isDeleted;
}
public int getFacilityID() {
	return facilityID;
}
public void setFacilityID(int facilityID) {
	this.facilityID = facilityID;
}
public FacilityType getFacilityType() {
	return facilityType;
}
public void setFacilityType(FacilityType facilityType) {
	this.facilityType = facilityType;
}
public String getFacilityName() {
	return facilityName;
}
public void setFacilityName(String facilityName) {
	this.facilityName = facilityName;
}
public String getDescription() {
	return description;
}
public void setDescription(String description) {
	this.description = description;
}
public String getAddress() {
	return address;
}
public void setAddress(String address) {
	this.address = address;
}
public boolean getIsDamaged() {
	return isDamaged;
}
public void setIsDamaged(boolean isDamaged) {
	this.isDamaged = isDamaged;
}
public String getDamageReason() {
	return damageReason;
}
public void setDamageReason(String damageReason) {
	this.damageReason = damageReason;
}
@Override
public String toString() {
	return "Facility [facilityID=" + facilityID + " TypeID="
			+ ", facilityName=" + facilityName + ", description=" + description + ", address=" + address
			+ ", isDamaged=" + isDamaged + ", damageReason=" + damageReason + "]";
}

}


