package FileSystem;

import dokan.DokanOperations;
import dokan.callbacks.CleanupCallback;
import dokan.callbacks.CreateFileCallback;

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
}
