package fr.frinn.custommachinery.impl.util;

import org.jetbrains.annotations.Nullable;

public record Restriction<T extends Comparable<T>>(@Nullable T lowerBound, boolean lowerBoundInclusive, @Nullable T upperBound, boolean upperBoundInclusive) {

    public boolean contains(T thing) {
        if (this.lowerBound != null) {
            int comparison = this.lowerBound.compareTo(thing);
            if (comparison == 0 && !this.lowerBoundInclusive) {
                return false;
            }
            if (comparison > 0) {
                return false;
            }
        }
        if (this.upperBound != null) {
            int comparisonx = this.upperBound.compareTo(thing);
            return comparisonx == 0 && !this.upperBoundInclusive ? false : comparisonx >= 0;
        } else {
            return true;
        }
    }

    public String toFormattedString() {
        if (this.lowerBound == null && this.upperBound == null) {
            return "Any";
        } else if (this.lowerBound != null && this.upperBound == null) {
            return (this.lowerBoundInclusive ? "From " : "Greater than ") + this.lowerBound;
        } else if (this.lowerBound == null) {
            return (this.upperBoundInclusive ? "Up to " : "Less than ") + this.upperBound;
        } else {
            return this.lowerBound.equals(this.upperBound) ? "Only " + this.lowerBound : "Between " + this.lowerBound + (this.lowerBoundInclusive ? " (included)" : "") + " and " + this.upperBound + (this.upperBoundInclusive ? " (included)" : "");
        }
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        } else if (other instanceof Restriction<?> restriction) {
            if (this.lowerBound != null && !this.lowerBound.equals(restriction.lowerBound)) {
                return false;
            } else if (restriction.lowerBound != null) {
                return false;
            } else if (this.lowerBoundInclusive != restriction.lowerBoundInclusive) {
                return false;
            } else if (this.upperBound != null && !this.upperBound.equals(restriction.upperBound)) {
                return false;
            } else {
                return restriction.upperBound != null ? false : this.upperBoundInclusive == restriction.upperBoundInclusive;
            }
        } else {
            return false;
        }
    }

    public String toString() {
        StringBuilder buf = new StringBuilder();
        buf.append((char) (this.lowerBoundInclusive() ? '[' : '('));
        if (this.lowerBound() != null) {
            buf.append(this.lowerBound());
        }
        buf.append(',');
        if (this.upperBound() != null) {
            buf.append(this.upperBound());
        }
        buf.append((char) (this.upperBoundInclusive() ? ']' : ')'));
        return buf.toString();
    }
}