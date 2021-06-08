package com.caro.newage.repository;

import com.caro.newage.repo.RulerRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RulerRepositoryTest {

    @Mock
    private RulerRepository rulerRepository;

    public RulerRepositoryTest() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void findAllByAge() {
        rulerRepository.findAllByAge(PageRequest.of(0, 1));
    }
}
