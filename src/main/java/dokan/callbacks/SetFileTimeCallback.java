package dokan.callbacks;

import com.sun.jna.Callback;
import com.sun.jna.WString;
import com.sun.jna.platform.win32.WinBase;
import dokan.DokanFileInfo;

/**
 * @author: Vyacheslav.Bychkovsk
 */
public interface SetFileTimeCallback extends Callback {
    int invoke(WString fileName, WinBase.FILETIME creationTime, WinBase.FILETIME lastAccessTime, WinBase.FILETIME lastWriteTime, DokanFileInfo dokanFileInfo);
}
