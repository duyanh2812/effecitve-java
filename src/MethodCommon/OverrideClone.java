package MethodCommon;

/*
The copy constructor approach and its static factory variant have many
advantages over Cloneable/clone: they don’t rely on a risk-prone
extralinguistic object creation mechanism; they don’t demand unenforceable
adherence to thinly documented conventions; they don’t conflict with the proper
use of final fields; they don’t throw unnecessary checked exceptions; and they
don’t require casts.
Furthermore, a copy constructor or factory can take an argument whose type is
an interface implemented by the class
 */
class Yum {
    private int x;
    private int y;

    public Yum(Yum yum) {
        this.x = yum.x;
        this.y = yum.y;
    }

    public static Yum newInstance(Yum yum) {
        return new Yum(yum);
    }

}

public class OverrideClone {
    public static void main(String[] args) {
        // Original employee

    }
}
