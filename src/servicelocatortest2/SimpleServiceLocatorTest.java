package servicelocatortest2;

import interfaces.InterfaceA;
import interfaces.InterfaceB;
import interfaces.InterfaceC;
import interfaces.InterfaceD;
import org.junit.jupiter.api.BeforeEach;
import servicelocator2.*;
import factories2.*;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SimpleServiceLocatorTest {
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

        locator.setService(InterfaceA.class, factoryA);
        locator.setService(InterfaceB.class, factoryB);
        locator.setService(InterfaceC.class, factoryC);
        locator.setService(InterfaceD.class, factoryD);

        locator.setConstant(String.class, "testing");
        locator.setConstant(int.class, 5);
    }
    @Test
    void setService () {
    }

    @Test
    void setConstant () {
    }

    @Test
    void getObject () {
    }
}