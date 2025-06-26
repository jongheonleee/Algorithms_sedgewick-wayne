package fundamental_concept.original;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

class ResizingArrayStackTest {

    private ResizingArrayStack<String> sut;


    @BeforeEach
    void setUp() {
        sut = new ResizingArrayStack<>();
    }

    @Test
    @DisplayName("성공적으로 생성되는지 확인")
    public void test1() {
        assertNotNull(sut);
        assertTrue(sut.isEmpty());
        assertTrue(0 == sut.size());
    }

    @Test
    @DisplayName("아이템 푸쉬 및 팝이 성공적으로 처리되는지 확인")
    public void test2() {
        String item = "banana";

        sut.push(item);
        assertTrue(1 == sut.size());

        String popped = sut.pop();
        assertTrue(item.equals(popped));
    }


    @Test
    @DisplayName("아이템 요소가 다 찼을 때 내부적으로 리사이징이 일어나는지 확인")
    public void test3() {
        // 사실 이 부분은 외부에서 확인하게 만들면 안되는 기능임, 외부에서는 API 기능에 대해서만 알면되지 내부 동작원리를 알필요가 없음
        // resiging 이 발생하는 시점: 1 -> 2 -> 4 -> 8 -> 16
        String item = "banana";
        HashSet<Integer> moments = new HashSet<>(Set.of(1, 2, 4, 8, 16));

        for (int i=0; i<=16; i++) {
            if (moments.contains(i)) {
                assertDoesNotThrow(() -> sut.push(item));
            } else {
                sut.push(item);
            }
        }
    }

    @Test
    @DisplayName("아이템 요소가 기존 배열의 크기 1/4일 경우 리사이징이 일어나는지 확인")
    public void test4() {
        // 초기에 16 크기의 스택이라고 가정
        // resiging 이 발생하는 시점: 4 -> 1
        String item = "banana";
        HashSet<Integer> moments = new HashSet<>(Set.of(4, 1));

        for (int i=0; i<=16; i++) { sut.push(item); }

        for (int j=16; j>=0; j--) {
            if (moments.contains(j)) {
                assertDoesNotThrow(() -> sut.pop());
            } else {
                sut.pop();
            }
        }
    }

    @Test
    @DisplayName("이터레이터 반환하는지 확인하고 해당 기능 정상적으로 수행하는지 확인")
    public void test5() {
        String item = "banana";
        List<String> expected = List.of(
                 "banana16", "banana15", "banana14", "banana13",
                            "banana12", "banana11", "banana10", "banana9",
                            "banana8", "banana7", "banana6", "banana5",
                            "banana4", "banana3", "banana2", "banana1",
                            "banana0"
        );
        for (int i=0; i<=16; i++) { sut.push(item + i); }

        Iterator<String> it = sut.iterator();

        int j = 0;
        while (it.hasNext()) {
            String popped = it.next();
            String result = expected.get(j++);
            assertTrue(result.equals(popped));
        }
    }


}