package exercise;

// BEGIN
public class MaxThread extends Thread {
    private final int[] numbers;
    private int maxValue;

    public MaxThread(int[] numbers) {
        this.numbers = numbers;
    }

    @Override
    public void run() {
        if (numbers == null || numbers.length == 0) {
            throw new IllegalArgumentException("Array cannot be null or empty");
        }

        maxValue = numbers[0];
        for(int number : numbers) {
            if(number > maxValue) {
                maxValue = number;
            }
        }
    }

    public int getMaxValue() {
        return maxValue;
    }
}

// END
