import java.util.Scanner;
public class MenuPrincipal {
    /*
    Clase MenuPrincipal muestra el menu principal con el que el usuario estará interactuando,
    esta clase al mismo tiempo procesa subclases, las cuales implementan la lógica
    para que el sistema funcione acorde a las especificaciones del proyecto.
     */

    // Atributos para el funcionamiento de la clase.
    private boolean bandera = true;
    Scanner entrada = new Scanner(System.in);

    //Inicialización de las clases necesarias para el menu principal.
    GestionEnvios gestionEnvios = new GestionEnvios();
    GestionConductores gestionConductores = new GestionConductores();
    GestionDeRutas gestionDeRutas =  new GestionDeRutas(gestionEnvios, gestionConductores);


    public void menuPrincipal(){

        //Método para presentar el menu principal al usuario.

        int decision;

        do {

            System.out.println(
                    "--------------------------\n" +
                            "      Menu principal      \n" +
                            "--------------------------\n" +
                            "  1. Gestión de envios    \n" +
                            "  2. Gestión de rutas     \n" +
                            "  3. Gestión de conductores\n" +
                            "  4. Reportes y estadisticas\n" +
                            "  5. Salir                \n" +
                            "--------------------------\n" +
                            "Elija una opción: "
            );

            decision = entrada.nextInt();

            // Valida el número ingresado por el usuario
                switch (decision){
                    //Despliega las clases según la decisión del usuario.
                    case 1 :
                        gestionEnvios.subMenuEnvios();
                        break;

                    case 2:
                        gestionDeRutas.subMenuRutas();
                        break;
                    case 3:
                        gestionConductores.registrarConductor();
                        break;
                    case 5:
                        bandera = false;
                        break;
                    default:
                        System.out.println("ingrese una opción valida");
                }


        }while (bandera);

        System.out.println("Saliste del programa");
    }

}
