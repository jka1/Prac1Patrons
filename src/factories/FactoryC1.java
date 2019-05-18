package factories;

import implementations.ImplementationB1;
import implementations.ImplementationC1;
import interfaces.InterfaceD;
import servicelocator.Factory;
import servicelocator.LocatorError;
import servicelocator.ServiceLocator;

public class FactoryC1 implements Factory {
    @Override
    public Object create(ServiceLocator sl) throws LocatorError {
        try {
            String s = (String) sl.getObject("C");
            return new ImplementationC1(s);
        } catch (ClassCastException ex) {
            throw new LocatorError(ex);
        }
    }
}
