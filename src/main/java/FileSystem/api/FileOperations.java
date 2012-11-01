package FileSystem.api;

import FileSystem.VirtualFile;
import com.sun.jna.WString;

/**
 * @author: Vyacheslav.Bychkovsk
 */
public interface FileOperations {

    public File createFile(WString path, int flagsAndAttributes);

}
