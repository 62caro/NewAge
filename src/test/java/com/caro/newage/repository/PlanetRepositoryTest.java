package com.caro.newage.repository;

import com.caro.newage.entity.Planet;
import com.caro.newage.repo.PlanetRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
@RunWith(SpringRunner.class)
@SpringBootTest
public class PlanetRepositoryTest {
    @Mock
    private PlanetRepository planetRepository;

    public PlanetRepositoryTest() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testFindAll() {
        planetRepository.findAll();
    }


}
