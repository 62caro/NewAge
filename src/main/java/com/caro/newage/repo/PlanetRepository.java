package com.caro.newage.repo;

import com.caro.newage.entity.Planet;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PlanetRepository extends JpaRepository<Planet, Long> {

    Iterable<Planet> findByName(String name);

}
