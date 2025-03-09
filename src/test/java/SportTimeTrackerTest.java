import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class SportTimeTrackerTest {
    @Test
    void testLogActivity() {
        ArrayList<SportTimeTracker.Activity> activities = new ArrayList<>();
        activities.add(new SportTimeTracker.Activity("Running", 30));
        assertEquals(1, activities.size());
        assertEquals("Running", activities.get(0).name);
        assertEquals(30, activities.get(0).duration);
    }

    @Test
    void testCalculateTotalTime() {
        ArrayList<SportTimeTracker.Activity> activities = new ArrayList<>();
        activities.add(new SportTimeTracker.Activity("Running", 30));
        activities.add(new SportTimeTracker.Activity("Swimming", 45));
        int totalTime = activities.stream().mapToInt(a -> a.duration).sum();
        assertEquals(75, totalTime);
    }
}