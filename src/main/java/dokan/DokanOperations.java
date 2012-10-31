package dokan;

import com.sun.jna.*;
import dokan.callbacks.*;

public class DokanOperations extends Structure {

    public CreateFileCallback createFileCallback;
    public OpenDirectoryCallback openDirectoryCallback;
    public CreateDirectoryCallback createDirectoryCallback;
    public CleanupCallback cleanupCallback;
    public CloseFileCallback closeFileCallback;
    public ReadFileCallback readFileCallback;
    public WriteFileCallback writeFileCallback;
    public FlushFileBuffersCallback flushFileBuffersCallback;
    public GetFileInformationCallback getFileInformationCallback;
    public FindFilesCallback findFilesCallback;
    public FindFilesWithPatternCallback findFilesWithPatternCallback;
    public SetFileAttributesCallback setFileAttributesCallback;
    public SetFileTimeCallback setFileTimeCallback;
    public DeleteFileCallback deleteFileCallback;
    public DeleteDirectoryCallback deleteDirectoryCallback;
    public MoveFileCallback moveFileCallback;
    public SetEndOfFileCallback setEndOfFileCallback;
    public SetAllocationSizeCallback setAllocationSizeCallback;
    public LockFileCallback lockFileCallback;
    public UnlockFileCallback unlockFileCallback;
    public GetDiskFreeSpaceCallback getDiskFreeSpaceCallback;
    public GetVolumeInformationCallback getVolumeInformationCallback;
    public UnmountCallback unmountCallback;
    public GetFileSecurityCallback getFileSecurityCallback;
    public SetFileSecurityCallback setFileSecurityCallback;

    public DokanOperations() {
        setFieldOrder(new String[]{
                "createFileCallback",
                "openDirectoryCallback",
                "createDirectoryCallback",
                "cleanupCallback",
                "closeFileCallback",
                "readFileCallback",
                "writeFileCallback",
                "flushFileBuffersCallback",
                "getFileInformationCallback",
                "findFilesCallback",
                "findFilesWithPatternCallback",
                "setFileAttributesCallback",
                "setFileTimeCallback",
                "deleteFileCallback",
                "deleteDirectoryCallback",
                "moveFileCallback",
                "setEndOfFileCallback",
                "setAllocationSizeCallback",
                "lockFileCallback",
                "unlockFileCallback",
                "getDiskFreeSpaceCallback",
                "getVolumeInformationCallback",
                "unmountCallback",
                "getFileSecurityCallback",
                "setFileSecurityCallback"
        });
    }
}
