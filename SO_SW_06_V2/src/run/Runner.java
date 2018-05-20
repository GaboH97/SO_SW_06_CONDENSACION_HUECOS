package run;

import controller.Controller;
import logic.ProcessManager;

/**
 * Clase que ejecuta el programa
 *
 * @author Cesar Cardozo y Gabriel Amaya
 */
public class Runner {

    public static void main(String[] args) {

        ProcessManager pm = new ProcessManager();

        pm.addProcess(ProcessManager.createProcess("p11", 11, 5));
        pm.addProcess(ProcessManager.createProcess("p15", 15, 7));
        pm.addProcess(ProcessManager.createProcess("p18", 18, 8));
        pm.addProcess(ProcessManager.createProcess("p6", 6, 3));
        pm.addProcess(ProcessManager.createProcess("p9", 9, 4));
        pm.addProcess(ProcessManager.createProcess("p20", 20, 2));
        pm.addProcess(ProcessManager.createProcess("p13", 13, 3));

        //pm.processProcesses();
        System.out.println(pm.toString());

        Controller controller = Controller.getInstance(pm);
    }
}
