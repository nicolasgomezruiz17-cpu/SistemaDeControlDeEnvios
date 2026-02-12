import java.util.Random;
import java.util.Scanner;

public class GestionEnvios {
    //Clase GestionEnvios procesa los envios, obtiene los datos del envío y gestiona la visualización de los mismos.

    Scanner entrada = new Scanner(System.in);
    private int contador = 0;
    boolean nombreClienteEncontrado = false;
    boolean nombreConductorEncontrado = false;
    boolean ciudadClienteEncontrado = false;
    boolean numeroGuiaEncontrado = false;
    boolean noHayEnviosPendientes = false;
    int seleccionar;
    boolean buscarEnvioflag = true;
    boolean bandera = true;
    private int index; // Almacena la posición del envío encontrado.

    /*
     Arrays paralelos para almacenar hasta 100 envíos
     Todos los datos de un envío comparten el mismo índice.
     */
    private final int[] guias = new int[100];
    private final String[] clientes = new String[100];
    private final String[] direcciones = new String[100];
    private final String[] ciudades = new String[100];
    private final double[] pesos = new double[100];
    private final String[] estados = new String[100];
    private final String[] conductores = new String[100];
    private final String[] prioridades = new String[100];

    //getters
    public double[] getPesos() {
        return pesos;
    }

    public String[] getCiudades() {
        return ciudades;
    }

    public int getContador(){
        return contador;
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

    public String[] getEstados() {
        return estados;
    }

    public String[] getConductores() {
        return conductores;
    }

    public String[] getPrioridades() {
        return prioridades;
    }

    //Métodos
    public void subMenuEnvios(){
        /*
        Muestra las opciones que hay en el menu de gestión de envios, determina que hacer para cada caso.
         */
        int decision;
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
            System.out.println(" Seleccione una opción:  ");
            System.out.println("-------------------------");
            decision = entrada.nextInt();

            switch (decision){
                case 1:
                    registrarNuevoEnvio();
                    break;
                case 2:
                    buscarEnvio();
                    break;
                case 3:
                    actualizarEstado();
                    break;
                case 4:
                    mostrarEnvio();
                    break;
                case 5:
                    enviosPendientes();
                    break;
                case 6:
                    bandera = false;// Termina el ciclo del submenú y regresa al flujo del menú principal.
                    break;

                default:
                    System.out.println("Opción incorrecta seleccione de nuevo" + "\n");


            }


        }

    }

    public void registrarNuevoEnvio(){

        /*
        Crea un nuevo registro con los datos del envío y los guarda en su respectivo array.
         */
        Random numeroGuiaAleatorio = new Random();//Asigna un número aleatorio a la guia.

        System.out.println("---------------------------");
        System.out.println("     GESTIÓN DE ENVIOS     ");
        System.out.println("---------------------------");
        int numeroGuia = numeroGuiaAleatorio.nextInt(5000);
        guias[contador] = numeroGuia;
        System.out.println("Número de guia asignado: " + numeroGuia);
        entrada.nextLine();
        System.out.println("Ingrese el nombre del cliente: ");
        String cliente = entrada.nextLine();
        clientes[contador] = cliente;
        System.out.println("Ingrese la dirección del destino ");
        String direccionDestino = entrada.nextLine();
        direcciones[contador] = direccionDestino;
        System.out.println("Ingrese la ciudad del destino: ");
        String ciudad = entrada.nextLine();
        ciudades[contador] = ciudad;
        pesoAjustado();
        entrada.nextLine();
        String estado = "pendiente";
        estados[contador] = estado;
        System.out.println("Ingrese la prioridad del paquete: ");
        String prioridad = entrada.nextLine();
        prioridades[contador] = prioridad;
        contador++;
    }

    public void validarContador(){

        // Valida el número de registros guardados en memoria.
        if (getContador() == 0){
            System.out.println("No hay envios guardados");
        }
    }


    // Podría usarse un setter en lugar de este método
    public void pesoAjustado() {
        //Valida el peso del envío.
        double peso = 0;
        boolean bandera = true;
        while (bandera){
            System.out.println("Ingrese el peso del paquete: ");
            peso = entrada.nextDouble();
            if (peso <=0){
                System.out.println("El peso debe ser mayor a cero");
            }else{
                bandera = false;
            }
        }
        pesos[contador] = peso;
    }


