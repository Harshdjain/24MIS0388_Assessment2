public class CricketStatistics {
    public static void main(String[] args) {

        String[] player = {"Virat", "Rohit", "Gill", "Bumrah", "Surya"};
        int[] runs = {650, 720, 540, 120, 480};
        int[] balls = {400, 450, 300, 100, 280};
        int[] wickets = {0, 0, 0, 28, 5};

        int n = player.length;

        System.out.println("Strike Rates:");
        for (int i = 0; i < n; i++) {
            double strikeRate = (runs[i] * 100.0) / balls[i];
            System.out.println(player[i] + " : " + strikeRate);
        }

        int orange = 0;
        for (int i = 1; i < n; i++) {
            if (runs[i] > runs[orange]) {
                orange = i;
            }
        }

        System.out.println("\nOrange Cap Winner: " + player[orange]);
        System.out.println("Runs: " + runs[orange]);

        int purple = 0;
        for (int i = 1; i < n; i++) {
            if (wickets[i] > wickets[purple]) {
                purple = i;
            }
        }

        System.out.println("\nPurple Cap Winner: " + player[purple]);
        System.out.println("Wickets: " + wickets[purple]);

        System.out.println("\nPlayers with Strike Rate above 150:");
        for (int i = 0; i < n; i++) {
            double strikeRate = (runs[i] * 100.0) / balls[i];
            if (strikeRate > 150) {
                System.out.println(player[i] + " : " + strikeRate);
            }
        }

        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                if (runs[j] > runs[i]) {

                    int tempRuns = runs[i];
                    runs[i] = runs[j];
                    runs[j] = tempRuns;

                    String tempPlayer = player[i];
                    player[i] = player[j];
                    player[j] = tempPlayer;

                    int tempBalls = balls[i];
                    balls[i] = balls[j];
                    balls[j] = tempBalls;

                    int tempWickets = wickets[i];
                    wickets[i] = wickets[j];
                    wickets[j] = tempWickets;
                }
            }
        }

        System.out.println("\nRanking by Runs:");
        for (int i = 0; i < n; i++) {
            System.out.println((i + 1) + ". " + player[i] + " - " + runs[i] + " runs");
        }
    }
}