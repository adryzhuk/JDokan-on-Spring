package FileSystem;

import FileSystem.api.File;
import com.sun.jna.NativeLong;
import com.sun.jna.WString;
import dokan.DokanOptions;
import dokan.callbacks.CommonCalback;

/**
 * @author: Vyacheslav.Bychkovsk
 */

public class VirtualVolume extends DokanOptions{
    private String mountPoint;
    private String volumeName;
    private String fileSystemName;
    private int maximumComponentLength;
    private int volumeSerialNumber;
    private int fileSystemFlags;
    private long size;
    private long freeSize;

    private VirtualFile root = CommonCalback.root;

    public static int FILE_UNICODE_ON_DISK = 0x4;
    public static int FILE_CASE_PRESERVED_NAMES = 0x2;
    public static int FILE_PERSISTENT_ACLS = 0x8;

    public VirtualVolume(){
        this("R","DokanFS",1,255);
    }

    public VirtualVolume(String mountPoint, String fileSystemName, long size, int maximumComponentLength) {

        super((short)600, (short)0, new NativeLong(DOKAN_OPTION_REMOVABLE), 0L, new WString(mountPoint));

        this.mountPoint = mountPoint;

        this.fileSystemName = fileSystemName;

        this.maximumComponentLength = maximumComponentLength;

        this.size = size <<33;

        this.freeSize = size;

        this.setFileSystemFlags(VirtualVolume.FILE_UNICODE_ON_DISK | VirtualVolume.FILE_CASE_PRESERVED_NAMES);
    }

    public String getName() {
        return volumeName;
    }

    public VirtualFile getRoot() {
        return root;
    }

    public String getFileSystemName() {
        return fileSystemName;
    }

    public String getMountPoint() {
        return mountPoint;
    }

    public int getFileSystemFlags() {
        return fileSystemFlags;
    }

    public int getSerialNumber() {
        return volumeSerialNumber;
    }

    public int getMaximumComponentLength() {
        return maximumComponentLength;
    }

    public void setFileSystemFlags(int fileSystemFlags) {
        this.fileSystemFlags = fileSystemFlags;
    }

    public void setSerialNumber(int volumeSerialNumber) {
        this.volumeSerialNumber = volumeSerialNumber;
    }

    public void setName(String volumeName) {
        this.volumeName = volumeName;
    }

    public long getFreeSize() {
        freeSize = size - root.getUsedSpace();
        return freeSize;
    }

    public long getSize() {
        return size;
    }
}


