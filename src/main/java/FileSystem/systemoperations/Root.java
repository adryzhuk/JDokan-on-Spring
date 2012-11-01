package FileSystem.systemoperations;

import FileSystem.VirtualFile;
import FileSystem.api.File;

/**
 * @author: Vyacheslav.Bychkovsk
 */
public interface Root {
    public static final VirtualFile root = new VirtualFile("\\",File.ATTRIBUTE_DIRECTORY);
}
