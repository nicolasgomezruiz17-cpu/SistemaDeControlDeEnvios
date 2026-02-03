import java.util.Scanner;

public class GestionEnvios {

    Scanner entrada = new Scanner(System.in);
    int contador = 0;
    private int numeroGuia;
    private String cliente;
    private String direccionDestino;
    private String ciudad;
    private double peso;
    private String estado;
    private String conductor;
    private String prioridad;
    private final int[] guias = new int[100];
    private final String[] clientes = new String[100];
    private final String[] direcciones = new String[100];
    private final String[] ciudades = new String[100];
    private final double[] pesos = new double[100];
    private final String[] estados = new String[100];
    private final String[] conductores = new String[100];
    private final String[] prioridades = new String[100];
    private boolean bandera = true;
    private int desicion;
    boolean encontrado = false;
    private int index;
    private String actualizar;


    public void subMenuEnvios(){
        while (bandera){
            System.out.println("-------------------------");
            System.out.println("  Submenu gestión envios ");
            System.out.println("-------------------------");
            System.out.println("1. Registrar nuevo envio ");
            System.out.println("2. Buscar envio          ");
            System.out.println("3. Actualizar estado     ");
            System.out.println("4. Ver todos los envios  ");
            System.out.println("5. Ver envios pendientes ");
            System.out.println("6. Volver                ");
            System.out.println("-------------------------");
            System.out.print(" Seleccione una opción: ");
            System.out.println("-------------------------");
            desicion = entrada.nextInt();
            switch (desicion){
                case 1:
                    registrarNuevoEnvio();
                    break;
                case 2:
                    buscarEnvio();
                    break;
                case 3:
                    actualizarEstado();
                    break;

            }


        }

    }

    public void registrarNuevoEnvio(){
        System.out.println("---------------------------");
        System.out.println("     GESTIÓN DE ENVIOS     ");
        System.out.println("---------------------------");
        System.out.println("Ingrese el número de guia: ");
        numeroGuia = entrada.nextInt();
        entrada.nextLine();
        guias[contador] = numeroGuia;
        System.out.println("Ingrese el nombre del cliente: ");
        cliente = entrada.nextLine();
        clientes[contador] = cliente;
        System.out.println("Ingrese la dirección del destino ");
        direccionDestino = entrada.nextLine();
        direcciones[contador] = direccionDestino;
        System.out.println("Ingrese la ciudad del destino: ");
        ciudad = entrada.nextLine();
        ciudades[contador] = ciudad;
        System.out.println("Ingrese el peso del paquete: ");
        peso = entrada.nextDouble();
        pesos[contador] = peso;
        System.out.println("Ingrese el nombre del conductor ");
        conductor = entrada.nextLine();
        entrada.nextLine();
        conductores[contador] = conductor;
        System.out.println("Ingrese la prioridad del paquete: ");
        prioridad = entrada.nextLine();
        prioridades[contador] = prioridad;
        contador++;
    }

    public void buscarEnvio(){

        System.out.println("Busca el envio por numero de guia o nombre del cliente");
        int busqueda = entrada.nextInt();
        for (int i = 0; i < guias.length; i++) {//falta poner la condicion de buscar por mas items
            if (guias[i] == busqueda){
                encontrado = true;
                index = i;
                System.out.println("Envio encontrado");
                mostrarEnvio();
                break;
            }
        }

    }
    public int getIndex(){
        return index;
    }


    public void actualizarEstado(){
        buscarEnvio();
        System.out.println("Actualiza el estado del envio: ");
        actualizar = entrada.next();
        prioridades[getIndex()] = actualizar;
        System.out.println("Estado actualizado con éxito");

    }

    public void mostrarEnvio(){
        for (int i = 0; i < contador ; i++) {
            System.out.println("Número de guia: " + guias[i] + "\n" + "Nombre del cliente: " + clientes[i] + "\n" + "Dirección del destino: " + direcciones[i] + "\n" + "Ciudad: " + ciudades[i] + "\n" + "Peso del paquete: " + pesos[i] + "\n" + "Conductor Asignado: " + conductores[i] + "\n" + "prioridad del paquete: " + prioridades[i]);
        }
    }




    public int getNumeroGuia() {
        return numeroGuia;
    }

    public String getCliente() {
        return cliente;
    }

    public String getDireccionDestino() {
        return direccionDestino;
    }

    public String getCiudad() {
        return ciudad;
    }

    public double getPeso() {
        return peso;
    }

    public String getEstado() {
        return estado;
    }

    public String getConductor() {
        return conductor;
    }

    public String getPrioridad() {
        return prioridad;
    }

    public int[] getGuias() {
        return guias;
    }

    public String[] getClientes() {
        return clientes;
    }

    public String[] getDirecciones() {
        return direcciones;
    }

    public String[] getCiudades() {
        return ciudades;
    }

    public double[] getPesos() {
        return pesos;
    }

    public String[] getEstados() {
        return estados;
    }

    public String[] getConductores() {
        return conductores;
    }

    public String[] getPrioridades() {
        return prioridades;
    }
}
