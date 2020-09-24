/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Server;

import Implement.CalcImplement;
import java.rmi.AccessException;
import java.rmi.AlreadyBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Administrador
 */
public class CalcServer {

    public static void main(String[] args) throws RemoteException {
        try {
            Registry reg=LocateRegistry.createRegistry(1099);
            CalcImplement calcImplement=new CalcImplement(0,0,0);
            //nombre del objetp
            reg.bind("Calc", calcImplement);
            System.out.println("Servidor iniciado");
        } catch (AlreadyBoundException ex) {
            Logger.getLogger(CalcServer.class.getName()).log(Level.SEVERE, null, ex);
        } catch (AccessException ex) {
            Logger.getLogger(CalcServer.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
