package exercise;

class SafetyList {
    // BEGIN
    private final List<Integer> list;

    public synchronized void add(int num) {
        List.add(num);
    }

    public synchronized void get(int index) {
        return list.get(index);
    }

    public synchronized void getSize() {
        return list.size();
    }
    // END
}
