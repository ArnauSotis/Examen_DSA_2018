package Principal;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class MathManagerImpl implements MathManager{

    List<Alumno> listaOperacionesAlumno =new ArrayList<Alumno>();
    List<Instituto> listaOperacionesInstituto =new ArrayList<Instituto>();
    ArrayList<Instituto> listaInstitutos =new ArrayList<Instituto>();
    ArrayList<Instituto> listaOrdenadaInstitutos = new ArrayList <Instituto>();
    Logger logger = Logger.getLogger("myLogger");

    public void realizarOperacionPolacaInversa(int numero1){
        Singleton.getInstance().getPolish().procesarPolaca(numero1);
        logger.log(Level.SEVERE,  "Se realiza la operación polaca");
    }
    public int realizarOperacionAlumno(Alumno alumno, int numero1, int numero2, int formula){
        //Sumo la cantidad de operaciones de un alumno y luego realizo la operación, devolviendo el resultado

        for(Alumno nombre: listaOperacionesAlumno){
            if (alumno.getNombre().equals(nombre)) {
                alumno.setNumeroOperaciones();
            }
        }

        if (formula==5){
            realizarOperacionPolacaInversa(numero1);
        return 0;}


        if(formula==1)
            return numero1*numero2;
        else if(formula==2)
            return numero1-numero2;
        else if(formula==3)
            return numero1/numero2;
        else if(formula==4)
            return numero1+numero2;
        else
        {logger.log(Level.SEVERE,  "No se ha indicado bien la formula solicitada");
        return 0;}
    }

    public List<Instituto> listaRankingInstitutos(){

       listaOrdenadaInstitutos =(ArrayList) listaInstitutos.clone();
        Collections.sort(listaOrdenadaInstitutos,Comparator.comparing(Instituto::getNumeroOperaciones));
        Collections.reverse(listaOrdenadaInstitutos);

        return listaOrdenadaInstitutos;


    }

}
