/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interface;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 *
 * @author Administrador
 */
public interface CalcInterface extends Remote{
    public int calculate(int a , int b, int choice) throws RemoteException;
}
