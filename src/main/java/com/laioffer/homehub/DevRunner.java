package com.laioffer.homehub;
import com.laioffer.homehub.model.AlertsEntity;
import com.laioffer.homehub.model.EventsEntity;
import com.laioffer.homehub.model.NewsletterEntity;
import com.laioffer.homehub.model.PoliciesEntity;
import com.laioffer.homehub.model.UserEntity;
import com.laioffer.homehub.model.UserRole;
import com.laioffer.homehub.repository.dashboard.AlertsRepository;
import com.laioffer.homehub.repository.dashboard.EventsRepository;
import com.laioffer.homehub.repository.dashboard.NewsletterRepository;
import com.laioffer.homehub.repository.dashboard.PoliciesRepository;
import com.laioffer.homehub.repository.dashboard.UserRepository;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.boot.ApplicationArguments;
//import org.springframework.boot.ApplicationRunner;
//import org.springframework.stereotype.Component;


//import java.time.LocalDateTime;
//import java.util.List;


@org.springframework.stereotype.Component
public class DevRunner implements org.springframework.boot.ApplicationRunner {


    static private final org.slf4j.Logger logger = org.slf4j.LoggerFactory.getLogger(DevRunner.class);


    private final AlertsRepository alertsRepository;
    private final EventsRepository eventsRepository;
    private final NewsletterRepository newsletterRepository;
    private final PoliciesRepository policiesRepository;
    private final UserRepository userRepository;


    public DevRunner(
            AlertsRepository alertsRepository,
            EventsRepository eventsRepository,
            NewsletterRepository newsletterRepository,
            PoliciesRepository policiesRepository,
            UserRepository userRepository
    ) {
        this.alertsRepository = alertsRepository;
        this.eventsRepository = eventsRepository;
        this.newsletterRepository = newsletterRepository;
        this.policiesRepository = policiesRepository;
        this.userRepository = userRepository;
    }


    @Override
    public void run(org.springframework.boot.ApplicationArguments args) {
        generateSampleData();

        // User
        UserEntity user = userRepository.findByUsername("rich_the_landlord");
        logger.info(user.toString());


        boolean exists = userRepository.existsByUsername("eddy");
        logger.info("User eddy exists? " + exists);

        // Events
        java.util.List<EventsEntity> events = eventsRepository.findAllEvents();
        logger.info("Events: " + events);

        // Alerts
        java.util.List<AlertsEntity> alerts = alertsRepository.findAllAlerts();
        logger.info("Alerts: " + alerts);

        // Newsletters
        java.util.List<NewsletterEntity> newsletters = newsletterRepository.findAll();
        logger.info("Newsletters: " + newsletters);

        // Policies
        java.util.List<PoliciesEntity> policies = policiesRepository.findAllPolicies();
        logger.info("Policies: " + policies);

//        java.util.List<ListingEntity> availableListings = listingRepository.searchListings(
//                37.55093541777099,
//                -122.32841093538015,
//                100000,
//                java.time.LocalDate.now().plusDays(5),
//                java.time.LocalDate.now().plusDays(10),
//                2
//        );

//        logger.info("Available listings: " + availableListings.stream().map(
//                entity -> entity.getId() + " " + entity.getName()
//        ).toList());


//        java.util.List<BookingEntity> guestBookings = bookingRepository.findAllByGuestId(4L);
//        logger.info("Guest lively_wanderlust has the following bookings: " + guestBookings);


//        java.util.List<BookingEntity> listingBookings = bookingRepository.findAllByListingId(1L);
//        logger.info("Listing 1 has the following bookings: " + listingBookings);


//        java.util.List<BookingEntity> overlappedBookings = bookingRepository.findOverlappedBookings(
//                1L,
//                java.time.LocalDate.now().plusDays(5),
//                java.time.LocalDate.now().plusDays(10)
//        );
//        logger.info("Listing 1 overlapped bookings: " + overlappedBookings);


//        boolean hasUpcomingBooking = bookingRepository.existsByListingIdAndCheckOutDateAfter(
//                1L,
//                java.time.LocalDate.now()
//        );
//        logger.info("Listing 1 has upcoming booking? " + hasUpcomingBooking);
    }


    private void generateSampleData() {
        userRepository.saveAll(java.util.List.of(
                new UserEntity(null, "rich_the_landlord", "YT61cW", UserRole.ROLE_ADMIN),
                new UserEntity(null, "starry_nights", "sa4NiK", UserRole.ROLE_ADMIN),
                new UserEntity(null, "eternal_optimist", "akKKN6", UserRole.ROLE_ADMIN),
                new UserEntity(null, "lively_wanderlust", "1z3dUW", UserRole.ROLE_RESIDENT),
                new UserEntity(null, "cool_coder_dude", "0k/N1i", UserRole.ROLE_RESIDENT),
                new UserEntity(null, "thunderstorm_rider", "C5AB0.", UserRole.ROLE_RESIDENT),
                new UserEntity(null, "victorious_soul", "UhjaYO", UserRole.ROLE_RESIDENT),
                new UserEntity(null, "music_maniac", "BrSZo.", UserRole.ROLE_RESIDENT),
                new UserEntity(null, "rainbow_skies", "P4fTkW", UserRole.ROLE_RESIDENT),
                new UserEntity(null, "moonlight_dancer", "64zzLG", UserRole.ROLE_RESIDENT),
                new UserEntity(null, "melody_walker", "K7P/Oe", UserRole.ROLE_RESIDENT),
                new UserEntity(null, "cosmic_traveler", "jFG/qm", UserRole.ROLE_RESIDENT),
                new UserEntity(null, "eternal_dreamer", "4itNFi", UserRole.ROLE_RESIDENT)
        ));



        java.time.LocalDateTime today = java.time.LocalDateTime.now();
        alertsRepository.saveAll(java.util.List.of(
                new AlertsEntity(null, "Alerts 1", "Alerts 1 Content", today, 2L)
        ));

        eventsRepository.saveAll(java.util.List.of(
                new EventsEntity(null, "Event 1", "Event 1 Content", today.plusDays(1), today, 1L)

        ));

        newsletterRepository.saveAll(java.util.List.of(
                new NewsletterEntity(null, "Newsletter 1", "Newsletter 1 Content", today, 1L)

        ));

        policiesRepository.saveAll(java.util.List.of(
                new PoliciesEntity(null, "Policy 1", "Policy 1 Content", today, 3L)

        ));



    }
}
