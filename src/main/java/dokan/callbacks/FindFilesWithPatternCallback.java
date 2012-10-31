package dokan.callbacks;

import com.sun.jna.Callback;
import com.sun.jna.WString;
import dokan.DokanFileInfo;
import dokan.DokanLibrary;

/**
 * @author: Vyacheslav.Bychkovsk
 */
public interface FindFilesWithPatternCallback extends Callback {
    int invoke(WString pathName, WString searchPattern, DokanLibrary.FillFindDataCallback fillFindDataCallback, DokanFileInfo dokanFileInfo);
}
