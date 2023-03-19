import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Integer> arrList = new ArrayList<>();

        LinkedList<Integer> linkedList = new LinkedList<>();
        List<Integer> anotherList = linkedList; // 1

        linkedList.add(15); // добавили 15, занял 0-й элемент
        System.out.println(anotherList);

        linkedList.addLast(28); //  в конец списка, т.е. элемент [1]
        System.out.println(anotherList);

        linkedList.remove(0); // убрать 0-й элемент (со сдвигом в лево автоматически)
        System.out.println(anotherList);

        linkedList.set(0, 33); // установить 0-й элемент равный 33
        System.out.println(anotherList);

        linkedList.addFirst(null); //  в начало списка, т.е. элемент [0], со сдвигом в право всех имеющихся
        System.out.println(anotherList);

        List<Integer> anotherList2 = linkedList; // 1
        System.out.println(anotherList2 + " " + linkedList);

        System.out.println(linkedList.getFirst());
        System.out.println(linkedList.getLast());
        System.out.println(linkedList.getClass());
    }
}
