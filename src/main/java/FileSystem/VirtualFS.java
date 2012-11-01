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
}
