package empty;

public class Work {
    private String Cno;
//    private String Tno;
    private String publishDate;
    private String Deadline;
    private String message;

    public Work() {
    }

    public Work(String cno, String tno, String publishDate, String deadline, String message) {
        Cno = cno;
//        Tno= tno;
        this.publishDate = publishDate;
        Deadline = deadline;
        this.message = message;
    }

    public String getCno() {
        return Cno;
    }

    public void setCno(String cno) {
        Cno = cno;
    }

//    public String getTno() {
//        return Tno;
//    }
//
//    public void setTno(String tno) {
//        Tno = tno;
//    }

    public String getPublishDate() {
        return publishDate;
    }

    public void setPublishDate(String publishDate) {
        this.publishDate = publishDate;
    }

    public String getDeadline() {
        return Deadline;
    }

    public void setDeadline(String deadline) {
        Deadline = deadline;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "Work{" +
                "Cno='" + Cno + '\'' +
//                ", Tno='" + Tno + '\'' +
                ", publishDate='" + publishDate + '\'' +
                ", Deadline='" + Deadline + '\'' +
                ", message='" + message + '\'' +
                '}';
    }
}
