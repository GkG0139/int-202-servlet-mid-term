package sit.int202.mid_exam_002.utils;

public class Utils {

  private Utils() {
  }

  public static boolean isPrimeNumber(int number) {
    boolean isPrime = true;
    for (int i = 2; i <= number / 2; ++i) {
      if (number % i == 0) {
        isPrime = false;
        break;
      }
    }
    return isPrime;
  }
}
