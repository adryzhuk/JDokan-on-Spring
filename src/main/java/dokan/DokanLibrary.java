package dokan;

import com.sun.jna.*;
import ua.com.infopulse.javadokan.win.Win32FindData;

public interface DokanLibrary extends Library {
    public static final String JNA_LIBRARY_NAME = "dokan";
    public static final NativeLibrary JNA_NATIVE_LIB = NativeLibrary.getInstance(DokanLibrary.JNA_LIBRARY_NAME);
    public static final DokanLibrary INSTANCE = (DokanLibrary) Native.loadLibrary(DokanLibrary.JNA_LIBRARY_NAME, DokanLibrary.class);

    public static final int DOKAN_VERSION = 600;

    public static final int DOKAN_SUCCESS = 0;
    public static final int DOKAN_OPTION_STDERR = 2;
    public static final int DOKAN_OPTION_KEEP_ALIVE = 8;
    public static final int DOKAN_OPTION_ALT_STREAM = 4;
    public static final int DOKAN_OPTION_NETWORK = 16;
    public static final int DOKAN_OPTION_REMOVABLE = 32;

    public static final int DOKAN_ERROR = -1;
    public static final int DOKAN_DRIVE_LETTER_ERROR = -2;
    public static final int DOKAN_DRIVER_INSTALL_ERROR = -3;
    public static final int DOKAN_START_ERROR = -4;
    public static final int DOKAN_MOUNT_ERROR = -5;
    public static final int DOKAN_MOUNT_POINT_ERROR = -6;

    public interface FillFindDataCallback extends Callback {
        int invoke(Win32FindData findData, DokanFileInfo pDokanFileInfo);
    }

    int DokanMain(DokanOptions dokanOptions, DokanOperations dokanOperations);

    boolean DokanUnmount(String driveLetter);

    boolean DokanRemoveMountPoint(String mountPoint);

    boolean DokanIsNameInExpression(String expression, String name, boolean ignoreCase);

    long DokanVersion();

    NativeLong DokanDriverVersion();

    boolean DokanResetTimeout(NativeLong Timeout, DokanFileInfo dokanFileInfo);

    int DokanOpenRequestorToken(DokanFileInfo dokanFileInfo);
}
