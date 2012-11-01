package FileSystem.systemoperations;

import com.sun.jna.WString;
import dokan.DokanFileInfo;
import dokan.callbacks.CommonCalback;
import dokan.callbacks.FlushFileBuffersCallback;

/**
 * @author: Vyacheslav.Bychkovsk
 */
public class FlushBuffers implements CommonCalback,Root,FlushFileBuffersCallback {
    @Override
    public int invoke(WString fileName, DokanFileInfo dokanFileInfo) {
        return ERROR_SUCCESS;
    }
}
