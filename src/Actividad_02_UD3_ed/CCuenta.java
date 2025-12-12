package actividad_02_ud3_ed;
/**
 * Clase que representa una cuenta bancaria.
 * Tiene nombre del titular, numero de cuenta, saldo y tipo de interes.
 */
public class CCuenta {
    // Nombre del titular
    protected String nombre;
    // Numero de cuenta
    private String cuenta;
    // Saldo disponible
    private double saldo;
    // Tipo de interes
    private double tipoInteres;
    // Constructor vacio (por si se necesita crear la cuenta sin datos)
    public CCuenta() {}
    /**
     * Constructor para crear una cuenta con datos iniciales.
     *
     * @param nom  Nombre del titular
     * @param cue  Numero de cuenta
     * @param sal  Saldo inicial
     * @param tipo Tipo de interes
     */
    public CCuenta(String nom, String cue, double sal, double tipo) {
        nombre = nom;
        cuenta = cue;
        saldo = sal;
        tipoInteres = tipo;
    }
    /**
     * Cambia el nombre del titular.
     * @param nom
     */
    public void asignarNombre(String nom) {
        nombre = nom;
    }
    /**
     * Obtiene el nombre del titular.
     * @return 
     */
    public String obtenerNombre() {
        return nombre;
    }
    /**
     * Devuelve el saldo actual.
     * @return 
     */
    public double estado() {
        return saldo;
    }
    /**
     * Ingresa dinero en la cuenta.
     * @param cantidad
     * @throws Exception si la cantidad es negativa
     */
    public void ingresar(double cantidad) throws Exception {

        if (cantidad < 0) {
            throw new Exception("No se puede ingresar una cantidad negativa");
        }
        // Sumamos la cantidad al saldo actual
        saldo = saldo + cantidad;
    }
    /**
     * Retira dinero de la cuenta.
     * @param cantidad
     * @throws Exception si la cantidad es negativa o no hay saldo suficiente
     */
    public void retirar(double cantidad) throws Exception {

        if (cantidad < 0) {
            throw new Exception("No se puede retirar una cantidad negativa");
        }

        if (saldo < cantidad) {
            throw new Exception("No hay suficiente saldo");
        }

        // Restamos la cantidad al saldo
        saldo = saldo - cantidad;
    }
    /**
     * Devuelve el numero de cuenta.
     */
    public String obtenerCuenta() {
        return cuenta;
    }
    public void setCuenta(String cuenta) {
        this.cuenta = cuenta;
    }
    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }
    public double getTipoInteres() {
        return tipoInteres;
    }
    public void setTipoInteres(double tipoInteres) {
        this.tipoInteres = tipoInteres;
    }
}
