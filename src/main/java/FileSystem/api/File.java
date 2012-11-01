package FileSystem.api;

import com.sun.jna.Pointer;
import com.sun.jna.ptr.IntByReference;
import win32.Win32FindData;

import java.util.Date;


/**
 * @author: Vyacheslav.Bychkovsk
 */
public interface File {

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

}
