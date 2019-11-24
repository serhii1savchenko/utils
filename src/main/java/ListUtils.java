import java.util.ArrayList;
import java.util.List;

public class ListUtils {

    public static List<List<String>> splitIntoParts(List<String> input, int partsNumber) {
        List<List<String>> parts = new ArrayList<>();
        if (input != null && partsNumber > 0) {
            int residue = input.size() % partsNumber;
            int batchSize = (input.size() - residue) / partsNumber;
            int counter = 0;
            for (int i = 0; i < partsNumber; i++) {
                List<String> temp = new ArrayList<>();
                for (int j = 0; j < batchSize; j++) {
                    temp.add(input.get(counter));
                    counter++;
                }
                if (residue > 0) {
                    temp.add(input.get(counter));
                    counter++;
                    residue--;
                }
                parts.add(temp);
            }
        }
        return parts;
    }
}
