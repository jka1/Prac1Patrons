package servicelocatortest;

import factories.FactoryA1;
import factories.FactoryB1;
import factories.FactoryC1;
import factories.FactoryD1;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import servicelocator.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SimpleServiceLocatorTest {
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

        locator = new SimpleServiceLocator();

        locator.setService("A", factoryA);
        locator.setService("B", factoryB);
        locator.setService("C", factoryC);
        locator.setService("D", factoryD);

        locator.setConstant("S", "testing");
        locator.setConstant("I", 5);

    }

    @Test
    void testsetService() throws LocatorError {
        //setService instal·la una factoria donant-li un nom (i llença l'excepció
        //LocatorError si ja hi ha alguna cosa enregistrada amb aquest nom)
        factoryA = new FactoryA1();

        //assertEquals(5,locator.setService("I"););
        //ssertEquals("testing",locator.setService("S"););
        Assertions.assertThrows(LocatorError.class, () -> {
            locator.setService("A", factoryA);
        });
        Assertions.assertThrows(LocatorError.class, () -> {
            locator.setService("B", factoryB);
        });
        Assertions.assertThrows(LocatorError.class, () -> {
            locator.setService("C", factoryC);
        });
        Assertions.assertThrows(LocatorError.class, () -> {
            locator.setService("D", factoryD);
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
    void testsetConstant() throws LocatorError {
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
    void testgetObject() throws LocatorError {
        //getObject, si el nom ha estat associat a una constant, retorna l’Object associat i,
        //si ha estat associat a una factoria, retorna l'Object creat per aquesta factoria.
        //Llença l'excepció LocatorError si no hi ha cap cosa sota aquest nom.
        //Fixeu-vos en que, en cas d'estar associat a una factoria, cada vegada que es crida,
        //retorna un objecte diferent.
        Factory factor = new FactoryA1();

        assertEquals(5, locator.getObject("I"));
        assertEquals("testing", locator.getObject("S"));

        Assertions.assertThrows(LocatorError.class, () -> {
            locator.getObject("test");
        });

        Assertions.assertDoesNotThrow(() -> {
            locator.getObject("A");
        });
        Assertions.assertDoesNotThrow(() -> {
            locator.getObject("B");
        });
        Assertions.assertDoesNotThrow(() -> {
            locator.getObject("C");
        });
        Assertions.assertDoesNotThrow(() -> {
            locator.getObject("D");
        });
    }
}