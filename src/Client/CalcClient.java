/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Client;

import Implement.CalcImplement;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Administrador
 */
public class CalcClient {

    public static void main(String[] args) throws IOException {
        int numEmpleados, meses, res, choice = 0;
        int salario = (int) (Math.random() * 1000000)+1;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        do {

            System.out.println("1. Total pagado a empleados");
            System.out.println("2. Promedio de cada mes");
            System.out.println("3. Total pagado");
            System.out.println("4. Salir");
            choice = Integer.parseInt(br.readLine());

            if (choice != 4) {
                try {
                    System.out.println("Ingrese el numero de empleados");
                    numEmpleados = Integer.parseInt(br.readLine());
                    System.out.println("ingrese numero de meses trabajados");
                    meses = Integer.parseInt(br.readLine()); 
                    System.out.println("Salario"+salario);
                    //CalInterface c= (CalcInterface)Naming.lookup("Calc");
                    //Remote lookup = Naming.lookup("Calc");
                    //CalcInterface c = (CalcInterface)Naming.lookup("Calc");

                    Remote lookup = Naming.lookup("Calc");
                    CalcImplement calcImplement = new CalcImplement(numEmpleados, meses, salario);

                    res = calcImplement.calculate(numEmpleados, meses, choice);
                    System.out.println("Resultado" + res);

                } catch (NotBoundException ex) {
                    Logger.getLogger(CalcClient.class.getName()).log(Level.SEVERE, null, ex);
                } catch (MalformedURLException ex) {
                    Logger.getLogger(CalcClient.class.getName()).log(Level.SEVERE, null, ex);
                } catch (RemoteException ex) {
                    Logger.getLogger(CalcClient.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            
        }while (choice != 4);        
    }
  }
