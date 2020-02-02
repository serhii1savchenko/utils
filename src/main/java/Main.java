import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class Main {

    private static final int INITIAL_LIST_SIZE = 17;
    private static final int PARTS_SIZE = 4;

    public static void main(String[] args) {
//        testListSplitter();
        testShazamJsonParser();
    }

    /** See here how to get the json http://shazamconverter.com/.
     *  Note that if you have more than 500 tracks in Shazam history then you need to
     *  edit the bookmark and replace "'?limit='+500" with, for example, "'?limit='+1000".
     *  The script is also attached to resources of this project. */
    private static void testShazamJsonParser() {
        File file = new File("D:\\03_Music\\673 myShazam.json");
        List<String> tracks = JsonParser.extractTracksFromShazamJson(file);
        int counter = 0;
        for (String track : tracks) {
            System.out.println(++counter + ": " + track);
        }
    }

    private static void testListSplitter() {
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
