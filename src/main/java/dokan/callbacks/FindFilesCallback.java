package dokan.callbacks;

import com.sun.jna.Callback;
import com.sun.jna.WString;
import dokan.DokanFileInfo;
import dokan.DokanLibrary;

import java.io.UnsupportedEncodingException;

/**
 * @author: Vyacheslav.Bychkovsk
 */
public interface FindFilesCallback extends Callback {
    int invoke(WString path, DokanLibrary.FillFindDataCallback fillFindDataCallback, DokanFileInfo dokanFileInfo) throws UnsupportedEncodingException;
}
