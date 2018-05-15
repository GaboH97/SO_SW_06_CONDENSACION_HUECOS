package logic;

import java.util.ArrayList;
import java.util.Collections;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Clase que representa el manejador de procesos. Se encarga de crear, agregar y
 * atender cada uno de los procesos de acuerdo a sus características. Su modo de
 * atención es FIFO (First Input, First Output), teniendo prelación sobre
 * aquellos procesos que no están bloqueados.
 *
 * @author Cesar Cardozo & Gabriel Amaya
 */
public class ProcessManager {

    //------------------------ Atributos -----------------------------
    public static final int DEFAULT_QUANTUM = 5;
    private ArrayList<Process> input_ProcessList;
    private ArrayList<Process> unprocessed_ProcessList;
    private ArrayList<Partition> output_PartitionList;
    private ArrayList<Partition> partitionsList;

    private int quantum;

    //------------------------ Constructores -----------------------------
    public ProcessManager() {
        this.quantum = DEFAULT_QUANTUM;
        this.input_ProcessList = new ArrayList<>();
        this.output_PartitionList = new ArrayList<>();
        this.partitionsList = new ArrayList<>();
        this.unprocessed_ProcessList = new ArrayList<>();
    }

    //------------------------ Métodos -----------------------------
    /**
     * Agregar un nuevo proceso al manejador de procesos. En un principio, lo
     * agrega a la lista de procesos de entrada, luego a la lista de procesos
     * listos y por último lo despacha (lo que indica que también lo agrega a la
     * lista de procesos en ejecución). Adicionalmente revisa si el proceso está
     * bloqueado y si lo está, lo agrega a la lista de procesos bloqueados
     *
     * @param p El proceso a ser agregado
     * @return true si el proceso fue agregado, de lo contrario, false
     */
    public boolean addProcess(Process p) {
        //Busca en la lista de procesos de entrada si existe un proceso con el 
        //mismo nombre, si no, lo agrega a la lista de procesos de entrada, lista
        //procesos listos y hace la transisiónde despachado
        try {
            searchProcess(p.getName(), input_ProcessList);
            return false;
        } catch (Exception e) {
            try {
                input_ProcessList.add(p);
                return true;
            } catch (Exception ex) {
                return false;
            }
        }
    }

    /**
     * Agregar un nuevo proceso al manejador de procesos. En un principio, lo
     * agrega a la lista de procesos de entrada, luego a la lista de procesos
     * listos y por último lo despacha (lo que indica que también lo agrega a la
     * lista de procesos en ejecución). Adicionalmente revisa si el proceso está
     * bloqueado y si lo está, lo agrega a la lista de procesos bloqueados
     *
     * @param par El proceso a ser agregado
     * @return true si el proceso fue agregado, de lo contrario, false
     */
    public boolean addPartition(Partition par) {
        //Busca en la lista de procesos de entrada si existe un proceso con el 
        //mismo nombre, si no, lo agrega a la lista de procesos de entrada, lista
        //procesos listos y hace la transisiónde despachado
        try {
            searchPartition(par.getPartitionName());
            return false;
        } catch (Exception e) {
            partitionsList.add(par);
            return true;
        }
    }

    /**
     *
     * @param name El nombre el proceso
     * @param executionTime El tiempo de ejecución del proceso
     * @param processSize Tamaño ocupado por el proceso
     * @param belongingPartition Partición en la que está contenido el proceso
     * @return Una nueva instancia de la clase Proceso con los datos ingresados
     */
    public static Process createProcess(String name, int processSize, int executionTime) {
        return new Process(name, processSize, executionTime);
    }

    /**
     *
     * @param partitionName
     * @param partitionSize
     * @return Una nueva instancia de la clase Proceso con los datos ingresados
     */
    public static Partition createPartition(String partitionName, int partitionSize) {
        return new Partition(partitionName, partitionSize);
    }

    /**
     * Método que procesa los procesos
     */
    public void asignProcesses() {
        int currentPartitionIndex = 0;
        for (Process process : input_ProcessList) {
            boolean added = false;
            int counter = 0;
            while (!added && counter != partitionsList.size()) {
                if (partitionsList.get(currentPartitionIndex).getPartitionSize() >= process.getProcessSize()) {
                    partitionsList.get(currentPartitionIndex++).getInputProcesses().add(process);
                    added = true;
                    counter = 0;
                    currentPartitionIndex = (currentPartitionIndex == partitionsList.size()) ? 0 : currentPartitionIndex;
                } else {
                    counter++;
                    currentPartitionIndex++;
                    currentPartitionIndex = (currentPartitionIndex == partitionsList.size()) ? 0 : currentPartitionIndex;
                }
            }
            if (!added) {
                unprocessed_ProcessList.add(process);
            }
        }
    }

