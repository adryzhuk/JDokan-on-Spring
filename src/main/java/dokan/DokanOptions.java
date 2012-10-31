package dokan;

import com.sun.jna.NativeLong;
import com.sun.jna.Structure;
import com.sun.jna.WString;

public class DokanOptions extends Structure {
    public static int DOKAN_OPTION_DEBUG = 1;
    public static int DOKAN_OPTION_STDERR = 2;
    public static int DOKAN_OPTION_ALT_STREAM = 4;
    public static int DOKAN_OPTION_KEEP_ALIVE = 8;
    public static int DOKAN_OPTION_NETWORK = 16;
    public static int DOKAN_OPTION_REMOVABLE = 32;

    public short version;
    public short threadCount;
    public NativeLong options;
    public long globalContext;
    public WString mountPoint;

    public static class Reference extends DokanOptions implements ByReference {
    }

    public DokanOptions() {
    }

    public DokanOptions(short version, short threadCount, NativeLong options, long globalContext, WString mountPoint) {
        this.version = version;
        this.threadCount = threadCount;
        this.options = options;
        this.globalContext = globalContext;
        this.mountPoint = mountPoint;
    }
}
