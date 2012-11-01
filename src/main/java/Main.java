import FileSystem.VirtualFS;
import FileSystem.VirtualVolume;
import dokan.DokanLibrary;
import dokan.DokanOptions;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.FileSystemResource;

/**
 * @author: Vyacheslav.Bychkovsk
 */
public class Main {
    DokanOptions options;
    VirtualFS fileSystem;
    public static void main(String[] args) {
        System.out.println("hello");
        new Main().startApp();

    }
    void startApp(){

        BeanFactory factory = new XmlBeanFactory(new FileSystemResource("src\\main\\resources\\beans.xml"));

//        options = (DokanOptions)factory.getBean("DokanOptions");

        fileSystem = (VirtualFS)factory.getBean("VirtualFS");

        showStatus(DokanLibrary.INSTANCE.DokanMain(new VirtualVolume(),fileSystem));



    }
    void showStatus(int status){
        switch (status) {
            case DokanLibrary.DOKAN_DRIVE_LETTER_ERROR:
                System.out.println("Drive letter error");
                break;
            case DokanLibrary.DOKAN_DRIVER_INSTALL_ERROR:
                System.out.println("Driver install error");
                break;
            case DokanLibrary.DOKAN_MOUNT_ERROR:
                System.out.println("Mount error");
                break;
            case DokanLibrary.DOKAN_START_ERROR:
                System.out.println("Start error");
                break;
            case DokanLibrary.DOKAN_ERROR:
                System.out.println("Unknown error");
                break;
            case DokanLibrary.DOKAN_SUCCESS:
                System.out.println("Success");
                break;
            default:
                System.out.println("Unknown status " + status);
                break;
        }
    }
}
