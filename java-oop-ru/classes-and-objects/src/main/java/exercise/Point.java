package exercise;

// BEGIN
public class Point {
    private int x;
    private int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public static void main(String[] args) {
        Point point = new Point(4, 3);
        int x = point.getX();
        int y = point.getY();
        System.out.println("x: " + x);
        System.out.println("y: " + y);
    }
}
// END
