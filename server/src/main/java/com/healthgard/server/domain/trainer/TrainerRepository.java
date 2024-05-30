package com.healthgard.server.domain.trainer;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface TrainerRepository extends JpaRepository<Trainer, Long>{
	
	@Query("SELECT t FROM Trainer t ORDER BY t.id DESC")
	List<Trainer> findAllDesc();

}
