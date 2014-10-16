package entapplookup;

import ejb.EJBRemoteInterface;
import ejb.SingletonSessionBeanRemoteInterface;
import java.util.logging.Logger;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

public class EntAppLookup {

    private static final Logger log = Logger.getLogger(EntAppLookup.class.getName());

    public static void main(String... args) throws NamingException {
        Context ctx = new InitialContext();
        log.fine(ctx.getEnvironment().toString());
        Object obj = ctx.lookup("ejb.EJBRemoteInterface");
        EJBRemoteInterface ejb = (EJBRemoteInterface) obj;
        log.info(ejb.getResult());
        log.info("next\t" + ejb.getNext());
        Object obj2 = ctx.lookup("ejb.SingletonSessionBeanRemoteInterface");
        SingletonSessionBeanRemoteInterface singleton = (SingletonSessionBeanRemoteInterface) obj2;
        for (int i = 0; i < 9; i++) {
            log.info("next\t" + singleton.next());
        }
    }
}
