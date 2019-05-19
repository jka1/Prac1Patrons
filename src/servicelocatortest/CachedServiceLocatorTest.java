package servicelocatortest;

import factories.FactoryA1;
import factories.FactoryB1;
import factories.FactoryC1;
import factories.FactoryD1;
import implementations.ImplementationA1;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import servicelocator.*;

import static org.junit.jupiter.api.Assertions.*;

class CachedServiceLocatorTest {
    FactoryA1 factoryA;
    FactoryB1 factoryB;
    FactoryC1 factoryC;
    FactoryD1 factoryD;
    ServiceLocator locator;

    @BeforeEach
    public void initializer() throws LocatorError {
        factoryA = new FactoryA1();
        factoryB = new FactoryB1();
        factoryC = new FactoryC1();
        factoryD = new FactoryD1();

        locator = new CachedServiceLocator();

        locator.setService("A", factoryA);
        locator.setService("B", factoryB);
        locator.setService("C", factoryC);
        locator.setService("D", factoryD);

        locator.setConstant("S", "testing");
        locator.setConstant("I", 5);

    }

    @Test
    void setService() {
        factoryA = new FactoryA1();

        //assertEquals(5,locator.setService("I"););
        //ssertEquals("testing",locator.setService("S"););
        Assertions.assertThrows(LocatorError.class, () -> {
            locator.setService("A", factoryA);
        });
        Assertions.assertThrows(LocatorError.class, () -> {
            locator.setService("B", factoryA);
        });
        Assertions.assertThrows(LocatorError.class, () -> {
            locator.setService("C", factoryA);
        });
        Assertions.assertThrows(LocatorError.class, () -> {
            locator.setService("D", factoryA);
        });
        Assertions.assertThrows(LocatorError.class, () -> {
            locator.setService("S", factoryA);
        });
        Assertions.assertThrows(LocatorError.class, () -> {
            locator.setService("I", factoryA);
        });

        Assertions.assertDoesNotThrow(() -> {
            locator.setService("X", factoryA);
        });
        Assertions.assertDoesNotThrow(() -> {
            locator.setService("Y", factoryA);
        });
        Assertions.assertDoesNotThrow(() -> {
            locator.setService("Z", factoryA);
        });
    }

    @Test
    void setConstant() {
        //setConstant instal·la un valor de tipus Object donant-li un nom (i llença
        //l'excepció LocatorError si ja hi ha alguna cosa enregistrada amb aquest nom)
        Assertions.assertThrows(LocatorError.class, () -> {
            locator.setConstant("I", 5);
        });

        Assertions.assertThrows(LocatorError.class, () -> {
            locator.setConstant("A", 1);
        });
        Assertions.assertThrows(LocatorError.class, () -> {
            locator.setConstant("B", 2);
        });
        Assertions.assertThrows(LocatorError.class, () -> {
            locator.setConstant("C", 3);
        });
        Assertions.assertThrows(LocatorError.class, () -> {
            locator.setConstant("D", 4);
        });
        Assertions.assertThrows(LocatorError.class, () -> {
            locator.setConstant("S", 5);
        });
        Assertions.assertThrows(LocatorError.class, () -> {
            locator.setConstant("I", 6);
        });

        Assertions.assertDoesNotThrow(() -> {
            locator.setConstant("X", 1);
        });
        Assertions.assertDoesNotThrow(() -> {
            locator.setConstant("Y", 2);
        });
        Assertions.assertDoesNotThrow(() -> {
            locator.setConstant("Z", 3);
        });
    }

    @Test
    void getObject() throws LocatorError {
        Factory factor = new FactoryA1();

        assertEquals(5, locator.getObject("I"));
        assertEquals("testing", locator.getObject("S"));

        assertSame(locator.getObject("A"), locator.getObject("A"));
        assertSame(locator.getObject("B"), locator.getObject("B"));
        assertSame(locator.getObject("C"), locator.getObject("C"));
        assertSame(locator.getObject("D"), locator.getObject("D"));
    }
}