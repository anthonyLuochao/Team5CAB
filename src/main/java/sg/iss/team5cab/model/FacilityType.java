package sg.iss.team5cab.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import org.hibernate.mapping.Set;
import sg.iss.team5cab.model.Facility;
import java.util.Collection;
import java.util.List;

@Entity
@Table(name="facility_type")

public class FacilityType {
@Id
private String typeID;
private String typeName;
@OneToMany(mappedBy="facilityType")
private List<Facility> facilities;

public String getTypeID() {
	return typeID;
}
public void setTypeID(String typeID) {
	this.typeID = typeID;
}
public String getTypeName() {
	return typeName;
}
public void setTypeName(String typeName) {
	this.typeName = typeName;
}
@Override
public String toString() {
	return "FacilityType [typeID=" + typeID + ", typeName=" + typeName +"]";
}

}

