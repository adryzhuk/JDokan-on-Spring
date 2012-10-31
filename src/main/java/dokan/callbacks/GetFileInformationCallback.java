package dokan.callbacks;

import com.sun.jna.Callback;
import com.sun.jna.WString;
import dokan.DokanFileInfo;
import win32.ByHandleFileInformation;

/**
 * @author: Vyacheslav.Bychkovsk
 */
public interface GetFileInformationCallback extends Callback {
    int invoke(WString fileName, ByHandleFileInformation info, DokanFileInfo dokanFileInfo);
}
