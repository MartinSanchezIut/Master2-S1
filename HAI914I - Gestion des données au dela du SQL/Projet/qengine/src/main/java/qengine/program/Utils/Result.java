package qengine.program.Utils;

import java.util.ArrayList;
import java.util.Objects;

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


    public static ArrayList<Result> intersect(ArrayList<Result> a1, ArrayList<Result> a2) {
        ArrayList<Result> ret = new ArrayList<>();
        for(Result i : a1) { if (a2.contains(i)) { ret.add(i) ; } }
        return ret;
    }

    @Override
    public boolean equals(Object o1) {
        if (this == o1) return true;
        if (o1 == null || getClass() != o1.getClass()) return false;
        Result result = (Result) o1;
        return Objects.equals(s, result.s) && Objects.equals(p, result.p) && Objects.equals(o, result.o);
    }

    @Override
    public int hashCode() {
        return Objects.hash(s, p, o);
    }
}
