package exercise;

// BEGIN
class App {
    public static void printSquare(Circle circle) {
        try {
            double square = circle.getSquare();
            int roundedSQuare = (int) Math.round(square);
            System.out.println(roundedSQuare);
        } catch (NegativeRadiusException e) {
            System.out.println("Не удалось посчитать площадь");
        } finally {
            System.out.println("Вычисление окончено");
        }
    }
}

// END
