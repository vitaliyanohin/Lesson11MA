import java.util.HashSet;
import java.util.Set;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class Main {

  public static void main(String[] args) {
    arrayShuffle2();
  }

  private static void arrayShuffle2() {
    Deque<Integer> deque = new ArrayDeque<>();
    Scanner scanner = new Scanner(System.in);
    for (int i = 0; scanner.hasNextInt(); i++) {
      if (i % 2 != 0) {
        deque.add(scanner.nextInt());
      } else {
        scanner.nextInt();
      }
    }
    int size = deque.size();
    for (int i = 0; i < size; i++)
      System.out.print(deque.removeLast() + " ");
  }

  private static String getCallerClassAndMethodName() {
    StackTraceElement[] stackTraceArray = new Exception().getStackTrace();
    return (stackTraceArray.length < 3) ? null : stackTraceArray[2].getClassName() + "#" + stackTraceArray[2].getMethodName();
  }

  private static <T> Set<T> symmetricDifference(Set<? extends T> set1, Set<? extends T> set2) {
    Set<T> setTempFirst = new HashSet<>(set1);
    Set<T> setTempSecond = new HashSet<>(set2);
    Set<T> setFinal = new HashSet<>();
    setTempSecond.removeAll(set1);
    setTempFirst.removeAll(set2);
    setFinal.addAll(setTempFirst);
    setFinal.addAll(setTempSecond);
    return setFinal;
  }
}
