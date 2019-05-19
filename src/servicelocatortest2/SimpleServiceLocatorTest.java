package servicelocatortest2;

import interfaces.InterfaceA;
import interfaces.InterfaceB;
import interfaces.InterfaceC;
import interfaces.InterfaceD;
import org.junit.jupiter.api.Assertions;
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
    void setService() {
        //setService instal·la una factoria donant-li un nom (i llença l'excepció
        //LocatorError si ja hi ha alguna cosa enregistrada amb aquest nom)
        factoryA = new FactoryA1();

        //assertEquals(5,locator.setService("I"););
        //ssertEquals("testing",locator.setService("S"););
        Assertions.assertThrows(LocatorError.class, () -> {
            locator.setService(InterfaceA.class, factoryA);
        });
        Assertions.assertThrows(LocatorError.class, () -> {
            locator.setService(InterfaceB.class, factoryB);
        });
        Assertions.assertThrows(LocatorError.class, () -> {
            locator.setService(InterfaceC.class, factoryC);
        });
        Assertions.assertThrows(LocatorError.class, () -> {
            locator.setService(InterfaceD.class, factoryD);
        });
    }

    @Test
    void setConstant() {
        Assertions.assertThrows(LocatorError.class, () -> {
            locator.setConstant(String.class, "factoryA");
        });
        Assertions.assertThrows(LocatorError.class, () -> {
            locator.setConstant(int.class, 10);
        });
    }

    @Test
    void getObject() throws LocatorError{
        assertEquals(5, locator.getObject(int.class));
        assertEquals("testing", locator.getObject(String.class));

        Assertions.assertThrows(LocatorError.class, () -> {
            locator.getObject(double.class);
        });

        Assertions.assertDoesNotThrow(() -> {
            locator.getObject(InterfaceA.class);
        });
    }
}