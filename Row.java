public class Row {
    private String club1;
    private String club2;
    private int score1;
    private int score2;

    public Row(String club1, String club2, int score1, int score2) {
        this.club1 = club1;
        this.club2 = club2;
        this.score1 = score1;
        this.score2 = score2;
    }

    public String getClub1() {
        return this.club1;
    }

    public String getClub2() {
        return this.club2;
    }

    public int getScore1() {
        return this.score1;
    }

    public int getScore2() {
        return this.score2;
    }


}
