package ufcg.metodologia.projetomc.util;

/**
 * Created by Wesley Silva on 06/08/2017.
 */

public class OutputEntry {
    private String algorithm;
    private int numElements;
    private String order;
    private long executionTime;
    private int replication;

    public OutputEntry(String algorithm, int numElements, String order, long executionTime, int replication) {
        this.algorithm = algorithm;
        this.order = order;
        this.executionTime = executionTime;
        this.numElements = numElements;
        this.replication = replication;
    }

    public String getAlgorithm() {
        return algorithm;
    }
    
    public int getNumElements() {
    	return numElements;
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
