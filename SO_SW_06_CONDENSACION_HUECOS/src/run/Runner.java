package run;

import logic.ProcessManager;
import controller.Controller;
import logic.Partition;

/**
 * Clase que ejecuta el programa
 *
 * @author Cesar Cardozo y Gabriel Amaya
 */
public class Runner {

    public static void main(String[] args) {

        ProcessManager pm = new ProcessManager();
//        Partition pa = new Partition("A", 30);
//        Partition pb = new Partition("B", 20);
//        Partition pc = new Partition("C", 40);
//        Partition pd = new Partition("D", 10);
//
//        pm.addPartition(pa);
//        pm.addPartition(pb);
//        pm.addPartition(pc);
//        pm.addPartition(pd);
//
//        pm.addProcess(pm.createProcess("p1", 15, 10));
//        pm.addProcess(pm.createProcess("p2", 30, 10));
//        pm.addProcess(pm.createProcess("p3", 25, 10));
//        pm.addProcess(pm.createProcess("p4", 45, 10));
//        pm.addProcess(pm.createProcess("p5", 60, 5));
//        pm.addProcess(pm.createProcess("p6", 50, 5));
//        pm.addProcess(pm.createProcess("p7", 22, 5));
//        pm.addProcess(pm.createProcess("p8", 10, 5));
//        pm.addProcess(pm.createProcess("p9", 8, 3));
//        pm.addProcess(pm.createProcess("p10", 9, 3));
        
//        Partition pa = new Partition("par1", 30);
//        Partition pb = new Partition("par2", 40);
//        Partition pc = new Partition("par3", 60);
//        Partition pd = new Partition("par4", 20);
//        Partition pe = new Partition("par5", 10);
//        Partition pD = new Partition("par6", 50);
//
//        pm.addPartition(pa);
//        pm.addPartition(pb);
//        pm.addPartition(pc);
//        pm.addPartition(pd);
//        pm.addPartition(pe);
//        pm.addPartition(pD);
//
//        pm.addProcess(pm.createProcess("p5", 5, 10));
//        pm.addProcess(pm.createProcess("p45", 45, 5));
//        pm.addProcess(pm.createProcess("p65", 65, 6));
//        pm.addProcess(pm.createProcess("p28", 28, 12));
//        pm.addProcess(pm.createProcess("p46", 46, 15));
//        pm.addProcess(pm.createProcess("p18", 18, 20));
//        pm.addProcess(pm.createProcess("p58", 58, 18));
//        pm.addProcess(pm.createProcess("p37", 37, 19));
//        pm.addProcess(pm.createProcess("p56", 56, 17));
//        pm.addProcess(pm.createProcess("p25", 25, 22));
//        pm.addProcess(pm.createProcess("p12", 12, 9));
//        System.out.println(pm.toString());
        Controller controller = Controller.getInstance(pm);
    }
}
