package factories;

import implementations.ImplementationC1;
import implementations.ImplementationD1;
import servicelocator.Factory;
import servicelocator.LocatorError;
import servicelocator.ServiceLocator;

public class FactoryD1 implements Factory {
    @Override
    public Object create(ServiceLocator sl) throws LocatorError {
        try {
            int i = (Integer) sl.getObject("D");
            return new ImplementationD1(i);
        } catch (ClassCastException ex) {
            throw new LocatorError(ex);
        }
    }
}
