package RestaurantReservation;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.Optional;

 @RestController
 public class OwnerController {
  @Autowired
  OwnerRepository ownerRepository;

  @RequestMapping(method= RequestMethod.POST, path="/postOwners")
  public void postReservation(@RequestBody Owner owner) {

   Owner oneOwner = new Owner();

   System.out.println("@@@@ Test 1" + owner.getReservationId());
   oneOwner.setOwnerId(owner.getOwnerId());
   oneOwner.setStatus(owner.getStatus());
   oneOwner.setReservationDate(owner.getReservationDate());
   oneOwner.setReservationId(owner.getReservationId());

   ownerRepository.save(oneOwner);

  }

  @RequestMapping(method=RequestMethod.PATCH, path="/owners/check")
  public void checkReservation(@RequestParam(value="reservationId", required=false, defaultValue="0") Long reservationId) {

   Owner pickOwner = ownerRepository.findByReservationId(reservationId);
   int random1 = (int)(Math.random() * 2);

   if(pickOwner.getReservationId() == null){
    Long val = 1L;
    pickOwner.setReservationId(val);
    pickOwner.setReservationDate("20200820");
    pickOwner.setOwnerId(1001L);
   }
   System.out.println("### test " + reservationId);

   if (random1 == 0) {
    pickOwner.setStatus("Approved");
   } else {
    pickOwner.setStatus("Declined");
   }
   ownerRepository.save(pickOwner);

  }
 }
