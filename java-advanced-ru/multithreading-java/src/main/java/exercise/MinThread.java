package exercise;

// BEGIN
public class MinThread extends Thread {
    private final int[] numbers;
    private int minValue;

    public MinThread(int[] numbers) {
        this.numbers = numbers;
    }

    @Override
    public void run() {
        if (numbers == null || numbers.length == 0) {
            throw new IllegalArgumentException("Array cannot be null or empty");
        }

        minValue = numbers[0];
        for (int number : numbers) {
            if (number < minValue) {
                minValue = number;
            }
        }
    }

    public int getMinValue() {
        return minValue;
    }
}
// END
