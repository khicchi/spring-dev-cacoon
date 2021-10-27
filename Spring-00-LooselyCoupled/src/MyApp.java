import service.FullTimeMentor;

import com.lespania.interfaces.Mentor;
import service.MentorAccount;


public class MyApp {
    public static void main(String[] args) {

        FullTimeMentor fullTime = new FullTimeMentor();
        //PartTimeMentor partTime = new PartTimeMentor();

        MentorAccount mentor = new MentorAccount(fullTime);

        mentor.manageAccount();

    }


}
