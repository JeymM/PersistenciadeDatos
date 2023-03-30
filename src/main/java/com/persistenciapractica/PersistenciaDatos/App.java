package com.persistenciapractica.PersistenciaDatos;

import Entidades.CuentaAhorro;
import Excepciones.Limites;
import GUI.GUI_Cuenta;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws Limites
    {
       GUI_Cuenta obj=new GUI_Cuenta();
       obj.iniciar();
}
}
