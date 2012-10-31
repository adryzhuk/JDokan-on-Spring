package win32;

import com.sun.jna.Structure;

/**
 * User: Mykola.Polubutkin
 * Date: 10/11/12
 * Time: 2:41 PM
 */
public class Acl extends Structure {
    public byte aclRevision;
    public byte sbz1;
    public short aclSize;
    public short aclCount;
    public short sbz2;

    public Acl() {
        setFieldOrder(new String[]{
                "aclRevision",
                "sbz1",
                "aclSize",
                "aclCount",
                "sbz2"
        });
    }

    public static class Reference extends Acl implements ByReference {
    }
}
