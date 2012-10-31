package dokan.callbacks;

import com.sun.jna.Callback;
import com.sun.jna.WString;
import dokan.DokanFileInfo;

/**
 * @author: Vyacheslav.Bychkovsk
 */
public interface CreateFileCallback extends Callback {

    public static int FLAG_BACKUP_SEMANTICS = 0x02000000;
    public static int FLAG_DELETE_ON_CLOSE = 0x04000000;
    public static int FLAG_NO_BUFFERING = 0x20000000;
    public static int FLAG_OPEN_NO_RECALL = 0x00100000;
    public static int FLAG_OPEN_REPARSE_POINT = 0x00200000;
    public static int FLAG_OVERLAPPED = 0x40000000;
    public static int FLAG_POSIX_SEMANTICS = 0x00100000;
    public static int FLAG_RANDOM_ACCESS = 0x10000000;
    public static int FLAG_SESSION_AWARE = 0x00800000;
    public static int FLAG_SEQUENTIAL_SCAN = 0x08000000;
    public static int FLAG_WRITE_THROUGH = 0x80000000;

    public static int ACCESS_GENERIC_ALL = 0x10000000;
    public static int ACCESS_GENERIC_READ = 0x80000000;
    public static int ACCESS_GENERIC_WRITE = 0x40000000;
    public static int ACCESS_GENERIC_EXECUTE = 0x20000000;

    public static int CREATE_NEW = 0x1;
    public static int CREATE_ALWAYS = 0x2;
    public static int OPEN_ALWAYS = 0x4;
    public static int OPEN_EXISTING = 0x3;
    public static int TRUNCATE_EXISTING = 0x5;

    public static int SHARE_DELETE = 0x4;
    public static int SHARE_READ = 0x1;
    public static int SHARE_WRITE = 0x2;

    int invoke(WString path, int desiredAccess, int shareMode, int creationDesposition, int flagsAndAttributes, DokanFileInfo dokanFileInfo);
}
