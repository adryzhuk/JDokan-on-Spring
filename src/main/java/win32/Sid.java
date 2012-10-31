package win32;

import com.sun.jna.NativeLong;
import com.sun.jna.Structure;

/**
 * User: Mykola.Polubutkin
 * Date: 10/11/12
 * Time: 2:36 PM
 */

public class Sid extends Structure {
    public static int ANY_SIZE = 16;

    public byte revision;
    public byte subAuthorityCount;
    public SidIdentifierAuthority identifierAuthority;
    public NativeLong[] subAuthority = new NativeLong[ANY_SIZE];

    public static class Reference extends Sid implements ByReference {
    }

    public Sid() {
        setFieldOrder(new String[]{
                "revision",
                "subAuthorityCount",
                "identifierAuthority",
                "subAuthority"
        });
    }
}
