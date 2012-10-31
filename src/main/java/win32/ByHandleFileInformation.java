package win32;

import com.sun.jna.Structure;
import com.sun.jna.platform.win32.WinBase.FILETIME;

public class ByHandleFileInformation extends Structure {
    public int attributes;
    public FILETIME creationTime;
    public FILETIME lastAccessTime;
    public FILETIME lastWriteTime;
    public int volumeSerialNumber;
    public int fileSizeHigh;
    public int fileSizeLow;
    public int numberOfLinks;
    public int fileIndexHigh;
    public int fileIndexLow;

    @Override
    protected void setFieldOrder(String[] fields) {
        super.setFieldOrder(new String[]{
                "attributes",
                "creationTime",
                "lastAccessTime",
                "lastWriteTime",
                "volumeSerialNumber",
                "fileSizeHigh",
                "fileSizeLow",
                "numberOfLinks",
                "fileIndexHigh",
                "fileIndexLow"
        });    //To change body of overridden methods use File | Settings | File Templates.
    }
}
