package com.caro.newage.repo;

import com.caro.newage.entity.Ruler;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface RulerRepository extends JpaRepository<Ruler, Long> {

    Ruler findByName(String name);

    @Query("select r from Ruler r ORDER BY r.age ASC ")
    Page<Ruler> findAllByAge(Pageable pageable);

    @Query("select r from Ruler r where r.planet.size = 0")
    Iterable<Ruler> findRulersWithoutPlanet();

}
