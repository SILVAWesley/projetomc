package ufcg.metodologia.projetomc.util;

public class Range {
    private int beginIndex;
    private int endIndex;
    private int midIndex;

    public Range(int beginIndex, int endIndex) {
        this.beginIndex = beginIndex;
        this.endIndex = endIndex;
    }

    public Range(int beginIndex, int midIndex, int endIndex) {
        this.beginIndex = beginIndex;
        this.midIndex = midIndex;
        this.endIndex = endIndex;
    }

    public int getBeginIndex() {
        return beginIndex;
    }

    public int getEndIndex() {
        return endIndex;
    }

    public int getMidIndex() {
        return midIndex;
    }
}
