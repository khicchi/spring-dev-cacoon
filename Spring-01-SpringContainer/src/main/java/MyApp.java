import com.lespania.interfaces.Mentor;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MyApp {

    public static void main(String[] args) {

        containerFromBeanFactory();
        containerFromAppContext();
    }

    static void containerFromBeanFactory(){
        BeanFactory container = new ClassPathXmlApplicationContext("config.xml");
        Mentor mentor = container.getBean("fullTimeMentor", Mentor.class);
        mentor.createAccount();
    }

    static void containerFromAppContext(){
        ApplicationContext container = new ClassPathXmlApplicationContext("config.xml");
        Mentor mentor = container.getBean("partTimeMentor",Mentor.class);
        mentor.createAccount();
    }

}
