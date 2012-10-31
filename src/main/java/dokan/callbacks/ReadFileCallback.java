package dokan.callbacks;

import com.sun.jna.Callback;
import com.sun.jna.Pointer;
import com.sun.jna.WString;
import com.sun.jna.ptr.IntByReference;
import dokan.DokanFileInfo;

/**
 * @author: Vyacheslav.Bychkovsk
 */
public interface ReadFileCallback extends Callback {
    int invoke(WString fileName, Pointer buffer, int numberOfBytesToRead, IntByReference numberOfBytesRead, long offset, DokanFileInfo dokanFileInfo);
}
