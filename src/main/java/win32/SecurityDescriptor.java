package win32;

import com.sun.jna.Structure;

/**
 * User: Mykola.Polubutkin
 * Date: 10/11/12
 * Time: 2:28 PM
 */

public class SecurityDescriptor extends Structure {
    public byte revision;
    public byte sbz1;
    public short control; //SECURITY_DESCRIPTOR_CONTROL
    public Sid owner;
    public Sid group;
    public Acl sacl;
    public Acl dacl;

    public static class Reference extends SecurityDescriptor implements ByReference {
    }

    public SecurityDescriptor() {
        setFieldOrder(new String[]{
                "revision",
                "sbz1",
                "securityDescriporControl",
                "owner",
                "group",
                "sacl",
                "dacl"
        });
    }
}
