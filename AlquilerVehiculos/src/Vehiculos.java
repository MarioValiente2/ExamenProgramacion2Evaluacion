import java.util.Random;

public abstract class Vehiculos {
    protected int id;
    protected double precioDia;
    protected String tipo;
    protected String direccion;
    protected int anyoFabricacion;
    protected double precioReal;
    private String calle = " , Hermanos Garcia Noblejas";


    public static final String tipos[] = {"Electrico", "Hibrido", "Diesel", "Gasolina"};

    public Vehiculos(String direccion, int id, double precioDia, String tipo, int anyoFabricacion) {
        this.direccion = direccion + calle;
        this.id = id;
        this.precioDia = precioDia;
        this.tipo = tipo;
        this.anyoFabricacion = anyoFabricacion;
    }

    public Vehiculos(String provincia) {
        Random random = new Random();
        this.id = random.nextInt(1, 200);
        this.tipo = tipos[(int) (Math.random() * tipos.length)];
        this.anyoFabricacion = random.nextInt(2019, 2023);
        this.direccion = provincia + calle;
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + String.format("\nId: %d\nPrecio al día: %.2f\nTipo: %s\nDireccion: %s\nAños de fabricacion: %d\nPrecio real: %.2f", id, precioDia, tipo, direccion + calle, anyoFabricacion, precioReal);
    }

    public abstract double calcularPrecioReal(boolean festivo);
}
