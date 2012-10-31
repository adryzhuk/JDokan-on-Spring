package dokan.callbacks;

import com.sun.jna.Callback;
import com.sun.jna.WString;
import dokan.DokanFileInfo;

/**
 * @author: Vyacheslav.Bychkovsk
 */
public interface FlushFileBuffersCallback extends Callback {
    int invoke(WString fileName, DokanFileInfo dokanFileInfo);
}
