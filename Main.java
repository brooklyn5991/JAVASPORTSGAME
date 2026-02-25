import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.nio.file.Paths;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Row> lists = new ArrayList<>();

        System.out.println("what file do you want to search?");
        String fileName = scanner.nextLine();

        try(Scanner sc = new Scanner(Paths.get(fileName))) {

            while (sc.hasNextLine()) {
                String line = sc.nextLine();

                if(line.isEmpty()) {
                    continue;
                }

                String[] parts = line.split(",");
                String club1 = parts[0];
                String club2 = parts[1];
                int score1 = Integer.valueOf(parts[2]);
                int score2 = Integer.valueOf(parts[3]);
                lists.add(new Row(club1, club2, score1, score2));
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        System.out.println("what club do you want to search for?");
        String club = scanner.nextLine();

        int games = 0;
        int wins = 0;
        int loss = 0;
        for(Row match: lists) {
            if(match.getClub1().equals(club) || match.getClub2().equals(club)) {
                games++;
            }
            if(match.getClub1().equals(club) && match.getScore1() > match.getScore2()) {
                wins++;
            }
            if (match.getClub1().equals(club) && match.getScore1() < match.getScore2()){
                loss++;
            }
            if(match.getClub2().equals(club) && match.getScore2() > match.getScore1()) {
                wins++;
            }
            if(match.getClub2().equals(club) && match.getScore2() < match.getScore1()) {
                loss++;
            }


        }
        System.out.println("Games: " + games);
        System.out.println("Wins: " + wins);
        System.out.println("Losses: " + loss);
    }
}