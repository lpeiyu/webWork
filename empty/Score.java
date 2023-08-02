package empty;

public class Score {
    public String Sno;
    public String Cno;
    public int score;

    public Score() {
    }

    public Score(String sno, String cno, int score) {
        Sno = sno;
        Cno = cno;
        this.score = score;
    }

    public String getSno() {
        return Sno;
    }

    public void setSno(String sno) {
        Sno = sno;
    }

    public String getCno() {
        return Cno;
    }

    public void setCno(String cno) {
        Cno = cno;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

}
