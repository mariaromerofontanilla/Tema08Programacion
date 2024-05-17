package ficheroEje08;

public class RegistroTemperatura {
    private String fecha;
    private int tempMax;
    private int tempMin;

    public RegistroTemperatura(String fecha, int tempMax, int tempMin) {
        this.fecha = fecha;
        this.tempMax = tempMax;
        this.tempMin = tempMin;
    }

    public String getFecha() {
        return fecha;
    }

    public int getTempMax() {
        return tempMax;
    }

    public int getTempMin() {
        return tempMin;
    }

    @Override
    public String toString() {
        return fecha + "," + tempMax + "," + tempMin;
    }
}
