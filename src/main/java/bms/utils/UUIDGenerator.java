package bms.utils;

import com.google.common.base.CharMatcher;
import java.util.UUID;

public class UUIDGenerator {
    public static String getUuid() {
        UUID uuid = UUID.randomUUID();
        return CharMatcher.is('-').removeFrom(uuid.toString());
    }
}

