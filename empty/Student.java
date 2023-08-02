package empty;

public class Student {
    String Sno;
    String Sname;
    int Sage;
    String Saddress;

    public Student() {
    }

    public Student(String sno, String sname, int sage, String saddress) {
        Sno = sno;
        Sname = sname;
        Sage = sage;
        Saddress = saddress;
    }

    public String getSno() {
        return Sno;
    }

    public void setSno(String sno) {
        Sno = sno;
    }

    public String getSname() {
        return Sname;
    }

    public void setSname(String sname) {
        Sname = sname;
    }

    public int getSage() {
        return Sage;
    }

    public void setSage(int sage) {
        Sage = sage;
    }

    public String getSaddress() {
        return Saddress;
    }

    public void setSaddress(String saddress) {
        Saddress = saddress;
    }
}
