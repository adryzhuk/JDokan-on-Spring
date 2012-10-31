package dokan.callbacks;

import com.sun.jna.Callback;
import com.sun.jna.WString;
import dokan.DokanFileInfo;

/**
 * @author: Vyacheslav.Bychkovsk
 */
public interface DeleteDirectoryCallback extends Callback {
    int invoke(WString path, DokanFileInfo dokanFileInfo);
}
