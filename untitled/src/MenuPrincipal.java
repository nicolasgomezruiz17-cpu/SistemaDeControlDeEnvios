import java.util.Scanner;

public class MenuPrincipal {
    private int decision;
    private boolean bandera = true;
    Scanner entrada = new Scanner(System.in);
    GestionEnvios gestionEnvios = new GestionEnvios();
    public MenuPrincipal(){
    }
    public int menuPrincipal(){
        do {
            System.out.println("--------------------------");
            System.out.println("      Menu principal      ");
            System.out.println("--------------------------");
            System.out.println("  1.Gestión de rutas      ");
            System.out.println("  2.Menu principal        ");
            System.out.println("  3.Gestión de conductores");
            System.out.println("  4.Reportes y estadisticas     ");
            System.out.println("  5.Salir                 ");
            System.out.println("--------------------------");
            System.out.println("Eliga una opción: ");
            decision = entrada.nextInt();
            if (decision <=0 || decision >5){
                bandera = false;
            }else{
                switch (decision){
                    case 1 :
                        gestionEnvios.registrarNuevoEnvio();
                        break;

                    case 2:
                        gestionEnvios.mostrarEnvio();
                }
            }

        }while (bandera);
        System.out.println("Saliste del programa");
        return decision;
    }

    public int getDecision(){
        return decision;
    }
}
