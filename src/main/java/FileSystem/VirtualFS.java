package FileSystem;

import dokan.DokanOperations;
import dokan.callbacks.*;

/**
 * @author: Vyacheslav.Bychkovsk
 */
public class VirtualFS extends DokanOperations {

    public VirtualFS(){
        super();
    }

    public void setCreateFile(CreateFileCallback createFile){
        this.createFileCallback = createFile;
    }

    public void setCleanup(CleanupCallback cleanup){
        this.cleanupCallback = cleanup;
    }

    public void setCloseFile(CloseFileCallback closeFile){
        this.closeFileCallback = closeFile;
    }

    public void setCreateDirectory(CreateDirectoryCallback createDirectory){
        this.createDirectoryCallback = createDirectory;
    }

    public void setDeleteDirectory(DeleteDirectoryCallback deleteDirectory){
        this.deleteDirectoryCallback = deleteDirectory;
    }

    public void setDeleteFile(DeleteFileCallback deleteFile){
        this.deleteFileCallback = deleteFile;
    }

    public void setFindFiles(FindFilesCallback findFiles){
        this.findFilesCallback = findFiles;
    }

    public void setFlushBuffers(FlushFileBuffersCallback flushBuffers){
        this.flushFileBuffersCallback = flushBuffers;
    }

    public void setGetDiskFreeSpace(GetDiskFreeSpaceCallback getDiskFreeSpace){
        this.getDiskFreeSpaceCallback = getDiskFreeSpace;
    }

    public void setGetFileInformation(GetFileInformationCallback fileInformation){
        this.getFileInformationCallback = fileInformation;
    }

    public void setGetVolumeInformation(GetVolumeInformationCallback volumeInformation){
        this.getVolumeInformationCallback = volumeInformation;
    }

    public void setMoveFile(MoveFileCallback moveFile){
        this.moveFileCallback = moveFile;
    }

    public void setOpenDirectory(OpenDirectoryCallback openDirectory){
        this.openDirectoryCallback = openDirectory;
    }

    public void setReadFile(ReadFileCallback readFile){
        this.readFileCallback = readFile;
    }

    public void setAllocationSize(SetAllocationSizeCallback setAllocationSizeCallback){
        this.setAllocationSizeCallback = setAllocationSizeCallback;
    }

    public void setEndOfFile(SetEndOfFileCallback setEndOfFileCallback){
        this.setEndOfFileCallback = setEndOfFileCallback;
    }

    public void setFileAttributes(SetFileAttributesCallback setFileAttributesCallback){
        this.setFileAttributesCallback = setFileAttributesCallback;
    }

    public void setFileTimes(SetFileTimeCallback setFileTimeCallback){
        this.setFileTimeCallback = setFileTimeCallback;
    }

    public void setUnmount(UnmountCallback unmount){
        this.unmountCallback = unmount;
    }

    public void setWrite(WriteFileCallback write){
        this.writeFileCallback = write;
    }


}
