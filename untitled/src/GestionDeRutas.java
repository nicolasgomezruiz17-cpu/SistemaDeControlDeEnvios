import java.util.Random;
import java.util.Scanner;

public class GestionDeRutas {

    /*
    Clase GestionDeRutas procesa las rutas de los envios
     */

    Scanner entrada = new Scanner(System.in);
    private int numeroRuta;
    private String conductor;
    private String vehiculo;
    private int ciudad;
    private int cantidadEnvios;
    private double distanciaEstimada;
    private String estado;
    Random nRuta = new Random();
    GestionEnvios gestionEnvios;
    private double suma = 0;
    private boolean comprabarCiudad = true;
    GestionConductores gestionConductores;

    //Obtiene los metodos y variables de las otras clases
    public GestionDeRutas(GestionEnvios gestionEnvios, GestionConductores gestionConductores){
        this.gestionEnvios = gestionEnvios;
        this.gestionConductores = gestionConductores;
    }

    //Getters
    public String getConductor() {
        return conductor;
    }

    public int getCiudad() {
            return ciudad;
    }

    public void subMenuRutas(){
        //Método donde se representan las opciones que tiene el menu de esta clase.
        boolean bandera = true;
        while (bandera){
            System.out.println("-------------------------");
            System.out.println("  Submenu gestión Rutas  ");
            System.out.println("-------------------------");
            System.out.println("1. Crear ruta nueva      ");
            System.out.println("2. Ver rutas del dia     ");
            System.out.println("3. Asignar envios a rutas ");
            System.out.println("4. Calcular distacia total");
            System.out.println("5. Volver                ");
            System.out.println("-------------------------");
            System.out.println(" Seleccione una opción:  ");
            System.out.println("-------------------------");
            int eleccion = entrada.nextInt();

            switch (eleccion){
                case 1:
                    // Revisa y devuelve solo las ciudades gurdadas en memoria
                    String [] ciudadSeleccionada = gestionEnvios.getCiudades();
                    while (comprabarCiudad){
                        entrada.nextLine();
                        System.out.println("Selecciona la ciudad: ");
                        for (int i = 0; i < gestionEnvios.getContador(); i++) {
                            System.out.println("Ciudad #"+(i+1) + " " + gestionEnvios.getCiudades()[i]);
                        }
                        ciudad = entrada.nextInt();
                        System.out.println();
                        ciudadSeleccionada [ciudad-1] = gestionEnvios.getCiudades()[ciudad-1];
                        if (ciudad > gestionEnvios.getContador() || ciudad < 0){
                            System.out.println("Selecciona una opción correcta ");
                        }else{
                            break;
                        }
                    }
                    //Comprueba la ciudad seleccionada y obtiene los datos del envío ligado a ella.
                    System.out.println("Envios a la Ciudad: " + ciudadSeleccionada[ciudad-1]);
                    System.out.println("-----------------------------------------");
                    for (int i = 0; i < gestionEnvios.getContador(); i++) {
                        if (ciudadSeleccionada[i].equalsIgnoreCase(ciudadSeleccionada[ciudad-1])){
                            System.out.println("Envio #" + (i + 1) + "\n" + "Número de guia: " + gestionEnvios.getGuias()[i] + "\n" + "Nombre del cliente: " + gestionEnvios.getClientes()[i] + "\n" + "Dirección del destino: " + gestionEnvios.getDirecciones()[i] + "\n" + "Ciudad: " + gestionEnvios.getCiudades()[i] + "\n" + "Peso del paquete: " + gestionEnvios.getPesos()[i] + "\n" + "Estado del paquete: " + gestionEnvios.getEstados()[i] + "\n" + "Conductor Asignado: " + gestionEnvios.getConductores()[i] + "\n" + "prioridad del paquete: " + gestionEnvios.getPrioridades()[i] + "\n");
                            System.out.println("-------------------------------------");
                        }
                    }
                    //Visualiza los nombres de los conductores que están registrados.
                    System.out.println("Seleccione un conductor disponible");
                    gestionConductores.mostrarConductores();
                    entrada.nextLine();
                    conductor = entrada.nextLine();
                    asignarConductor();

                    gestionEnvios.getPesos();
                    for (int i = 0; i < gestionEnvios.getPesos().length; i++) {
                        suma+= gestionEnvios.getPesos()[i];
                    }
                    if (suma <= 800){
                        System.out.println("Se asigna una CAMIONETA");
                    }else if(suma<= 3500){
                        System.out.println("Se asigna un CAMION");
                    }else{
                        System.out.println("Se asigna una TRACTOMULA");
                    }

                case 5:
                    bandera = false;
                    break;

            }
        }
    }



    public void asignarConductor() {
        // Asignar el conductor a todos los envíos de la ciudad seleccionada
        gestionEnvios.getConductores()[(getCiudad()-1)] = getConductor();
        System.out.println("Conductor asignado exitosamente a los envíos de " + gestionEnvios.getCiudades()[ciudad-1]);
    }

}