    public void buscarEnvio(){
        /*
        Recorre los arrays trayendo los datos que hay en ellos según sea la necesidad.
         */
        buscarEnvioflag = true;
        while (buscarEnvioflag){
            System.out.println("Buscar envio:");
            System.out.println("1. Por número de guia");
            System.out.println("2. Nombre de cliente");
            System.out.println("3. Cuidad de destino");
            System.out.println("4. Nombre de conductor");
            System.out.println("5. Volver             ");
            System.out.println("------------------------ ");
            System.out.println("Selecciona una opción: ");
            seleccionar = entrada.nextInt();

            switch (seleccionar) {
                case 1:
                    System.out.println("Ingrese el número de guia:");
                    int busquedaEnvio = entrada.nextInt();
                    validarContador();

                    for (int i = 0; i < getContador(); i++) {
                        if (guias[i] == busquedaEnvio) {

                            System.out.println("Número de guia encontrado");
                            System.out.println("-----------------");
                            System.out.println("Envio #" + (i + 1) + "\n" + "Número de guia: " + guias[i] + "\n" + "Nombre del cliente: " + clientes[i] + "\n" + "Dirección del destino: " + direcciones[i] + "\n" + "Ciudad: " + ciudades[i] + "\n" + "Peso del paquete: " + pesos[i] + "\n" + "Estado del paquete: " + estados[i] + "\n" + "Conductor Asignado: " + conductores[i] + "\n" + "prioridad del paquete: " + prioridades[i] + "\n");
                            System.out.println("-------------------------------------");
                            numeroGuiaEncontrado = true;
                            break;
                    }

                    }
                    if (!numeroGuiaEncontrado) {
                        System.out.println("No se encontraron resultado para su busqueda");
                    }

                    break;

                case 2:

                    System.out.println("Escriba el nombre del cliente: ");
                    entrada.nextLine();

                    String buscarNombre = entrada.nextLine();
                    for (int i = 0; i < getContador(); i++) {
                        if (clientes[i].equalsIgnoreCase(buscarNombre)) {
                            System.out.println("Nombre de cliente encontrado");
                            System.out.println("-----------------");
                            System.out.println("Envio #" + (i + 1) + "\n" + "Número de guia: " + guias[i] + "\n" + "Nombre del cliente: " + clientes[i] + "\n" + "Dirección del destino: " + direcciones[i] + "\n" + "Ciudad: " + ciudades[i] + "\n" + "Peso del paquete: " + pesos[i] + "\n" + "Estado del paquete: " + estados[i] + "\n" + "Conductor Asignado: " + conductores[i] + "\n" + "prioridad del paquete: " + prioridades[i] + "\n");
                            System.out.println("-------------------------------------");
                            nombreClienteEncontrado = true;
                            break;
                        }
                    }
                    if (!numeroGuiaEncontrado) {
                        System.out.println("No se encontraron resultado para su busqueda");
                    }
                    break;

                case 3:
                    System.out.println("Escriba la ciudad del envio: ");
                    entrada.nextLine();
                    String buscarCiudad = entrada.nextLine();
                    for (int i = 0; i < getContador(); i++) {
                        if (ciudades[i].equalsIgnoreCase(buscarCiudad)) {
                            System.out.println("Ciudad cliente encontrado");
                            System.out.println("-----------------");
                            System.out.println("Envio #" + (i + 1) + "\n" + "Número de guia: " + guias[i] + "\n" + "Nombre del cliente: " + clientes[i] + "\n" + "Dirección del destino: " + direcciones[i] + "\n" + "Ciudad: " + ciudades[i] + "\n" + "Peso del paquete: " + pesos[i] + "\n" + "Estado del paquete: " + estados[i] + "\n" + "Conductor Asignado: " + conductores[i] + "\n" + "prioridad del paquete: " + prioridades[i] + "\n");
                            System.out.println("-------------------------------------");
                            ciudadClienteEncontrado = true;
                            break;
                        }
                    }
                    if (!ciudadClienteEncontrado) {
                        System.out.println("No se encontraron resultado para su busqueda");
                    }
                    break;
                case 4:
                    System.out.println("Escriba el nombre del conductor: ");
                    entrada.nextLine();
                    String buscarConductor = entrada.nextLine();
                    for (int i = 0; i < getContador(); i++) {
                        if (conductores[i].equalsIgnoreCase(buscarConductor)) {

                            System.out.println("Nombre de conductor encotrado");
                            System.out.println("-----------------");
                            System.out.println("Envio #" + (i + 1) + "\n" + "Número de guia: " + guias[i] + "\n" + "Nombre del cliente: " + clientes[i] + "\n" + "Dirección del destino: " + direcciones[i] + "\n" + "Ciudad: " + ciudades[i] + "\n" + "Peso del paquete: " + pesos[i] + "\n" + "Estado del paquete: " + estados[i] + "\n" + "Conductor Asignado: " + conductores[i] + "\n" + "prioridad del paquete: " + prioridades[i] + "\n");
                            System.out.println("-------------------------------------");
                            nombreConductorEncontrado = true;
                            break;
                        }
                    }
                    if (!nombreConductorEncontrado) {
                        System.out.println("no se encontraron resultado para su busqueda");
                    }
                    break;
                case 5:
                    buscarEnvioflag = false;
                    break;

                default:
                    System.out.println("Opción incorrecta");

            }


        }

    }


