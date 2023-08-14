import java.util.Random;
import java.util.Scanner;

public class ComprarTickets {
    public static void main(String[] args) {
        //Se definen las varariables que se van a usar en mas de una de las opciones.
        Scanner sc = new Scanner(System.in);
        Random random = new Random();
        int localidad1 = 20;
        int localidad2 = 20;
        int localidad3 = 20;
        int tickets_total = 0;
        int presupuesto = 0;
        int ticket_solicitado = 0;
        String nombre = "Registrar usuario porfavor";
        int boletos_vendidos_localidad1 = 0;
        int boletos_vendidos_localidad2 = 0;
        int boletos_vendidos_localidad3 = 0;


        int opcion1;
        boolean salir = false;

        //Menu con todas las opciones
        while (!salir) {
            System.out.println("Venta de tickets para TAYLOR SWIFT \nUsuario: " + nombre);
            System.out.println("1. Nuevo comprador");
            System.out.println("2. Nueva solicitud de boletos");
            System.out.println("3. Consultar disponibilidad total");
            System.out.println("4. Consultar disponibilidad individual");
            System.out.println("5. Reporte de caja");
            System.out.println("6. Salir");
            System.out.print("Seleccione una opción: ");
            opcion1 = sc.nextInt();

            switch (opcion1) {
                //Ingresar un nuevo usuario para la compra de tickets
                case 1:
                    sc.nextLine();
                    System.out.print("Ingrese su nombre: ");
                    nombre = sc.nextLine();
                    System.out.print("Ingrese su correo: ");
                    String email = sc.nextLine();
                    System.out.print("Ingrese cuantos tickets quiere: ");
                    ticket_solicitado = sc.nextInt();
                    System.out.print("Ingrese cuanto presupuesto tiene: ");
                    presupuesto = sc.nextInt();
                    break;

                case 2:
                //Genera el numero de ticket que es aleatorio y el rango de numero de ticket
                    int ticket_numero = random.nextInt(15000) + 1;
                    int nuevo_rango1 = random.nextInt(15000) + 1;
                    int nuevo_rango2 = random.nextInt(15000) + 1;

                    //de los dos numeros aleatorios, el mas grande sera el primero y el mas pequenio sera el segundo
                    if (nuevo_rango1 > nuevo_rango2) {
                        int temp = nuevo_rango1;
                        nuevo_rango1 = nuevo_rango2;
                        nuevo_rango2 = temp;
                    }

                    System.out.println("Su numero de ticket es: " + ticket_numero);
                    System.out.println("Rango de tickets validos " + nuevo_rango1 + " y " + nuevo_rango2 );

                    //Verificar que el ticket generado esta dentro del rango, si esta en el rango generar una localidad al azar
                    if (nuevo_rango1 < ticket_numero && ticket_numero < nuevo_rango2) {
                        System.out.println("El ticket generado está dentro del rango válido");
                        for (int i = 0; i < ticket_solicitado; i++) {
                            int localidad = random.nextInt(3) + 1;
                            int precio = 0;
                            
                            //Por cada localidad se le resta un valor a la localidad y se le asigna un valor a cada localidad
                            if (localidad == 1){
                                precio = 100;
                                localidad1 --;
                            } else if (localidad == 2){
                                precio = 500;
                                localidad2 --;
                            } else if (localidad == 3){
                                precio = 1000;
                                localidad3 --;
                            }
                            tickets_total = tickets_total + precio;
                            System.out.println("Ticket solicitado #" + (i + 1) + " localidad " + localidad + " precio " + precio);
                        
                        }
                        System.out.println("El precio total de los tickets es de: " + tickets_total);
                        int precio_total = presupuesto - tickets_total;
                        System.out.println("Presupuesto - precio total de los tickets: " + precio_total);

                        boletos_vendidos_localidad1 =  20 - localidad1;
                        boletos_vendidos_localidad2 =  20 - localidad2;
                        boletos_vendidos_localidad3 =  20 - localidad3;

                        //Verificar que exista espacio suficiente y que haya dinero suficiente
                        if (precio_total >= 0 && localidad1 > 0 && localidad2 > 0 && localidad3 > 0){
                            System.out.println("Compra de tickets EXITOSA");
                        } else {
                            System.out.println("No hay suficientes fondos, o no hay suficiente espacio");
                        }
            
                    }
                    else {
                        System.out.println("El ticket generado NO está dentro del rango válido");
                    }
                    break;

                case 3:

                    //Imprimir la disponibilidad por cada localidad
                    System.out.println("Disponibilidad total:");
                    System.out.println("Boletos disponibles para la Localidad 1: " + localidad1 + "/20");
                    System.out.println("Boletos disponibles para la Localidad 2: " + localidad2 + "/20");
                    System.out.println("Boletos disponibles para la Localidad 3: " + localidad3 + "/20");
                    System.out.println("Boletos vendidos para la Localidad 1: " + boletos_vendidos_localidad1 + "/20");
                    System.out.println("Boletos vendidos para la Localidad 2: " + boletos_vendidos_localidad2 + "/20");
                    System.out.println("Boletos vendidos para la Localidad 3: " + boletos_vendidos_localidad3 + "/20");
                    break;

                    //Imprimir la disponibilidad individial de una localidad que el usuario selecciona
                case 4:
                    int opcion2;
                    System.out.println("Seleccione la localidad que desea consultar: ");
                    System.out.println("1. Localidad 1");
                    System.out.println("2. Localidad 2");
                    System.out.println("3. Localidad 3");
                    opcion2 = sc.nextInt();
                    if (opcion2 == 1){
                        System.out.println("Boletos disponibles para la Localidad 1: " + localidad1 + "/20");
                        System.out.println("Boletos vendidos para la Localidad 1: " + boletos_vendidos_localidad1 + "/20");
                    } else if (opcion2 == 2){
                        System.out.println("Boletos disponibles para la Localidad 2: " + localidad2 + "/20");
                        System.out.println("Boletos vendidos para la Localidad 2: " + boletos_vendidos_localidad2 + "/20");
                    } else if (opcion2 == 3){
                        System.out.println("Boletos disponibles para la Localidad 3: " + localidad3 + "/20");
                        System.out.println("Boletos vendidos para la Localidad 3: " + boletos_vendidos_localidad3 + "/20");
                    }
                    
                    break;

                case 5:
                    //Sumar el valor de los tickets vendidos.
                    System.out.println("Reporte de caja: " + tickets_total);
                    break;

                case 6:
                    //Terminar el programa
                    System.out.println("¡Hasta luego!");
                    salir = true;
                    break;
                default:
                    System.out.println("Opción inválida. Por favor, elija una opción válida.");
            }
        }
    }
}
