package FileSystem.systemoperations;

import FileSystem.VirtualFile;
import FileSystem.VirtualVolume;
import FileSystem.api.File;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.FileSystemResource;

/**
 * @author: Vyacheslav.Bychkovsk
 */
public interface Root {
//    public static final VirtualFile root = new VirtualFile("\\",File.ATTRIBUTE_DIRECTORY);
    BeanFactory factory = new XmlBeanFactory(new FileSystemResource("src\\main\\resources\\beans.xml"));
    public static final VirtualVolume volume = (VirtualVolume)factory.getBean("VolumeProperties");

}
