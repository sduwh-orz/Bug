package cn.edu.sdu.orz.bug;

import cn.edu.sdu.orz.bug.entity.*;
import cn.edu.sdu.orz.bug.entity.Module;
import cn.edu.sdu.orz.bug.repository.BugRepository;
import cn.edu.sdu.orz.bug.repository.ModuleRepository;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.List;

/**
 * BugApplication test.
 */
@SpringBootTest
public class BugApplicationTest {
    @Mock
    private BugRepository bugRepository;
    @Mock
    private ModuleRepository moduleRepository;

    /**
     * Test entities.
     */
    @Test
    void testEntities() {
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        User user = new User();
        Project project = new Project(
                "37A89B5A9D864C7482476CAA52758AC9", "Project Test",
                "test", "Project Test Description", user, timestamp, List.of()
        );
        Module module = new Module(
                "37A89B5A9D864C7482476CAA52758AC9", "Module Test",
                project, List.of());
        Bug bug = getBug(module, user, timestamp);
        Mockito.when(moduleRepository.findAll()).thenReturn(List.of(module));
        Mockito.when(bugRepository.findAll()).thenReturn(List.of(bug));
    }

    private static Bug getBug(Module module, User user, Timestamp timestamp) {
        Feature feature = new Feature(
                "37A89B5A9D864C7482476CAA52758AC9", "Feature Test",
                BigDecimal.ZERO, module, user, List.of()
        );
        BugGrade bugGrade = new BugGrade();
        BugStatus bugStatus = new BugStatus();
        BugSolveType bugSolveType = new BugSolveType();
        return new Bug(
                "37A89B5A9D864C7482476CAA52758AC9", "Bug Test",
                "Bug Test Description", bugGrade,
                user, bugStatus, bugSolveType, timestamp,
                timestamp, feature, List.of()
        );
    }
}
