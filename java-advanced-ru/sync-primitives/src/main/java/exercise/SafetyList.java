package exercise;

import java.util.List;
import java.util.ArrayList;

class SafetyList {
    // BEGIN
    private final List<Integer> list;

    public SafetyList() {
        this.list = new ArrayList<>();
    }

    public synchronized void add(int num) {
        list.add(num);
    }

    public synchronized Integer get(int index) {
        return list.get(index);
    }

    public synchronized int getSize() {
        return list.size();
    }
    // END
}
