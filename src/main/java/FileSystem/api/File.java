package FileSystem.api;

import FileSystem.VirtualFile;
import com.sun.jna.Pointer;
import com.sun.jna.ptr.IntByReference;
import win32.Win32FindData;

import java.util.Date;


/**
 * @author: Vyacheslav.Bychkovsk
 */
public interface File {

    public static final int ATTRIBUTE_ARCHIVE = 0x20;
    public static final int ATTRIBUTE_ENCRYPTED = 0x4000;
    public static final int ATTRIBUTE_NORMAL = 0x80;
    public static final int ATTRIBUTE_DIRECTORY = 0x10;
    public static final int ATTRIBUTE_OFFLINE = 0x1000;
    public static final int ATTRIBUTE_READ_ONLY = 0x1;
    public static final int ATTRIBUTE_SYSTEM = 0x4;
    public static final int ATTRIBUTE_TEMPORARY = 0x100;
    public static final int ATTRIBUTE_HIDDEN = 0x2;
    public static final int ATTRIBUTE_NOT_CONTENT_INDEXED = 0x2000;
    public static final int MASK = ATTRIBUTE_ARCHIVE | ATTRIBUTE_HIDDEN | ATTRIBUTE_NORMAL | ATTRIBUTE_NOT_CONTENT_INDEXED | ATTRIBUTE_OFFLINE | ATTRIBUTE_READ_ONLY | ATTRIBUTE_SYSTEM | ATTRIBUTE_TEMPORARY;


    boolean read(Pointer readBuf, long offset, int bufferLen, IntByReference bytesRead);

    boolean write(Pointer writeBuf, long offset, int bytesToWrite, IntByReference bytesWritten);

    boolean isReadOnly();

    String getName();

    String getAlternativeName();

    long getSize();

    long getUsedSpace();

    Date getLastWriteTime();

    Date getLastAccessTime();

    Date getCreationTime();

    int getFlagsAndAttributes();

    void setFlagsAndAttributes(int flagsAndAttributes);

    void setLastAccessTime(Date lastAccessTime);

    void setCreationTime(Date creationTime);

    void setLastWriteTime(Date lastWriteTime);

    void setAlternativeName(String alternativeName) ;

    void setName(String name);

    public boolean isDirectory();

    Win32FindData getWin32FindData();

    boolean setEOF(long length);


    File getParent();

    void setParent(VirtualFile parent);

}
