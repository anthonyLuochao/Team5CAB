package sg.iss.team5cab.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import sg.iss.team5cab.model.Booking;

public interface BookingRepository extends JpaRepository<Booking, Integer> {

}
