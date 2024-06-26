package exercise;

// BEGIN
class Cottage implements Home {
    private double area;
    private int floorCount;

    public Cottage(double area, int floorCount) {
        this.area = area;
        this.floorCount = floorCount;
    }

    @Override
    public String toString() {
        return floorCount + " этажный коттедж площадью " + area + " метров";
    }

    @Override
    public int compareTo(Home another) {
        if (another instanceof Cottage) {
            double anotherArea = another.getArea();
            if (area > anotherArea) {
                return 1;
            } else if (area < anotherArea) {
                return -1;
            } else {
                return 0;
            }
        } else {
            throw new IllegalArgumentException("Cannot compare with different types of Home.");
        }
    }

    @Override
    public double getArea() {
        return area;
    }
}

// END
