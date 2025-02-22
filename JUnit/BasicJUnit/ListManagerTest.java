import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.List;

class ListManager {
    void addElement(List<Integer> list, int element) {
        list.add(element);
    }

    void removeElement(List<Integer> list, int element) {
        list.remove(Integer.valueOf(element));
    }

    int getSize(List<Integer> list) {
        return list.size();
    }
}

public class ListManagerTest {
    ListManager manager = new ListManager();

    @Test
    void testAddElement() {
        List<Integer> list = new ArrayList<>();
        manager.addElement(list, 5);
        assertTrue(list.contains(5));
    }

    @Test
    void testRemoveElement() {
        List<Integer> list = new ArrayList<>();
        manager.addElement(list, 10);
        manager.removeElement(list, 10);
        assertFalse(list.contains(10));
    }

    @Test
    void testGetSize() {
        List<Integer> list = new ArrayList<>();
        manager.addElement(list, 1);
        manager.addElement(list, 2);
        assertEquals(2, manager.getSize(list));
    }
}
