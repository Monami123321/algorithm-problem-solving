import java.util.*;
import java.util.stream.*;
public class Test {
    long sum(int[] a) {
        return Arrays.stream(a).mapToLong(i -> i).sum();
    }
}
