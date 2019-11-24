import java.util.ArrayList;
import java.util.List;

public class Mail {

    private static final int INITIAL_LIST_SIZE = 17;
    private static final int PARTS_SIZE = 4;

    public static void main(String[] args) {
        List<String>  testList = new ArrayList<>();
        for (int i = 0; i < INITIAL_LIST_SIZE; i++) {
            testList.add(String.valueOf(i));
        }

        List<List<String>> parts = ListUtils.splitIntoParts(testList, PARTS_SIZE);

        for (List<String> part : parts) {
            System.out.println(part);
        }
    }

}
