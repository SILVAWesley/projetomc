package ufcg.metodologia.projetomc.util;

/**
 * Created by Wesley Silva on 05/08/2017.
 */

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
