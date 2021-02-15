package com.esgi.models.Calamities;

import java.util.HashMap;
import java.util.Map;

public enum SeasonType {
    spring(0),
    summer(1),
    autumn(2),
    winter(3);

    private int value;
    private static Map map = new HashMap<>();

    private SeasonType(int value) {
        this.value = value;
    }

    static {
        for (SeasonType pageType : SeasonType.values()) {
            map.put(pageType.value, pageType);
        }
    }

    public static SeasonType valueOf(int pageType) {
        return (SeasonType) map.get(pageType);
    }

    public int getValue() {
        return value;
    }
}
