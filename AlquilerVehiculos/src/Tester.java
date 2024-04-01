import java.io.IOException;
import java.util.Scanner;


public class Tester {
    public static void main(String[] args) throws IOException {
        int id;
        double precioDia;
        String tipo;
        String direccion;
        int anyoFabricacion;
        double precioReal;
        int opcion = 0;
        int respuesta = 0;
        char respuesta2;
        int capacidad;
        Empresa llamar = new Empresa();
        Scanner scanner = new Scanner(System.in);
        do {
            System.out.println("Que quieres hacer:\n1. Listado de vehiculos por tamaño\n2. Añadir Vehiculos\n3. Consulta de vehiculos\n4. Actualizar la capacidad de un coche\n5. Actualizar si dispone o no de acceso a minusvalidos\n6. Eliminar un vehiculo\n7. Calcular precio real medio\n8. Mostrar vehiculos por criterio\nPara salir escribe 100");
            opcion = scanner.nextInt();
            switch (opcion) {
                case 1:
                    System.out.println("Listado de vehiculos, introduce tamaño");
                    int tamano = scanner.nextInt();
                    Empresa listarTamano = new Empresa(tamano);
                    listarTamano.mostrar();
                    break;
                case 2:
                    llamar.mostrar();
                    do {
                        System.out.println("Añadir vehiculo, que vehiculo quieres añadir, 1.Coche y 2. Autobus");
                        respuesta = scanner.nextInt();
                    } while (respuesta != 1 && respuesta != 2);
                    System.out.println("Introduce los datos: Id,Precio al Día, Tipo, Año de fabricacion,Direccion y Precio Real");
                    id = scanner.nextInt();
                    precioDia = scanner.nextDouble();
                    tipo = scanner.next();
                    anyoFabricacion = scanner.nextInt();
                    direccion = scanner.next();
                    precioReal = scanner.nextDouble();
                    llamar.adVehiculo(id, precioDia, tipo, anyoFabricacion, respuesta, direccion, precioReal);
                    break;
                case 3:
                    llamar.mostrar();
                    System.out.println("Consulta de vehiculos, Introduce provincia y año para porder filtrar la lista de Vehiculos");
                    direccion = scanner.next();
                    anyoFabricacion = scanner.nextInt();
                    llamar.filtrarVehiculo(direccion, anyoFabricacion);
                    break;
                case 4:
                    llamar.mostrar();
                    System.out.println("Actualizar la capacidad de un coche, introduce identificador y capacidad nueva");
                    id = scanner.nextInt();
                    capacidad = scanner.nextInt();
                    llamar.actualizarCapacidad(id, capacidad);
                    break;
                case 5:
                    llamar.mostrar();
                    System.out.println("Actualizar el atributo acceso a minusvalidos, introduce identificador y escribe si tiene o no acceso a minusvalidos (S/N)");
                    id = scanner.nextInt();
                    respuesta2 = (char) System.in.read();
                    char espacio = (char) System.in.read();
                    if (llamar.actualizarMinusvalidos(id, respuesta2)) {
                        System.out.println("Se ha actualizado con éxito");
                        llamar.mostrar();
                    } else {
                        System.out.println("Error, no se ha podido actualizar");
                    }
                    break;
                case 6:
                    llamar.mostrar();
                    llamar.eliminarVehiculo();
                    break;
                case 7:
                    System.out.println("Calcular precio real por provincia");
                    System.out.println("\n");
                    llamar.calacularMedia();
                    break;
                case 8:
                    llamar.mostrar();
                    System.out.println("Mostrar vehiculos por criterio,  introduce provincia");
                    direccion = scanner.next();
                    llamar.ordenarporProvincia(direccion);
                    break;
                default:
                    if (opcion == 100) {
                        System.out.println("Saliendo...");
                    } else {
                        System.out.println("Opcion no valida");
                    }
            }
        } while (opcion != 100);

    }
}