package FileSystem.systemoperations;

import FileSystem.VirtualFile;
import com.sun.jna.WString;
import common.Is;
import dokan.DokanFileInfo;
import dokan.callbacks.CommonCalback;
import dokan.callbacks.CreateFileCallback;

/**
 * @author: Vyacheslav.Bychkovsk
 */
class CreateFile implements CreateFileCallback,Root,CommonCalback {
    @Override
    public int invoke(WString path, int desiredAccess, int shareMode, int creationDesposition, int flagsAndAttributes, DokanFileInfo dokanFileInfo) {
        VirtualFile file = (VirtualFile)root.getFile(path);

        switch (creationDesposition) {
            case CREATE_ALWAYS:
                return createAlways(file, path, desiredAccess, shareMode, flagsAndAttributes, dokanFileInfo);
            case CREATE_NEW:
                return createNew(file, path, desiredAccess, shareMode, flagsAndAttributes, dokanFileInfo);
            case OPEN_EXISTING:
                return openExisting(file, desiredAccess, shareMode, flagsAndAttributes, dokanFileInfo);
            case OPEN_ALWAYS:
                return openAlways(file, path, desiredAccess, shareMode, flagsAndAttributes, dokanFileInfo);
            case TRUNCATE_EXISTING:
                return truncateExisting(file, desiredAccess, shareMode, flagsAndAttributes, dokanFileInfo);
        }
        return -ERROR_GENERAL_ERROR;

    }
    private int createAlways(VirtualFile file, WString path, int desiredAccess, int shareMode, int flagsAndAttributes, DokanFileInfo dokanFileInfo) {
            int returnCode = ERROR_SUCCESS;

            if (file != null) {
                returnCode = file.flush(flagsAndAttributes) ? ERROR_ALREADY_EXISTS : -ERROR_ACCESS_DENIED;
            } else {
                file = (VirtualFile) root.createFile(path, flagsAndAttributes);
                if (file == null) {
                    return -ERROR_PATH_NOT_FOUND;
                }
            }

            dokanFileInfo.isDirectory = file.isDirectory() ? (byte) 1 : 0;
            dokanFileInfo.context = file.hashCode();
            return returnCode;
        }

    private int createNew(VirtualFile file, WString path, int desiredAccess, int shareMode, int flagsAndAttributes, DokanFileInfo dokanFileInfo) {
        if (file != null) {
            return -ERROR_FILE_EXISTS;
        }

        file =(VirtualFile) root.createFile(path, flagsAndAttributes);
        if (file == null) {
            return -ERROR_PATH_NOT_FOUND;
        }
        dokanFileInfo.isDirectory = file.isDirectory() ? (byte) 1 : 0;
        dokanFileInfo.context = file.hashCode();
        return ERROR_SUCCESS;
    }

    private int openExisting(VirtualFile file, int desiredAccess, int shareMode, int flagsAndAttributes, DokanFileInfo dokanFileInfo) {
        if (file == null) {
            dokanFileInfo.context = 0;
            return -ERROR_FILE_NOT_FOUND;
        }

        if (file.isReadOnly() && Is.in(desiredAccess).set(GENERIC_WRITE | FILE_WRITE_DATA)) {
            return -ERROR_ACCESS_DENIED;
        }

        dokanFileInfo.isDirectory = file.isDirectory() ? (byte) 1 : 0;
        dokanFileInfo.context = file.hashCode();
        return ERROR_SUCCESS;
    }

    private int openAlways(VirtualFile file, WString path, int desiredAccess, int shareMode, int flagsAndAttributes, DokanFileInfo dokanFileInfo) {
        int returnCode = ERROR_ALREADY_EXISTS;

        if (file == null) {
            file = (VirtualFile) root.createFile(path, flagsAndAttributes);
            returnCode = ERROR_SUCCESS;
        }

        if (file.isReadOnly() && Is.in(desiredAccess).set(GENERIC_WRITE | FILE_WRITE_DATA)) {
            return -ERROR_ACCESS_DENIED;
        }

        dokanFileInfo.isDirectory = file.isDirectory() ? (byte) 1 : 0;
        dokanFileInfo.context = file.hashCode();
        return returnCode;
    }

    private int truncateExisting(VirtualFile file, int desiredAccess, int shareMode, int flagsAndAttributes, DokanFileInfo dokanFileInfo) {
        if (file == null) {
            return -ERROR_FILE_NOT_FOUND;
        }

        if (file.isReadOnly() && Is.in(desiredAccess).set(GENERIC_WRITE | FILE_WRITE_DATA)) {
            return -ERROR_ACCESS_DENIED;
        }

        file.setEOF(0);
        dokanFileInfo.context = file.hashCode();

        return ERROR_SUCCESS;

    }
}