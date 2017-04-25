package es.cesarlopezfab.weightu;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WeightRepository extends JpaRepository<Weight, String> {
	
	List<Weight> findByUserId(String userId);

}
