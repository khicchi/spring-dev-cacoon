package com.lespania;

import com.lespania.entity.User;
import com.lespania.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.PostConstruct;
import java.time.LocalDateTime;
import java.util.List;

@SpringBootApplication
public class Spring09OrmCinemaLabApplication {

    @Autowired
    AccountRepository accountRepository;
    @Autowired
    CinemaRepository cinemaRepository;
    @Autowired
    MovieCinemaRepository movieCinemaRepository;
    @Autowired
    TicketRepository ticketRepository;
    @Autowired
    UserRepository userRepository;


    public static void main(String[] args) {
        SpringApplication.run(Spring09OrmCinemaLabApplication.class, args);
    }

    @PostConstruct
    public void testAccount(){
//        System.out.println(accountRepository.fetchAdminUsers());
//        System.out.println(cinemaRepository.distinctBYSponsoredName());
//        System.out.println(movieCinemaRepository.countAllByCinemaId(4L));
//        System.out.println(movieCinemaRepository.retrieveAllByLocationName("AMC Empire 25"));
//        System.out.println(ticketRepository.fetchAllTicketsByUserJPQL(4l));
//        System.out.println(ticketRepository.fetchAllTicketsWithRangeDates(LocalDateTime.now().minusDays(25),LocalDateTime.now()));
//        System.out.println(ticketRepository.retrieveAllBySearchCriteria("it"));

        List<User> usersFromAccountName = userRepository.findAllByAccountNameContaining("on");
        usersFromAccountName.forEach(u -> System.out.print(u.getUsername() + ", "));
        System.out.println();



//        System.out.println(ticketRepository.findAllByUserAccountCity("LOUISVILLE"));
    }
}
