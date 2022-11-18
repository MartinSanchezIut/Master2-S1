package qengine.program.Utils;

public class Result {

    private Integer s, p, o;

    public Result(Integer s, Integer p, Integer o) {
        this.s = s; this.p = p; this.o = o;
    }

    public Integer getSubject() { return s; }
    public Integer getPredicate() { return p; }
    public Integer getObject() { return o; }

    @Override
    public String toString() {
        return "[" + s + ", " + p + ", " + o + "]";
    }
}
