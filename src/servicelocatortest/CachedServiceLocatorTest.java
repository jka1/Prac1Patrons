package servicelocatortest;

import factories.FactoryA1;
import factories.FactoryB1;
import factories.FactoryC1;
import factories.FactoryD1;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import servicelocator.LocatorError;
import servicelocator.SimpleServiceLocator;

import static org.junit.jupiter.api.Assertions.*;

class CachedServiceLocatorTest {
    FactoryA1 factoryA;
    FactoryB1 factoryB;
    FactoryC1 factoryC;
    FactoryD1 factoryD;
    SimpleServiceLocator locator;

    @BeforeEach
    public void initializer() throws LocatorError {
        factoryA = new FactoryA1();
        factoryB = new FactoryB1();
        factoryC = new FactoryC1();
        factoryD = new FactoryD1();

        locator = new SimpleServiceLocator();

        locator.setService("A",factoryA);
        locator.setService("B",factoryB);
        locator.setService("C",factoryC);
        locator.setService("D",factoryD);

        locator.setConstant("S","testing");
        locator.setConstant("I",5);

    }


    @Test
    void setService() {
    }

    @Test
    void setConstant() {
    }

    @Test
    void getObject() {
    }
}