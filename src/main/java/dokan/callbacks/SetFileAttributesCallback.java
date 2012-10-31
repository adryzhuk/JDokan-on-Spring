package dokan.callbacks;

import com.sun.jna.Callback;
import com.sun.jna.WString;
import dokan.DokanFileInfo;

/**
 * @author: Vyacheslav.Bychkovsk
 */
public interface SetFileAttributesCallback extends Callback {
    int invoke(WString fileName, int fileAttributes, DokanFileInfo dokanFileInfo);
}
