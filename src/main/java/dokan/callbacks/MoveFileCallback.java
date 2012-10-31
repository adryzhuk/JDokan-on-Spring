package dokan.callbacks;

import com.sun.jna.Callback;
import com.sun.jna.WString;
import dokan.DokanFileInfo;

/**
 * @author: Vyacheslav.Bychkovsk
 */
public interface MoveFileCallback extends Callback {
    int invoke(WString existingFileName, WString newFileName, boolean replaceExisting, DokanFileInfo dokanFileInfo);
}
