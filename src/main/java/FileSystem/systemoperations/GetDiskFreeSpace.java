package FileSystem.systemoperations;

import FileSystem.VirtualVolume;
import com.sun.jna.ptr.LongByReference;
import dokan.DokanFileInfo;
import dokan.callbacks.CommonCalback;
import dokan.callbacks.GetDiskFreeSpaceCallback;

/**
 * @author: Vyacheslav.Bychkovsk
 */
public class GetDiskFreeSpace implements GetDiskFreeSpaceCallback,CommonCalback {
    VirtualVolume volume;
    public GetDiskFreeSpace(){

    }
    @Override
    public int invoke(LongByReference freeBytesAvailable, LongByReference totalNumbersOfBytes, LongByReference totalNumberOfFreeBytes, DokanFileInfo dokanFileInfo) {
        freeBytesAvailable.setValue(volume.getFreeSize());
        totalNumbersOfBytes.setValue(volume.getSize());
        totalNumberOfFreeBytes.setValue(volume.getFreeSize());
        return ERROR_SUCCESS;
    }
    public void setVolume(VirtualVolume volume){
        this.volume = volume;

    }
}
