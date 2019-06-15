import java.util.*;

public class Main {

  public static void main(String[] args) {
    System.out.println(getCallerClassAndMethodName());
    Set<Integer> setFirst = new HashSet<>();
    Set<Integer> setSecond = new HashSet<>();
    setFirst.add(1);
    setFirst.add(2);
    setFirst.add(3);
    setSecond.add(0);
    setSecond.add(1);
    setSecond.add(2);
    System.out.println(symmetricDifference(setFirst, setSecond));
    arrayShuffle();
  }

  private static void arrayShuffle() {
    System.out.println(getCallerClassAndMethodName());
    Deque<Integer> deque = new ArrayDeque<>();
    Scanner scanner = new Scanner(System.in);
    while (scanner.hasNextInt()) {
      if (scanner.nextInt() % 2 != 0) {
        deque.add(scanner.nextInt());
      } else {
        scanner.nextInt();
      }
    }
    for (int i = 0; i < deque.size(); i++) {
      System.out.print(deque.removeLast() + " ");
    }
  }

  private static String getCallerClassAndMethodName() {
    StackTraceElement[] stackTraceArray = new Exception().getStackTrace();
    return (stackTraceArray.length < 3) ? null :
            stackTraceArray[2].getClassName() + "#" + stackTraceArray[2].getMethodName();
  }

  private static <T> Set<T> symmetricDifference(Set<? extends T> set1, Set<? extends T> set2) {
    Set<T> setTempFirst = new HashSet<>();
    Set<T> setTempSecond = new HashSet<>();
    Set<T> setFinal = new HashSet<>();
    setTempFirst.addAll(set1);
    setTempSecond.addAll(set2);
    setTempSecond.removeAll(set1);
    setTempFirst.removeAll(set2);
    setFinal.addAll(setTempFirst);
    setFinal.addAll(setTempSecond);
    return setFinal;
  }
}
