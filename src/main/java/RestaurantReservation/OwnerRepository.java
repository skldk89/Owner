package RestaurantReservation;

import org.springframework.data.repository.PagingAndSortingRepository;

public interface OwnerRepository extends PagingAndSortingRepository<Owner, Long>{


   Owner findByReservationId(Long reservationId);

}