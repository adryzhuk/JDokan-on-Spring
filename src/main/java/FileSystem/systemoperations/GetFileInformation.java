package FileSystem.systemoperations;

import FileSystem.VirtualFile;
import FileSystem.VirtualVolume;
import com.sun.jna.WString;
import com.sun.jna.platform.win32.WinBase;
import dokan.DokanFileInfo;
import dokan.callbacks.CommonCalback;
import dokan.callbacks.GetFileInformationCallback;
import win32.ByHandleFileInformation;

/**
 * @author: Vyacheslav.Bychkovsk
 */
public class GetFileInformation implements GetFileInformationCallback,CommonCalback {
    private VirtualVolume volume;

    @Override
    public int invoke(WString fileName, ByHandleFileInformation info, DokanFileInfo dokanFileInfo) {
        VirtualFile file = (VirtualFile) root.getFile(fileName);
        if (file == null) {
            return -ERROR_FILE_NOT_FOUND;
        }
        info.attributes = file.getFlagsAndAttributes();
        info.creationTime = new WinBase.FILETIME(file.getCreationTime());
        info.lastAccessTime = new WinBase.FILETIME(file.getLastAccessTime());
        info.lastWriteTime = new WinBase.FILETIME(file.getLastWriteTime());
        info.fileSizeHigh = (int) (file.getSize() >>> 32);
        info.fileSizeLow = (int) (file.getSize());
        info.numberOfLinks = 1;
        info.volumeSerialNumber = volume.getSerialNumber();

        return ERROR_SUCCESS;
    }

    public void setVolume(VirtualVolume volume){
        this.volume = volume;

    }
}
