package logic;

import java.util.ArrayList;

/**
 *
 * @author Gabriel Amaya, Cesar Cardozo
 */
public class Partition {

    //------------------ Attributes --------------------------
    private String partitionName;
    private int partitionID;
    private int partitionSize;
    //MIRAR SI ES UNA LISTA O UN SOLO PROCESO
    //IGUAL SOLO SE EJECUTA UNO Y LUEGO SE LIBERA LA PARTICIÓN
    private Process assignedProcess;
    private ArrayList<Process> inputProcesses;
    private ArrayList<Process> executionProcesses;
    private ArrayList<Process> outputListProcesses;
    public Process currentProcess;
    private static int BASE_ID = 1;

    //--------------------- Constructors ------------------------
    /**
     *  CUANDO HAY UNA CONDENSACIÓN, SE LE PASA EL TAMAÑO DE LA NUEVA PARTICIÓN
     * 
     * @param partitionSize
     */
    public Partition(int partitionSize) {
        partitionID = BASE_ID++;
        setPartitionName("PA" + String.valueOf(partitionID));
        this.partitionSize = partitionSize;
        this.inputProcesses = new ArrayList<>();
        this.executionProcesses = new ArrayList<>();
        this.outputListProcesses = new ArrayList<>();
        currentProcess = null;
    }

    /**
     * CUANDO ES HUECO SE LE PONE NULL
     *
     * @param assignedProcess
     */
    public Partition(Process assignedProcess) {

        partitionID = BASE_ID++;
        setPartitionName("PA" + String.valueOf(partitionID));
        this.assignedProcess = assignedProcess;
        this.partitionSize = this.assignedProcess.getProcessSize();
        this.inputProcesses = new ArrayList<>();
        this.executionProcesses = new ArrayList<>();
        this.outputListProcesses = new ArrayList<>();
        currentProcess = null;
    }

    private boolean existNotNull() {
        for (Process process : inputProcesses) {
            if (process.getExecutionTime() > 0) {
                return true;
            }
        }
        return false;
    }

    public Process getNextNotNull() throws Exception {
        for (int i = 0; i < this.inputProcesses.size(); i++) {
            if (this.inputProcesses.get(i).getName().equals(this.currentProcess.getName())) {
                for (int j = i + 1; j < this.inputProcesses.size(); j++) {
                    if (this.inputProcesses.get(j).getExecutionTime() > 0) {
                        currentProcess = this.inputProcesses.get(j);
                        return currentProcess;
                    }
                }
            }
        }
        if (existNotNull()) {
            for (int i = 0; i < this.inputProcesses.size(); i++) {
                if (this.inputProcesses.get(i).getExecutionTime() > 0) {
                    currentProcess = inputProcesses.get(i);
                    return currentProcess;
                }
            }
        }
        currentProcess = null;
        throw new Exception("Se acabaron los procesos");
    }

    public int getTotalExecutionTime() {
        return assignedProcess.getExecutionTime();
    }

    //------------------ Getters & Setters --------------------------
    public Process getAssignedProcess() {
        return assignedProcess;
    }

    public void setAssignedProcess(Process assignedProcess) {
        this.assignedProcess = assignedProcess;
    }

    public String getPartitionName() {
        return partitionName;
    }

    public int getPartitionID() {
        return partitionID;
    }

    public void setPartitionName(String partitionName) {
        this.partitionName = partitionName;
    }

    public int getPartitionSize() {
        return partitionSize;
    }

    public void setPartitionSize(int partitionSize) {
        this.partitionSize = partitionSize;
    }

    public ArrayList<Process> getInputProcesses() {
        return inputProcesses;
    }

    public void setInputProcesses(ArrayList<Process> inputProcesses) {
        this.inputProcesses = inputProcesses;
    }

    @Override
    public String toString() {
        return "{Partition: " + getPartitionName() + System.getProperty("line.separator")
                + "\tProcesses: " + getInputProcesses() + System.getProperty("line.separator")
                + "\tExecution: " + getExecutionProcesses() + System.getProperty("line.separator")
                + "\tOutput: " + getOutputListProcesses() + System.getProperty("line.separator");
    }

    public Process getCurrentProcess() {
        return currentProcess;
    }

    public void setCurrentProcess(Process currentProcess) {
        this.currentProcess = currentProcess;
    }

    public ArrayList<Process> getExecutionProcesses() {
        return executionProcesses;
    }

    public void setExecutionProcesses(ArrayList<Process> executionProcesses) {
        this.executionProcesses = executionProcesses;
    }

    public ArrayList<Process> getOutputListProcesses() {
        return outputListProcesses;
    }

    public void setOutputListProcesses(ArrayList<Process> outputListProcesses) {
        this.outputListProcesses = outputListProcesses;
    }

}
