package dokan.callbacks;

import com.sun.jna.Callback;
import com.sun.jna.Pointer;
import com.sun.jna.WString;
import com.sun.jna.ptr.IntByReference;
import dokan.DokanFileInfo;

public interface WriteFileCallback extends Callback {
    int invoke(WString fileName, Pointer buffer, int numberOfBytesToWrite, IntByReference numberOfBytesWritten, long offset, DokanFileInfo dokanFileInfo);
}


