import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class SportTimeTrackerTest {
    @Test
    void testLogActivity() {
        SportsLogger.activities.clear();
        SportsLogger.activities.add(new SportsLogger.Activity("Running", 30));
        assertEquals(1, SportsLogger.activities.size());
        assertEquals("Running", SportsLogger.activities.get(0).name);
        assertEquals(30, SportsLogger.activities.get(0).duration);
    }

    @Test
    void testCalculateTotalTime() {
        SportsLogger.activities.clear();
        SportsLogger.activities.add(new SportsLogger.Activity("Running", 30));
        SportsLogger.activities.add(new SportsLogger.Activity("Swimming", 45));
        int totalTime = SportsLogger.activities.stream().mapToInt(a -> a.duration).sum();
        assertEquals(75, totalTime);
    }
}