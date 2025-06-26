package fundamental_concept.original;

import fundamental_concept.my_implements.MyFixedCapacityStack;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FixedCapacityStackTest {


    private final int INIT_SIZE = 100;
    private MyFixedCapacityStack<String> sut;

    @BeforeEach
    void setUp() {
        sut = new MyFixedCapacityStack<>(INIT_SIZE);
    }


    @Test
    @DisplayName("성공적으로 생성되는지 확인, 생성 초가애 사이즈가 0인지 확인")
    public void test1() {
        assertNotNull(sut);
        assertTrue(sut.isEmpty());
        assertTrue(sut.size() == 0);
    }

    @Test
    @DisplayName("아이템 푸쉬 및 팝이 성공적으로 처리되는지 확인")
    public void test2() {
        String item = "banana";
        assertDoesNotThrow(() -> sut.push(item));
        assertEquals(item, sut.pop());
    }

    @Test
    @DisplayName("N 사이즈가 다 찼을 때 아이템을 푸쉬할 경우 실패해야함")
    public void test3() {
        String item = "apple";

        for (int i=0; i<INIT_SIZE; i++) {
            assertDoesNotThrow(() -> sut.push(item));
        }

        assertThrows(RuntimeException.class,
                () -> sut.push(item)
        );
    }

    @Test
    @DisplayName("아이템 요소가 존재하지 않을 때 팝할 경우 실패해야함")
    public void test5() {
        assertThrows(RuntimeException.class,
                () -> sut.pop()
        );
    }



}