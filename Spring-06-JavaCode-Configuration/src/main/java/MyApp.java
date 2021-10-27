import configs.MyAppClass;
import interfaces.Course;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MyApp {
    public static void main(String[] args) {

        ApplicationContext container = new AnnotationConfigApplicationContext(MyAppClass.class);

        Course course = container.getBean("java", Course.class);

        System.out.println(course.toString());

        course.getTeachingHours();




    }
}
