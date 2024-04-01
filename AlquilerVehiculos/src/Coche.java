import java.util.Random;

public class Coche extends Vehiculos{
    private int capacidad;
    private boolean acabadoSup;


    public Coche(String provincia) {
        super(provincia);
        Random random= new Random();
        precioDia= random.nextDouble(30,60);
        capacidad=random.nextInt(100,200);
        direccion=provincia;
        precioReal= calcularPrecioReal(false);
    }

    public Coche(String direccion, int id, double precioDia, String tipo, int anyoFabricacion, double precioreal) {
        super(direccion,id, precioDia, tipo,  anyoFabricacion);
        Random random= new Random();
        precioReal= precioreal;
        capacidad= random.nextInt(100,200);
        acabadoSup=false;
    }

    @Override
    public double calcularPrecioReal(boolean festivo) {
        precioReal=precioDia;
        if (acabadoSup){
            precioReal = precioDia+(precioDia*0.2);
        }
        if (festivo){
            precioReal=precioReal+(precioReal*0.3);
        }
        return precioReal;
    }

    @Override
    public String toString() {
        return super.toString()+ String.format("\nCapacidad: %d\nAcabado Superior: %b",capacidad,acabadoSup);
    }

    public int getCapacidad() {
        return capacidad;
    }

    public void setCapacidad(int capacidad) {
        this.capacidad = capacidad;
    }

    public boolean isAcabadoSup() {
        return acabadoSup;
    }

    public void setAcabadoSup(boolean acabadoSup) {
        this.acabadoSup = acabadoSup;
    }
}
