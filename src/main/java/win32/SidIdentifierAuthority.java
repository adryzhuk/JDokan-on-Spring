package win32;

import com.sun.jna.Structure;

/**
 * User: Mykola.Polubutkin
 * Date: 10/11/12
 * Time: 2:37 PM
 */
public class SidIdentifierAuthority extends Structure {
    public byte[] value = new byte[6];
}
