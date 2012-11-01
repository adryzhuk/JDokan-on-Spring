package common;

import com.sun.jna.NativeLong;

/**
 * @author: Vyacheslav.Bychkovsk
 */
public class Is {
    public static Bits in(long param) { return new Bits(param); }
    public static Bits in(NativeLong param) { return new Bits(param); }

    public static class Bits {
        private long container;
        private boolean compare(long param) { return (container & param) != 0; }
        public boolean set(NativeLong param) { return compare(param.longValue()); }
        public boolean set(long param) { return compare(param); }

        private Bits(long data) { this.container = data; }
        private Bits(NativeLong data) { this.container = data.longValue(); }
    }
}
