package com.mani.rc;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class DataRepo {
    public static final long NONE = 0;
    public static final long ONE_SECOND = 1;
    public static final long ONE_MINUTE = 60;
    public static final long ONE_HOUR = ONE_MINUTE * 60;
    public static final long ONE_DAY = ONE_HOUR * 24;
    public static final long ONE_MONTH = ONE_DAY * 30;
    public static final long ONE_YEAR = ONE_MONTH * 12;

    public static List<Long> diff() {
        return Arrays.asList(
                ONE_YEAR,
                ONE_MINUTE,
                NONE,
                ONE_DAY,
                ONE_SECOND,
                ONE_HOUR,
                ONE_MONTH, ONE_YEAR,
                ONE_MINUTE,
                NONE,
                ONE_DAY,
                ONE_SECOND,
                ONE_HOUR,
                ONE_MONTH,
                ONE_YEAR,
                ONE_MINUTE,
                NONE,
                ONE_DAY,
                ONE_SECOND,
                ONE_HOUR,
                ONE_MONTH,
                ONE_YEAR,
                ONE_MINUTE,
                NONE,
                ONE_DAY,
                ONE_SECOND,
                ONE_HOUR,
                ONE_MONTH,
                NONE,
                NONE,
                NONE,
                NONE,
                NONE,
                NONE,
                NONE,
                NONE,
                NONE,
                NONE,
                NONE,
                NONE,
                NONE,
                NONE,
                NONE,
                NONE,
                NONE,
                NONE,
                NONE,
                NONE,
                NONE,
                NONE,
                NONE,
                NONE,
                NONE,
                NONE,
                NONE,
                NONE,
                NONE,
                NONE,
                NONE,
                NONE,
                NONE,
                NONE,
                NONE,
                NONE,
                NONE,
                NONE,
                NONE,
                NONE,
                NONE,
                NONE,
                NONE,
                NONE,
                NONE,
                NONE,
                NONE,
                NONE,
                NONE,
                NONE,
                NONE,
                NONE,
                NONE,
                NONE,
                NONE,
                NONE,
                NONE,
                NONE,
                NONE,
                NONE,
                NONE,
                NONE,
                NONE,
                NONE,
                NONE,
                NONE,
                NONE,
                NONE,
                NONE,
                NONE,
                NONE,
                NONE,
                NONE,
                NONE,
                NONE,
                NONE,
                NONE,
                NONE,
                NONE,
                NONE,
                NONE,
                NONE,
                NONE,
                NONE,
                NONE,
                NONE,
                NONE,
                NONE,
                NONE,
                NONE,
                NONE,
                NONE,
                NONE,
                NONE,
                NONE,
                NONE,
                NONE,
                NONE,
                NONE,
                NONE,
                NONE,
                NONE,
                NONE,
                NONE,
                NONE,
                NONE,
                NONE,
                NONE,
                NONE,
                NONE,
                NONE,
                NONE,
                NONE,
                NONE,
                NONE,
                NONE,
                NONE,
                NONE,
                NONE,
                NONE,
                NONE,
                NONE,
                NONE,
                NONE,
                NONE,
                NONE,
                NONE,
                NONE
        );
    }

    public static List<Long> shift(List<Long> diff) {
        List<Long> result = new ArrayList<>(diff.size());
        for (Long second : diff) {
            result.add(second * 1000 + 1553394032000L);//Saturday, March 23, 2019 7:10:38 PM GMT-07:00

        }
        return result;

    }
}
