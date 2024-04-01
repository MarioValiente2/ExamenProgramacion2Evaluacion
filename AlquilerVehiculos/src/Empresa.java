import java.util.Objects;
import java.util.Scanner;

public class Empresa {
    private Vehiculos[][] listaVehiculos;

    public static final String provincias[] = {"Barcelona", "Lugo", "Madrid", "Malaga", "Valencia", "Vizcaya"};

    public Empresa() {
        listaVehiculos = new Vehiculos[6][6];
        for (int i = 0; i < listaVehiculos.length; i++) {
            for (int j = 0; j < listaVehiculos[0].length; j++) {
                String provincia = provincias[i];
                if (j == 5) {
                    listaVehiculos[i][j] = null;
                } else if (j % 2 == 0) {
                    listaVehiculos[i][j] = new Coche(provincia);
                } else if (j % 2 == 1) {
                    listaVehiculos[i][j] = new Autobus(provincia);
                }
            }
        }
    }

    public Empresa(int tamano) {
        listaVehiculos = new Vehiculos[6][tamano];
        for (int i = 0; i < listaVehiculos.length; i++) {
            for (int j = 0; j < listaVehiculos[i].length; j++) {
                String provincia = provincias[i];
                if (j == 5) {
                    listaVehiculos[i][j] = null;
                } else if (j % 2 == 0) {
                    listaVehiculos[i][j] = new Coche(provincia);
                } else if (j % 2 == 1) {
                    listaVehiculos[i][j] = new Autobus(provincia);
                }
            }
        }
    }

    public void mostrar() {
        for (int i = 0; i < listaVehiculos.length; i++) {
            System.out.println("Fila " + i + "\n");
            for (int j = 0; j < listaVehiculos[i].length; j++) {
                System.out.print(listaVehiculos[i][j]);
                System.out.println("\n");
            }
        }

    }

    public void adVehiculo(int id, double precioDia, String tipo, int anyoFabricacion, int respuesta, String direccion, double precioreal) {
        boolean salir = false;
        for (int i = 0; i < listaVehiculos.length && !salir; i++) {
            String provincia = provincias[i];
            for (int j = 0; j < listaVehiculos[i].length && !salir; j++) {
                if (listaVehiculos[i][j] == null && Objects.equals(direccion, provincia)) {
                    if (respuesta == 1) {
                        listaVehiculos[i][j] = new Coche(direccion, id, precioDia, tipo, anyoFabricacion, precioreal);
                        salir = true;
                    } else {
                        listaVehiculos[i][j] = new Autobus(direccion, id, precioDia, tipo, anyoFabricacion, precioreal);
                        salir = true;
                    }
                }
            }
        }
        mostrar();
    }

    public void filtrarVehiculo(String direccion, int anyoFabricacion2) {
        for (int i = 0; i < listaVehiculos.length; i++) {
            for (int j = 0; j < listaVehiculos[i].length; j++) {
                if (listaVehiculos[i][j] != null && Objects.equals(listaVehiculos[i][j].direccion, direccion) && listaVehiculos[i][j].anyoFabricacion > anyoFabricacion2) {
                    System.out.print(listaVehiculos[i][j] + "\n");
                    System.out.println("\n");
                }
            }
        }
    }

    public void actualizarCapacidad(int id, int capacidad) {
        for (int i = 0; i < listaVehiculos.length; i++) {
            for (int j = 0; j < listaVehiculos[i].length; j++) {
                if (listaVehiculos[i][j] != null) {
                    if (listaVehiculos[i][j] instanceof Coche coche && listaVehiculos[i][j].id == id) {
                        coche.setCapacidad(capacidad);
                    }
                }
            }
        }
        mostrar();
    }

    public boolean actualizarMinusvalidos(int id, char respuesta2) {
        boolean respuesta = false;
        for (int i = 0; i < listaVehiculos.length; i++) {
            for (int j = 0; j < listaVehiculos[i].length; j++) {
                if (listaVehiculos[i][j] != null) {
                    if (listaVehiculos[i][j] instanceof Autobus autobus && listaVehiculos[i][j].id == id) {
                        if (respuesta2 == 'S') {
                            autobus.setNinusvalidos(true);
                        } else if (respuesta2 == 'N') {
                            autobus.setNinusvalidos(false);
                        }
                        respuesta = true;
                    }
                }
            }
        }
        return respuesta;
    }

    public void eliminarVehiculo() {
        Scanner scanner = new Scanner(System.in);
        boolean salir = false;
        System.out.println("Eliminar vehiculo, introduce el id y la direccion");
        int id = scanner.nextInt();
        String direccion2 = scanner.next();
        for (int i = 0; i < listaVehiculos.length && !salir; i++) {
            for (int j = 0; j < listaVehiculos[i].length && !salir; j++) {
                if (listaVehiculos[i][j] != null && listaVehiculos[i][j].id == id && Objects.equals(listaVehiculos[i][j].direccion, direccion2)) {
                    listaVehiculos[i][j] = null;
                    System.out.println("Eliminado con éxito");
                    salir = true;
                }
            }
        }
        mostrar();
    }

    public void calacularMedia() {
        double precioC = 0;
        double precioA = 0;
        int contador1 = 0;
        int contador2 = 0;
        for (int i = 0; i < listaVehiculos.length; i++) {
            String provincia = provincias[i];
            for (int j = 0; j < listaVehiculos[i].length; j++) {
                if (listaVehiculos[i][j] != null) {
                    listaVehiculos[i][j].calcularPrecioReal(false);
                    if (listaVehiculos[i][j] instanceof Coche) {
                        precioC = precioC + listaVehiculos[i][j].precioReal;
                        contador1++;
                    } else if (listaVehiculos[i][j] instanceof Autobus) {
                        precioA = precioA + listaVehiculos[i][j].precioReal;
                        contador2++;
                    }
                }
            }
            System.out.printf("El precio de la provincia: %s\nLa media de los Coches es: %.2f €\nLa media de los Autobuses es: %.2f €", provincia, precioC / contador1, precioA / contador2);
            System.out.println("\n");
        }

    }

    public void ordenarporProvincia(String direccion2) {
        for (int i = 0; i < listaVehiculos.length; i++) {
            for (int j = 0; j < listaVehiculos[i].length; j++) {
                if (listaVehiculos[i][j] != null && Objects.equals(listaVehiculos[i][j].direccion, direccion2)) {
                    System.out.println(listaVehiculos[i][j]);
                    System.out.println("\n");
                }
            }
        }
    }


}


