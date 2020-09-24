/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Implement;

import Interface.CalcInterface;
import java.rmi.RemoteException;
import java.rmi.server.RemoteRef;
import java.rmi.server.UnicastRemoteObject;

/**
 *
 * @author Administrador
 */
public class CalcImplement extends UnicastRemoteObject implements CalcInterface {

    public int numEmple;
    public int numMese;    
    public int salario;    

    public int getSalario() {
        return salario;
    }

    public void setSalario(int salario) {
        this.salario = salario;
    }
    
    public int getNumEmple() {
        return numEmple;
    }

    public void setNumEmple(int numEmple) {
        this.numEmple = numEmple;
    }

    public int getNumMese() {
        return numMese;
    }

    public void setNumMese(int numMese) {
        this.numMese = numMese;
    }

    public RemoteRef getRef() {
        return ref;
    }

    public void setRef(RemoteRef ref) {
        this.ref = ref;
    } 
    
    
    public CalcImplement(int numEmple, int numMese, int salario) throws RemoteException {
        this.numEmple = numEmple;
        this.numMese = numMese;
        this.salario = salario;
    }

    @Override
    public int calculate(int emp, int meses, int choice) throws RemoteException {
        switch (choice) {
            case 1:
                return (numMese* salario)/numEmple; //Total pagado a cada empleado
            case 2:
                return numEmple + numMese;//promedio de cada mes por pago de salario
            case 3:
                return (numEmple * numMese*salario);//Total salario
            default:
                System.out.print("ERROR");
                return 0;
        }
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
