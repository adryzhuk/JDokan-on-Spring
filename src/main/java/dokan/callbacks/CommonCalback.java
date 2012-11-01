package dokan.callbacks;

import FileSystem.VirtualFile;
import FileSystem.api.File;

/**
 * @author: Vyacheslav.Bychkovsk
 */
public interface CommonCalback {
        public static final int ERROR_ALREADY_EXISTS = 183;
        public static final int ERROR_FILE_EXISTS = 80;
        public static final int ERROR_ACCESS_DENIED = 5;
        public static final int ERROR_TOO_MANY_OPEN_FILES = 4;
        public static final int ERROR_FILE_NOT_FOUND = 2;
        public static final int ERROR_PATH_NOT_FOUND = 3;
        public static final int ERROR_SUCCESS = 0;
        public static final int ERROR_GENERAL_ERROR = 1;

        public static final int GENERIC_READ = 0x80_00_00_00;
        public static final int GENERIC_WRITE = 0x40_00_00_00;
        public static final int GENERIC_EXECUTE = 0x20_00_00_00;
        public static final int GENERIC_ALL = 0x10_00_00_00;
        public static final int FILE_WRITE_DATA = 2;
        public static final int FILE_LIST_DIRECTORY = 1;
        public static final int FILE_READ_DATA = 1;
        public static final int FILE_READ_ATTRIBUTES = 128;

        public static final VirtualFile root = new VirtualFile("root",File.ATTRIBUTE_DIRECTORY);
}
