package dokan.callbacks;

import com.sun.jna.Callback;
import com.sun.jna.WString;
import dokan.DokanFileInfo;

/**
 * @author: Vyacheslav.Bychkovsk
 */
public interface OpenDirectoryCallback extends Callback {
    int invoke(WString fileName, DokanFileInfo dokanFileInfo);
}
