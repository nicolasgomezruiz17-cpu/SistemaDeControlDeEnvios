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
    private int[] guias = new int[100];
    private String[] clientes = new String[100];
    private String[] direcciones = new String[100];
    private String[] ciudades = new String[100];
    private double[] pesos = new double[100];
    private String[] estados = new String[100];
    private String[] conductores = new String[100];
    private String[] prioridades = new String[100];

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

    public void mostrarEnvio(){
        for (int i = 0; i < contador ; i++) {
            System.out.println("Número de guia: " + guias[i] + "\n" + "Nombre del cliente: " + clientes[i] + "\n" + "Dirección del destino: " + direcciones[i] + "\n" + "Ciudad: " + ciudades[i] + "\n" + "Peso del paquete: " + pesos[i] + "\n" + "Conductor Asignado: " + conductores[i] + "\n" + "prioridad del paquete: " + prioridades[i]);
        }
    }
}
