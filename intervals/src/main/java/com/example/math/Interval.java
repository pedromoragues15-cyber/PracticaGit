package com.example.math;

import java.util.Optional;

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

    public Optional<Interval> intersection(Interval o) {
        double s = Math.max(this.start, o.start);
        double e = Math.min(this.end, o.end);

        return (s <= e)
                ? Optional.of(new Interval(s, e))
                : Optional.empty();
    }

    public Optional<Interval> union(Interval o) {
        if (!this.overlaps(o) &&
                !(this.end == o.start || o.end == this.start)) {
            return Optional.empty();
        }

        double s = Math.min(this.start, o.start);
        double e = Math.max(this.end, o.end);

        return Optional.of(new Interval(s, e));
    }

    @Override
    public String toString() {
        return "[" + start + "," + end + "]";
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Interval o)) return false;

        double eps = 1e-9;

        return Math.abs(start - o.start) < eps
                && Math.abs(end - o.end) < eps;
    }

    @Override
    public int hashCode() {
        return Double.hashCode(start) * 31 + Double.hashCode(end);
    }
}