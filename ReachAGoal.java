public class ReachAGoal {
  public long count(int n) {
    long[] dp = new long[n + 1];
    dp[0] = 1; // Base case: there is one way to reach 0

    int[] moves = {3, 5, 10};

    for (int i = 0; i < moves.length; i++) {
        for (int j = moves[i]; j <= n; j++) {
            dp[j] += dp[j - moves[i]];
        }
    }

    return dp[n];
}

  public static void main(String[] args) {
    ReachAGoal geeks = new ReachAGoal();
      int n = 20; // Change the value of n as needed
      long result = geeks.count(n);
      System.out.println("Result: " + result);
  }
}
