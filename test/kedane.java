package test;

import static org.junit.Assert.*;
import arrays.Kedanes;
import java.util.List;

import org.junit.Test;

public class kedane {

    @Test
    public void test2D() {
        int[][] input = {
                            {1, 2, -1, -4, -20},
                            {-8, -3, 4, 2, 1},
                            {3, 8, 10, 1, 3},
                            {-4, -1, 1, 7, -6}
                        };
        List<Integer> result = Kedanes.kedane2D(input);
        assertEquals(29, (int) result.get(0));
        assertEquals(1, (int) result.get(1));
        assertEquals(3, (int) result.get(2));
        assertEquals(1, (int) result.get(3));
        assertEquals(3, (int) result.get(4));
    }

}
