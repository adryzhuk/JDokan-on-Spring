package dokan.callbacks;

import com.sun.jna.Callback;
import com.sun.jna.WString;
import dokan.DokanFileInfo;

/**
 * @author: Vyacheslav.Bychkovsk
 */
public interface SetEndOfFileCallback extends Callback {
    int invoke(WString fileName, long length, DokanFileInfo dokanFileInfo);
}
