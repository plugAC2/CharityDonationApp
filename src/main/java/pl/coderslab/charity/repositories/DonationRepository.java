package pl.coderslab.charity.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import pl.coderslab.charity.entities.Donation;

import java.util.List;

public interface DonationRepository extends JpaRepository<Donation, Long> {

    @Query("select SUM(d.quantity) from Donation d")
    Integer sacksAmount();

    @Query(nativeQuery = true, value = "select * from donation order by id desc limit 100;")
    List<Donation> getOneHundredDonations();

}
