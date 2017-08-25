package ufcg.metodologia.projetomc.util;

public enum SortOrder {
    ASCENDING(true), DESCENDING(false), NONE(true);

    private boolean value;

    private SortOrder(boolean value) {
        this.value = value;
    }

    public boolean getValue() {
        return value;
    }
}
