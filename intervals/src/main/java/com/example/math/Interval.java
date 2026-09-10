package com.example.math;

public final class Interval {

    private final double start, end;

    public Interval(double start, double end) {
        if (start > end) {
            throw new IllegalArgumentException("start > end");
        }

        this.start = start;
        this.end = end;
    }

    public double start() {
        return start;
    }

    public double end() {
        return end;
    }

    public double length() {
        return end - start;
    }

    public boolean contains(double x) {
        return x >= start && x <= end;
    }

    public boolean overlaps(Interval o) {
        return !(o.end < this.start || o.start > this.end);
    }

    @Override
    public String toString() {
        return "[" + start + "," + end + "]";
    }
}