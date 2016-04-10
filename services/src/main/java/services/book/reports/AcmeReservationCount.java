package services.book.reports;

import java.io.Serializable;

/**
 * Example of a Scheduled Reporter Task
 *
 * @author Juneau
 */
public class AcmeReservationCount implements Runnable, Serializable {

//    ParkReservationFacade parkReservationFacade = lookupParkReservationFacadeBean();
//    String reportName;
//
//    public AcmeReservationCount() {
//    }
//
    public void run() {
       // runCountReport();
    }
//
//    /**
//     * Prints a count of reservations.
//     */
//    public void runCountReport() {
//        System.out.println("Park Reservation Count for Today");
//        System.out.println("===============================");
//
//        Long reservationCount = parkReservationFacade.findCount();
//        System.out.println(reservationCount);
//
//        // Email in production application
//    }
//
//    private ParkReservationFacade lookupParkReservationFacadeBean() {
//        try {
//            Context c = new InitialContext();
//            return (ParkReservationFacade) c.lookup("java:global/AcmeWorld/ParkReservationFacade");
//        } catch (NamingException ne) {
//            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught", ne);
//            throw new RuntimeException(ne);
//        }
   // }
}
