package auction.data;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class DBUtil {
    private static final EntityManagerFactory emf =
            Persistence.createEntityManagerFactory("auctionPU");
    
    public static EntityManagerFactory getEmFactory() {
        return emf;
    }
}