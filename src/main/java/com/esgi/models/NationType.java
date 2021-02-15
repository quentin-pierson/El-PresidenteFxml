package com.esgi.models;

import com.esgi.models.Calamities.SeasonType;

import java.util.HashMap;
import java.util.Map;

public enum NationType {
    treasury(0),
    industry(1),
    agriculture(2),
    communism(3),
    capitalist(4),
    liberals(5),
    religious(6),
    militarist(7),
    environmentalist(8),
    nationalist(9),
    loyalist(10),
    royalist(11),
    feminism(12);

    private int value;
    private static Map map = new HashMap<>();

    private NationType(int value) {
        this.value = value;
    }

    static {
        for (NationType pageType : NationType.values()) {
            map.put(pageType.value, pageType);
        }
    }

    public static NationType valueOf(int pageType) {
        return (NationType) map.get(pageType);
    }

    public int getValue() {
        return value;
    }
}
