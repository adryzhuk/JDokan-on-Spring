package FileSystem.systemoperations;

import FileSystem.VirtualVolume;
import com.sun.jna.Pointer;
import com.sun.jna.ptr.IntByReference;
import dokan.DokanFileInfo;
import dokan.callbacks.CommonCalback;
import dokan.callbacks.GetVolumeInformationCallback;

/**
 * @author: Vyacheslav.Bychkovsk
 */
public class GetVolumeInformation implements CommonCalback, GetVolumeInformationCallback {
    private VirtualVolume volume;
    @Override
    public int invoke(Pointer volumeNameBuffer, int volumeNameSize, IntByReference volumeSerialNumber, IntByReference maximumComponentLength, IntByReference fileSystemFlags, Pointer fileSystemNameBuffer, int fileSystemNameSize, DokanFileInfo dokanFileInfo) {
        volumeNameBuffer.setString(0, volume.getName() + "\0", true);
        volumeSerialNumber.setValue(volume.getSerialNumber());
        maximumComponentLength.setValue(volume.getMaximumComponentLength());
        fileSystemFlags.setValue(volume.getFileSystemFlags());
        fileSystemNameBuffer.setString(0, volume.getFileSystemName() + "\0", true);
        return ERROR_SUCCESS;
    }

    public void setVolume(VirtualVolume volume){
        this.volume = volume;
    }
}