    public void processProcesses() {
        asignProcesses();
        do {
            for (Partition partition : partitionsList) {
                if (partition.getInputProcesses().size() != partition.getOutputListProcesses().size()) {
                    if (partition.getCurrentProcess() == null) {
                        partition.setCurrentProcess(partition.getInputProcesses().get(0));
                    }
                    try {
                        Process p = partition.getCurrentProcess();
                        p.setExecutionTime(p.getExecutionTime() - quantum);
                        partition.getExecutionProcesses().add(p);
                        if (p.getExecutionTime() <= 0) {
                            partition.getOutputListProcesses().add(p);
                            if (partition.getInputProcesses().size() == partition.getOutputListProcesses().size() 
                                    && !output_PartitionList.contains(partition)) {
                                output_PartitionList.add(partition);
                            }
                        }
                        if (partition.getInputProcesses().size() != partition.getOutputListProcesses().size()) {
                            partition.getNextNotNull();
                        }
                    } catch (Exception ex) {
                        ex.printStackTrace();//aca no debe entrar
                    }
                } else {
                    if (!output_PartitionList.contains(partition)) {
                        output_PartitionList.add(partition);
                    }
                }
            }
        }
        while (!ended());
    }

    public boolean ended() {
        for (Partition partition : partitionsList) {
                            System.out.println(partition.getPartitionName() + ": " + partition.getInputProcesses().size() +"-" +partition.getOutputListProcesses().size());

            if (partition.getInputProcesses().size() != partition.getOutputListProcesses().size()) {
                return false;
            }
        }
        return true;
    }

    /**
     *
     * @param originList Lista de origen
     * @param name Nombre del proceso
     * @param destinationList Lista de destino
     */
    public void doTransition(ArrayList destinationList, String name, ArrayList originList) {
        try {
            destinationList.add(searchProcess(name, originList));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Busca el proceso con el nombre especificado dentro de la lista
     * especifica- da
     *
     * @param name Nombre del proceso
     * @param list Lista en la cual debe buscar el proceso
     * @return El proceso con el nombre especificado, null si no lo encontró
     */
    public Process searchProcess(String name, ArrayList<Process> list) throws Exception {
        for (Process process : list) {
            if (process.getName().equals(name)) {
                return process;
            }
        }
        throw new Exception("No se pudo encontrar el proceso: " + name + ", en la lista: " + list.toString());
    }

    /**
     * Busca el proceso con el nombre especificado dentro de la lista
     * especifica- da
     *
     * @param name Nombre del proceso
     * @return El proceso con el nombre especificado, null si no lo encontró
     */
    public Partition searchPartition(String name) throws Exception {
        for (Partition partition : partitionsList) {
            if (partition.getPartitionName().equals(name)) {
                return partition;
            }
        }
        throw new Exception("No se pudo encontrar la partición: " + name);
    }

    public Object[] getPartitionTableHeaders() {
        ArrayList<String> partitionsHeaders = new ArrayList<>();
        for (Partition partition : partitionsList) {
            partitionsHeaders.add("Part. " + partition.getPartitionName());
        }

        return partitionsHeaders.toArray();
    }

    //---------------- Getters & Setters -----------------------
    public ArrayList<Process> getInput_ProcessList() {
        return input_ProcessList;
    }

    public ArrayList<Partition> getOutput_PartitionsList() {
        return output_PartitionList;
    }

    public double getQuantum() {
        return quantum;
    }

    public ArrayList<Process> getUnprocessed_ProcessList() {
        return unprocessed_ProcessList;
    }

    public ArrayList<Partition> getPartitionsList() {
        return partitionsList;
    }

    @Override
    public String toString() {
        String todo = "ProcessManager{\n" + "\n input_ProcessList=" + input_ProcessList
                + "\n unprocessed_ProcessList=" + unprocessed_ProcessList
                + "\n salida partitions =" + output_PartitionList
                + "\n paso por =";
        for (Partition partition : partitionsList) {
            todo += partition.getPartitionName() + ": " + partition.getInputProcesses() + " -";

        }

        return todo;
    }

    public void setQuantum(int quantum) {
        this.quantum = quantum;
    }
}
