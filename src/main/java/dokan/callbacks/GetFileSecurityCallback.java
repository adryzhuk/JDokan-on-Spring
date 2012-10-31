package dokan.callbacks;

import com.sun.jna.Callback;
import com.sun.jna.NativeLong;
import com.sun.jna.WString;
import com.sun.jna.ptr.IntByReference;
import com.sun.jna.ptr.LongByReference;
import dokan.DokanFileInfo;
import win32.SecurityDescriptor;

/**
 * @author: Vyacheslav.Bychkovsk
 */
public interface GetFileSecurityCallback extends Callback {
    int invoke(WString fileName, IntByReference securityInfo, SecurityDescriptor securityDescriptor, NativeLong bufferLength, LongByReference lengthNeeded, DokanFileInfo dokanFileInfo);
}
