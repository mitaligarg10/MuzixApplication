package com.stackroute.muzix.repository;

import com.stackroute.muzix.domain.Muzix;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MuzixRepository extends JpaRepository<Muzix, Long> {
}