    public void actualizarEstado(){
        /*
        Actualiza el estado de los envios.
         */
        System.out.println("Ingrese el número de guia:");
        validarContador();
        int buscarNumeroGuia = entrada.nextInt();

        for (int i = 0; i < getContador(); i++) {
            if (guias[i] == buscarNumeroGuia) {

                System.out.println("Número de guia encontrado");
                System.out.println("-----------------");
                System.out.println("Envio #" + (i + 1) + "\n" + "Número de guia: " + guias[i] + "\n" + "Nombre del cliente: " + clientes[i] + "\n" + "Dirección del destino: " + direcciones[i] + "\n" + "Ciudad: " + ciudades[i] + "\n" + "Peso del paquete: " + pesos[i] + "\n" + "Estado del paquete: " + estados[i] + "\n" + "Conductor Asignado: " + conductores[i] + "\n" + "prioridad del paquete: " + prioridades[i] + "\n");
                System.out.println("-------------------------------------");
                numeroGuiaEncontrado = true;
                index = i;
                break;
            }
            if (numeroGuiaEncontrado) {
                System.out.println("No se encontraron resultado para su busqueda");
            }

        }
        System.out.println("Actualiza el estado del envio: " + "\n" + "PENDIENTE \n EN RUTA \n ENTREGADO");
        String actualizar = entrada.next();
        estados[index] = actualizar;
        System.out.println("Estado actualizado con éxito");

    }


    public void mostrarEnvio(){
        /*
        Mostrar información de todos los valores guardados en los arrays correspondientes a envios.
         */
        validarContador();
        for (int i = 0; i < getContador() ; i++) {
            System.out.println("Envio #"+(i+1)+ "\n" + "Número de guia: " + guias[i] + "\n" + "Nombre del cliente: " + clientes[i] + "\n" + "Dirección del destino: " + direcciones[i] + "\n" + "Ciudad: " + ciudades[i] + "\n" + "Peso del paquete: " + pesos[i] + "\n" + "Estado del paquete: "+ estados[i] + "\n" + "Conductor Asignado: " + conductores[i] + "\n" + "prioridad del paquete: " + prioridades[i]);
            System.out.println("-------------------------------------");
        }
    }


    public void enviosPendientes(){
        /*
        Valida los registros de los envios que tienen estado pendiente.
         */

        for (int i = 0; i < getContador(); i++) {
            if (estados[i].equalsIgnoreCase("Pendiente")){
                System.out.println("Envio #"+(i+1)+ "\n" + "Número de guia: " + guias[i] + "\n" + "Nombre del cliente: " + clientes[i] + "\n" + "Dirección del destino: " + direcciones[i] + "\n" + "Ciudad: " + ciudades[i] + "\n" + "Peso del paquete: " + pesos[i] + "\n" + "Estado del paquete: "+ estados[i] + "\n" + "Conductor Asignado: " + conductores[i] + "\n" + "prioridad del paquete: " + prioridades[i]);
                System.out.println("-------------------------------------");
                noHayEnviosPendientes = true;

            } else if (noHayEnviosPendientes) {
                System.out.println("no hay envios pendientes");
            }


        }

    }


}
