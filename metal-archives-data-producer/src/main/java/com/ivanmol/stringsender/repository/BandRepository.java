package com.ivanmol.stringsender.repository;

import com.ivanmol.stringsender.model.Band;
import jakarta.persistence.NoResultException;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BandRepository extends JpaRepository<Band, Long> {
    default Band getByIdAndCheck(Long id) {
        return findById(id).orElseThrow(() -> new NoResultException("Band with id " + id + " is not found"));
    }

    List<Band> findByNameContainsIgnoreCase(String name);

}
