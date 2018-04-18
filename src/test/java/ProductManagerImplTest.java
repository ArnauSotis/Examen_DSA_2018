//package test.java;

import Principal.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertNull;

public class ProductManagerImplTest {

    MathManager mm = null;

    @Before
    public void setUp() {
        //this.p = Singleton.getInstance().getImpl();
        mm = Singleton.getInstance().getMi();
        Alumno arnau = new Alumno();
        arnau.setNombre("Arnau");
        arnau.setNumeroOperaciones();

        Alumno david = new Alumno();
        david.setNombre("David");
        david.setNumeroOperaciones();
        david.setNumeroOperaciones();

        Alumno ruben = new Alumno();
        ruben.setNombre("Ruben");
        ruben.setNumeroOperaciones();
        ruben.setNumeroOperaciones();
        ruben.setNumeroOperaciones();

        Instituto castelldefels = new Instituto();
        castelldefels.setAlumnos(arnau);
        castelldefels.setNombre("IES Castelldefels");

        Instituto barcelona = new Instituto();
        barcelona.setAlumnos(david);
        barcelona.setNombre("IES Barcelona");

        Instituto santboi = new Instituto();
        santboi.setAlumnos(ruben);
        santboi.setNombre("IES Sant Boi");

    }

    @After
    public void tearDown() {
        mm=null;
    }


    @Test
    public void operacionMatematica() {

        Alumno arnau = new Alumno();

        assertEquals(Singleton.getInstance().getMi().realizarOperacionAlumno(arnau, 1, 2, 1),2);
        assertEquals(Singleton.getInstance().getMi().realizarOperacionAlumno(arnau, 2, 2, 2),0);
        assertEquals(Singleton.getInstance().getMi().realizarOperacionAlumno(arnau, 2, 2, 3),1);
        assertEquals(Singleton.getInstance().getMi().realizarOperacionAlumno(arnau, 5, 5, 4),10);
    }

    @Test
    public void reversePolishNotation() {

        assertEquals(Singleton.getInstance().getPolish().procesarPolaca(0),0);
    }



}
