package com.mani.rc;

import java.util.Objects;

public class TimeEntity {

    private final int remainSeconds;

    public TimeEntity(int remainSeconds) {
        this.remainSeconds = remainSeconds;
    }

    public int remainSeconds() {
        return remainSeconds;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof TimeEntity)) return false;
        TimeEntity that = (TimeEntity) o;
        return remainSeconds == that.remainSeconds;
    }

    @Override
    public int hashCode() {
        return Objects.hash(remainSeconds);
    }

    public String desc() {
        return "remain:" + remainSeconds;
    }
}
