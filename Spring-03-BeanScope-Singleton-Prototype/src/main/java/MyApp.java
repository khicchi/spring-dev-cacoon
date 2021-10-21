import interfaces.Course;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import services.Selenium;

public class MyApp {

    private static ApplicationContext container;

    public static void main(String[] args) {
        container = new ClassPathXmlApplicationContext("config.xml");

        Course course1 = container.getBean("java",Course.class);

        Course course2 = container.getBean("java",Course.class);
        //check java prototype scope
        System.out.println("Pointing to the same object:" + (course1 == course2));

        System.out.println("Memory Location for the course1:" + course1);//Java@3d285d7e

        System.out.println("Memory Location for the course2:" + course2);//Java@40005471

        checkSeleniumSingletonScope();
    }

    private static void checkSeleniumSingletonScope(){
        Course selenium1 = container.getBean("selenium", Selenium.class);

        Course selenium2 = container.getBean("selenium",Selenium.class);

        System.out.println("Memory Location for the selenium1:" + selenium1);//Selenium@2cd76f31

        System.out.println("Memory Location for the selenium2:" + selenium2);//Selenium@2cd76f31
    }
}
