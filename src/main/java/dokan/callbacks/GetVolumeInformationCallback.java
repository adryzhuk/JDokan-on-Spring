package dokan.callbacks;

import com.sun.jna.Callback;
import com.sun.jna.Pointer;
import com.sun.jna.ptr.IntByReference;
import dokan.DokanFileInfo;

/**
 * @author: Vyacheslav.Bychkovsk
 */
public interface GetVolumeInformationCallback extends Callback {
    int invoke(Pointer volumeNameBuffer, int volumeNameSize, IntByReference volumeSerialNumber, IntByReference maximumComponentLength, IntByReference fileSystemFlags, Pointer fileSystemNameBuffer, int fileSystemNameSize, DokanFileInfo dokanFileInfo);
}
