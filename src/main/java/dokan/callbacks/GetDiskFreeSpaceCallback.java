package dokan.callbacks;

import com.sun.jna.Callback;
import com.sun.jna.ptr.LongByReference;
import dokan.DokanFileInfo;

/**
 * @author: Vyacheslav.Bychkovsk
 */
public interface GetDiskFreeSpaceCallback extends Callback {
    int invoke(LongByReference freeBytesAvailable, LongByReference totalNumbersOfBytes, LongByReference totalNumberOfFreeBytes, DokanFileInfo dokanFileInfo);
}
