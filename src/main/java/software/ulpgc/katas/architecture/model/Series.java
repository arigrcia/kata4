package software.ulpgc.katas.architecture.model;

import java.util.Arrays;

public class Series {
    private final int[] values;

    public Series() {
        this(new int[0]);
    }

    private Series(int[] values) {
        this.values = values;
    }

    public Series put(int value) {
        int[] values = Arrays.copyOf(this.values, this.values.length + 1);
        values[this.values.length] = value;
        return new Series(values);
    }

    public int[] get() {
        return values;
    }

    public int get(int index) {
        return values[index];
    }
}