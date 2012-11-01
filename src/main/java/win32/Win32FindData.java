package win32;

import com.sun.jna.Structure;
import com.sun.jna.platform.win32.WinBase.FILETIME;

public class Win32FindData extends Structure {
    public int fileAttributes;
    public FILETIME creationTime;
    public FILETIME lastAccess;
    public FILETIME lastWrite;
    public int sizeHigh;
    public int sizeLow;
    public int reserved1;
    public int reserved2;
    public byte[] fileName = new byte[255 * 2]; //MAGIC;
    public byte[] alternativeFileName = new byte[14 * 2];

    public Win32FindData() {
        super();
        setFieldOrder(new String[]{
                "fileAttributes",
                "creationTime",
                "lastAccess",
                "lastWrite",
                "sizeHigh",
                "sizeLow",
                "reserved1",
                "reserved2",
                "fileName",
                "alternativeFileName"
        });
    }
}
