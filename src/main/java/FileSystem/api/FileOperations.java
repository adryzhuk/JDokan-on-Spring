package FileSystem.api;

import FileSystem.VirtualFile;
import com.sun.jna.WString;

import java.util.List;

/**
 * @author: Vyacheslav.Bychkovsk
 */
public interface FileOperations {

    File createFile(WString path, int flagsAndAttributes);

    boolean moveFile(WString existingPath, WString newPath, boolean replace);

    boolean fileExist(WString path);

    File deleteFileByPath(WString path);

    File getFile(WString path);

    File getFileByPath(String[] path);

    List<VirtualFile> getFiles();

    File delete();

    File deleteChild(VirtualFile virtualFile);

    public boolean flush(int flags);


}
