package thread.collection;

import java.util.ArrayList;
import java.util.List;

public class SimpleListMainV0 {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();

        list.add("A"); //thread1 실행
        list.add("B"); //thread2 실행
        System.out.println( "list = " + list );
    }
}
