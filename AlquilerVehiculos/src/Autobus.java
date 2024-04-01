import java.util.Random;

public class Autobus extends Vehiculos {

    private int numeroViajeros;
    private boolean ninusvalidos;

    public Autobus(String direccion, int id, double precioDia, String tipo, int anyoFabricacion, double precioreal) {
        super(direccion, id, precioDia, tipo, anyoFabricacion);
        Random random = new Random();
        this.numeroViajeros=random.nextInt(4,20);
        this.ninusvalidos = false;
        precioReal = precioreal;
    }


    public Autobus(String provincia) {
        super(provincia);
        Random random = new Random();
        precioDia=random.nextInt(60,100);
        this.numeroViajeros = random.nextInt(5, 30);
        this.ninusvalidos = true;
        direccion=provincia;
        precioReal= calcularPrecioReal(false);
    }

    @Override
    public double calcularPrecioReal(boolean festivo) {
        precioReal = precioDia + (precioDia * (numeroViajeros * 0.01));
        if (festivo) {
            precioReal = precioReal + (precioReal * 0.3);
        }
        return precioReal;
    }

    @Override
    public String toString() {
        return super.toString()+ String.format("\nNúmero de Viajeros: %d\nAcceso a Minusvalidos: %b",numeroViajeros,ninusvalidos);
    }

    public int getNumeroViajeros() {
        return numeroViajeros;
    }

    public void setNumeroViajeros(int numeroViajeros) {
        this.numeroViajeros = numeroViajeros;
    }

    public boolean isNinusvalidos() {
        return ninusvalidos;
    }

    public void setNinusvalidos(boolean ninusvalidos) {
        this.ninusvalidos = ninusvalidos;
    }
}
