import dokan.DokanOptions;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.FileSystemResource;

/**
 * @author: Vyacheslav.Bychkovsk
 */
public class Main {
    public static void main(String[] args) {
        System.out.println("hello");
        new Main().startApp();

    }
    void startApp(){

        BeanFactory factory = new XmlBeanFactory(new FileSystemResource("src\\main\\resources\\beans.xml"));

        DokanOptions opt = (DokanOptions)factory.getBean("DokanOptions");
        System.out.println(opt);
    }
}
