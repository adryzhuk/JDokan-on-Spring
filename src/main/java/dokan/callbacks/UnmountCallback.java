package dokan.callbacks;

import com.sun.jna.Callback;
import dokan.DokanFileInfo;

/**
 * @author: Vyacheslav.Bychkovsk
 */
public interface UnmountCallback extends Callback {
    int invoke(DokanFileInfo dokanFileInfo);
}
