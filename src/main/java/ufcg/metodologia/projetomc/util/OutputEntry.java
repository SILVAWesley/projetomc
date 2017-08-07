package ufcg.metodologia.projetomc.util;

/**
 * Created by Wesley Silva on 06/08/2017.
 */

public class OutputEntry {
    private String input;
    private String algorithm;
    private String order;
    private long executionTime;
    private int replication;

    public OutputEntry(String input, String algorithm, String order, long executionTime, int replication) {
        this.input = input;
        this.algorithm = algorithm;
        this.order = order;
        this.executionTime = executionTime;
        this.replication = replication;
    }

    public String getInput() {
        return input;
    }

    public String getAlgorithm() {
        return algorithm;
    }

    public String getOrder() {
        return order;
    }

    public long getExecutionTime() {
        return executionTime;
    }

    public int getReplication() {
        return replication;
    }
}
