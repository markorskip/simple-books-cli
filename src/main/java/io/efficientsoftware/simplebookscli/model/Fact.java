package io.efficientsoftware.simplebookscli.model;

import java.util.Objects;

public class Fact extends Event {

    private final String key;
    private final String value;

    public Fact(String key, String value) {
        this.key = key;
        this.value = value;
    }

    public Fact(String[] csv) {
        this.key = csv[1];
        this.value = csv[2];
    }

    public String getKey() {
        return key;
    }

    public String getValue() {
        return value;
    }

    @Override
    public String toCSV() {
        return EVENT_TYPE.KEY_VALUE.toString() + "," + key+ "," +
                value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Fact that = (Fact) o;
        return Objects.equals(key, that.key);
    }

    @Override
    public int hashCode() {
        return Objects.hash(key);
    }
}
