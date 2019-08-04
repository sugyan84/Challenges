package com.app.testCodes;

import java.util.Objects;


public class Hosting {

    private String bnaType;
    private String bnaId;

    public Hosting(final String bnaType, final String bnaId) {
        this.bnaType = bnaType;
        this.bnaId = bnaId;
    }

    public Hosting() {
    }

    @Override public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        final Hosting hosting = (Hosting) o;
        return bnaType.equals(hosting.bnaType) &&
                bnaId.equals(hosting.bnaId);
    }

    @Override public int hashCode() {
        return Objects.hash(bnaType, bnaId);
    }

    public String getBnaType() {
        return bnaType;
    }

    public void setBnaType(final String bnaType) {
        this.bnaType = bnaType;
    }

    public String getBnaId() {
        return bnaId;
    }

    public void setBnaId(final String bnaId) {
        this.bnaId = bnaId;
    }

    @Override public String toString() {
        return "{" +
                "bnaId='" + bnaId + '\'' +
                '}';
    }
}