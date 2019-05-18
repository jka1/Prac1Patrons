package sercicelocatortest;

import factories.*;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import servicelocator.LocatorError;
import servicelocator.SimpleServiceLocator;

class SimpleServiceLocatorTest {


    @BeforeAll
    public void initializer() throws  LocatorError{
        FactoryA1 factoryA = new FactoryA1();
        FactoryB1 factoryB = new FactoryB1();
        FactoryC1 factoryC = new FactoryC1();
        FactoryD1 factoryD = new FactoryD1();

        SimpleServiceLocator locator = new SimpleServiceLocator();
        locator.setService("A",factoryA);
        locator.setService("B",factoryB);
        locator.setService("S",factoryC);
        locator.setService("I",factoryD);
    }


    @Test
    void testsetService() throws LocatorError {
        //setService instal·la una factoria donant-li un nom (i llença l'excepció
        //LocatorError si ja hi ha alguna cosa enregistrada amb aquest nom)

        locator.setService("string1", new FactoryA1());
        locator.setService("string2",new FactoryA1());
        assertEquals("string" , );

    }

    @Test
    void testsetConstant() throws LocatorError{
        //setConstant instal·la un valor de tipus Object donant-li un nom (i llença
        //l'excepció LocatorError si ja hi ha alguna cosa enregistrada amb aquest nom)


    }

    @Test
    void testgetObject() {
        //getObject, si el nom ha estat associat a una constant, retorna l’Object associat i,
        //si ha estat associat a una factoria, retorna l'Object creat per aquesta factoria.
        //Llença l'excepció LocatorError si no hi ha cap cosa sota aquest nom.
        //Fixeu-vos en que, en cas d'estar associat a una factoria, cada vegada que es crida,
        //retorna un objecte diferent.


    }
}