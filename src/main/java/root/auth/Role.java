package root.auth;

import java.util.EnumSet;

public enum Role {
    ANONYMOUSE(-1), CUSTOMER(0), ADMINISTRATOR(63);

    private final long code;

    private Role(int bit) {
        if (bit >= 0) {
            code = 1L << bit;
        } else {
            code = 0;
        }
    }

    public long getCode() {
        return code;
    }

    public static EnumSet<Role> set(long bits) {
        EnumSet<Role> ret = EnumSet.noneOf(Role.class);
        for (Role role : Role.values()) {
            if (role == ANONYMOUSE) {
            } else if ((bits & role.getCode()) == role.getCode()) {
                ret.add(role);
            }
        }
        return ret;
    }
}
