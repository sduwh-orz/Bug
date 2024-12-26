package cn.edu.sdu.orz.bug;

import cn.edu.sdu.orz.bug.entity.Module;
import cn.edu.sdu.orz.bug.entity.Project;
import cn.edu.sdu.orz.bug.repository.ModuleRepository;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

/**
 * BugApplication test.
 */
@SpringBootTest
public class BugApplicationTest {
    @Mock
    private ModuleRepository moduleRepository;

    /**
     * Test entities.
     */
    @Test
    void testEntities() {
        Module module = new Module(
                "37A89B5A9D864C7482476CAA52758AC9", "Module Test",
                new Project(), List.of());
        Mockito.when(moduleRepository.findAll()).thenReturn(List.of(module));
    }
}
