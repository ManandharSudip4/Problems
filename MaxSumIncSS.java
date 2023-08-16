import java.util.ArrayList;

class Main {

  public static ArrayList<Integer> problemSolver(int[] myList) {
    int n = myList.length;
    int[] dp = new int[n];
    ArrayList<Integer>[] subsequences = new ArrayList[n];

    for (int i = 0; i < n; i++) {
      dp[i] = myList[i];
      subsequences[i] = new ArrayList<>();
      subsequences[i].add(myList[i]);
    }

    int maxSumIndex = 0;
    for (int i = 1; i < n; i++) {
      for (int j = 0; j < i; j++) {
        if (myList[i] > myList[j] && dp[i] < dp[j] + myList[i]) {
          dp[i] = dp[j] + myList[i];
          subsequences[i] = new ArrayList<>(subsequences[j]);
          subsequences[i].add(myList[i]);
        }
      }
      if (dp[i] > dp[maxSumIndex]) {
        maxSumIndex = i;
      }
    }

    return subsequences[maxSumIndex];
  }

  public static void main(String[] args) {
    int[] mylist = { 0, 8, 4, 12, 2, 10, 6, 14, 1, 9, 5, 13, 3, 11 };
    ArrayList<Integer> subsequence = problemSolver(mylist);
    System.out.println(subsequence);
  }
}
