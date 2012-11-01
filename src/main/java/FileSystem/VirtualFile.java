package FileSystem;

import FileSystem.api.File;
import FileSystem.api.FileOperations;
import com.sun.jna.Pointer;
import com.sun.jna.WString;
import com.sun.jna.platform.win32.WinBase;
import com.sun.jna.ptr.IntByReference;
import common.Is;
import win32.Win32FindData;

import java.io.UnsupportedEncodingException;
import java.util.*;

/**
 * @author: Vyacheslav.Bychkovsk
 */
public class VirtualFile implements File,FileOperations {

    private Date creationTime;
    private String name;
    private String alternativeName;
    private int flagsAndAttributes;
    private Date lastAccessTime;
    private Date lastWriteTime;
    private VirtualFile parent;

    private MemoryStream content;

    Map<String, VirtualFile> files;

    public VirtualFile(String name, int flagsAndAttributes){
        this.name = name;
        this.alternativeName = "";
        this.flagsAndAttributes = flagsAndAttributes;
        this.creationTime = new Date();
        this.lastAccessTime = new Date();
        this.lastWriteTime = new Date();
        this.content = new MemoryStream();

        if (this.isDirectory()) {
            this.files = new TreeMap<String, VirtualFile>();
        }
    }
    private VirtualFile(int flagsAndAttributes){
        this("", flagsAndAttributes);
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        VirtualFile that = (VirtualFile) o;

        if (getFlagsAndAttributes() != that.getFlagsAndAttributes()) return false;
        if (content.getSize() != that.content.getSize()) return false;
        if (!alternativeName.equals(that.alternativeName)) return false;
        if (!creationTime.equals(that.creationTime)) return false;
        if (!lastAccessTime.equals(that.lastAccessTime)) return false;
        if (!lastWriteTime.equals(that.lastWriteTime)) return false;
        if (!name.equals(that.name)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;

        result = 31 * result + alternativeName.hashCode();
        result = 31 * result + (this.isDirectory() ? 1 : 0);
//        result = 31 * result + creationTime.hashCode();
//        result = 31 * result + lastAccessTime.hashCode();
//        result = 31 * result + lastWriteTime.hashCode();

        return result;
    }


    @Override
    public boolean read(Pointer readBuf, long offset, int bufferLen, IntByReference bytesRead) {
        this.setLastAccessTime(new Date());

        byte[] buf = new byte[bufferLen];
        int read = content.read(buf, offset, bufferLen);

        if (read == -1) {
            bytesRead.setValue(0);
            return false;
        } else {
            bytesRead.setValue(read);
            readBuf.write(0, buf, 0, read);

            return true;
        }
    }

    @Override
    public boolean write(Pointer writeBuf, long offset, int bytesToWrite, IntByReference bytesWritten) {
        this.setLastAccessTime(new Date());
        this.setLastWriteTime(new Date());

        byte[] buf = new byte[bytesToWrite];
        writeBuf.read(0, buf, 0, bytesToWrite);
        int written = content.write(buf, offset, bytesToWrite);
        bytesWritten.setValue(written);
        return true;
    }

    @Override
    public boolean isReadOnly() {
        return Is.in(flagsAndAttributes).set(ATTRIBUTE_READ_ONLY);
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getAlternativeName() {
        return alternativeName;
    }

    @Override
    public long getSize() {
        return content.getSize();
    }

    @Override
    public long getUsedSpace() {
        long totalUsedBytes = 0;
        VirtualFile file = this;

        if (file.isDirectory()) {
            List<VirtualFile> list = file.getFiles();
            for (VirtualFile f : list) {
                if (f.isDirectory()) {
                    totalUsedBytes += f.getUsedSpace();
                } else {
                    totalUsedBytes += f.getSize();
                }
            }
        }
        return totalUsedBytes;
    }

    @Override
    public Date getLastWriteTime() {
        return lastWriteTime;
    }

    @Override
    public Date getLastAccessTime() {
        return lastAccessTime;
    }

    @Override
    public Date getCreationTime() {
        return creationTime;
    }

    @Override
    public int getFlagsAndAttributes() {
        return flagsAndAttributes;
    }

    @Override
    public void setFlagsAndAttributes(int flagsAndAttributes) {
        this.flagsAndAttributes = flagsAndAttributes;
    }

    @Override
    public void setLastAccessTime(Date lastAccessTime) {
        this.lastAccessTime = lastAccessTime;
    }

    @Override
    public void setCreationTime(Date creationTime) {
        this.creationTime = creationTime;
    }

    @Override
    public void setLastWriteTime(Date lastWriteTime) {
        this.lastWriteTime = lastWriteTime;
    }

    @Override
    public void setAlternativeName(String alternativeName) {
        this.alternativeName = alternativeName;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean isDirectory() {
        return Is.in(flagsAndAttributes).set(ATTRIBUTE_DIRECTORY);
    }

    @Override
    public Win32FindData getWin32FindData() {
        Win32FindData result = new Win32FindData();
        try {
            result.fileName = (name + "\0").getBytes("UTF-16LE");
            result.alternativeFileName = (alternativeName + "\0").getBytes("UTF-16LE");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

        result.fileAttributes = flagsAndAttributes;
        result.creationTime = new WinBase.FILETIME(creationTime);
        result.lastAccess = new WinBase.FILETIME(lastAccessTime);
        result.lastWrite = new WinBase.FILETIME(lastWriteTime);
        result.sizeHigh = (int) (getSize() >>> 32);
        result.sizeLow = (int) (getSize());

        return result;
    }

    @Override
    public boolean setEOF(long length) {
        if (isDirectory()) {
            System.out.println("\tSetEOF failed");
            return false;
        }

        content.setSize(length);
        return true;
    }

    @Override
    public File getParent() {
        return parent;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public void setParent(VirtualFile parent) {
        this.parent = parent;
    }

    @Override
    public File createFile(WString path, int flagsAndAttributes) {
        VirtualFile file = new VirtualFile(flagsAndAttributes);

        if (putFile(file, path)) {
            return file;
        } else {
            return null;
        }
    }

    private boolean putFile(VirtualFile file, WString newPath) {
        String[] newFullPath = parsePath(newPath);
        String newName = newFullPath[newFullPath.length - 1];
        VirtualFile parent = (VirtualFile) getFileByPath(Arrays.copyOf(newFullPath, newFullPath.length - 1));

        if (parent != null && parent.isDirectory()) {
            parent.files.put(newName, file);

            file.setName(newName);
            file.setParent(parent);

            return true;
        } else {
            return false;
        }
    }

    private String[] parsePath(WString path) {
        String trailingsBSlashRemoved = path.toString().replaceAll("^\\\\", "");
        if (trailingsBSlashRemoved.length() == 0) {
            return new String[0];
        }
        return trailingsBSlashRemoved.split("\\\\+");
    }

    private String[] parsePath(String path) {
        return parsePath(new WString(path));
    }

    @Override
    public boolean moveFile(WString existingPath, WString newPath, boolean replace) {
        VirtualFile file = (VirtualFile)getFile(existingPath);
        if (file == null) {
            return false;
        }

        return (!fileExist(newPath) || replace) && putFile((VirtualFile)deleteFileByPath(existingPath), newPath);
    }

    @Override
    public boolean fileExist(WString path) {
        return getFile(path) != null;
    }

    @Override
    public File deleteFileByPath(WString path) {
        VirtualFile file = (VirtualFile)getFile(path);
        if (file == null) {
            return null;
        }

        return file.delete();
    }

    @Override
    public File getFile(WString path) {
        if (!isDirectory()) {
            return null;
        }

        return getFileByPath(parsePath(path));
    }

    @Override
    public File getFileByPath(String[] path) {
        VirtualFile file = this;

        for (String name: path) {
            if (file.isDirectory() && file.files.containsKey(name)) {
                file = file.files.get(name);
            } else {
                return null;
            }
        }
        return file;

    }

    @Override
    public List<VirtualFile> getFiles() {
        if (!isDirectory()) {
            return Collections.emptyList();
        }

        return new ArrayList<>(files.values());
    }

    @Override
    public File delete() {
        return parent.deleteChild(this);
    }

    @Override
    public File deleteChild(VirtualFile virtualFile) {
        return this.files.remove(virtualFile.getName());
    }

    @Override
    public boolean flush(int flags) {
        setFlagsAndAttributes(flags);
        setEOF(0);
        return true;
    }
}
