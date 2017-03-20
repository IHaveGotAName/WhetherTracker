import com.podd.WeatherTracker.utilities.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.junit.Test;


    /**
     * Created by ivegotaname on 20.02.17.
     */

    public class HibernateTest  {
        @Test
        public void testHibernate() {
            SessionFactory factory = HibernateUtil.getSessionFactory();
            Session session = factory.openSession();
            Transaction tx = null;
            try {
                tx = session.beginTransaction();
                tx.commit();
            } catch (Exception e) {
                if (tx != null) tx.rollback();
                e.printStackTrace();
            } finally {
                session.close();
            }
        }
    }

