package FileSystem;

import java.util.Arrays;

/**
 * @author: Vyacheslav.Bychkovsk
 */
public class MemoryStream {
    private byte[] content = new byte[0];

    public synchronized int read(byte[] buf, long offset, int bufferLen) {
        if (offset >= content.length) {
            return -1; // trying to read from out of bounds
        }

        int couldRead = (content.length - offset < bufferLen) ? (content.length - (int) offset) : bufferLen;
        System.arraycopy(content, (int) offset, buf, 0, couldRead);

        return couldRead;
    }

    public synchronized int write(byte[] buf, long offset, int bytesToWrite) {
        int newLen = (int) (offset + bytesToWrite);
        if (content.length < newLen) content = Arrays.copyOf(content, newLen);

        System.arraycopy(buf, 0, content, (int) offset, bytesToWrite);
        return bytesToWrite;
    }

    public long getSize() {
        return content.length;
    }

    public boolean setSize(long eof) {
        content = Arrays.copyOf(content, (int) eof);
        return true;
    }
}