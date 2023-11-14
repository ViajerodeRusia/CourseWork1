final class Counter {
    private static int counter = 0;
    public static int getAndIncrement() {
        counter++;
        return counter;
    }
}