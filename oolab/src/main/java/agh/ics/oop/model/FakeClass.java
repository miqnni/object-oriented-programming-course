package agh.ics.oop.model;

// For testing purposes -- we're checking whether
// the method equals() returns false when the object Other
// does not represent the class Vector2d
public class FakeClass {
    private final int x;

    private final String msg;

    public FakeClass(int x, String msg) {
        this.x = x;
        this.msg = msg;
    }

    public int getX() {
        return x;
    }

    public String getMsg() {
        return msg;
    }
}
