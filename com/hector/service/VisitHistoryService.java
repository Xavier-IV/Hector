package com.hector.service;

public class VisitHistoryService {
    private int counter = 0;

    public int nextVal() {
        int current = this.counter;
        this.counter += 1;
        return current;
    }
}
