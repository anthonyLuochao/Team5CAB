package sg.iss.team5cab.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import sg.iss.team5cab.model.Facility;

public interface FacilityRepository extends JpaRepository<Facility, Integer> {

}
