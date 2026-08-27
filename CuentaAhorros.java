public class CuentaAhorros extends CuentaBancaria {
    private double tasaInteresMensual;
    private static final double COMISION_MANEJO_FIJA = 3000.0;

    public CuentaAhorros(String numeroCuenta, String titular, double saldoInicial, double tasaInteresMensual) {
        super(numeroCuenta, titular, saldoInicial);
        this.tasaInteresMensual = tasaInteresMensual;
    }

    @Override
    public void aplicarComisionMensual() {
        double rendimientos = getSaldo() * tasaInteresMensual;
        double nuevoSaldo = getSaldo() + rendimientos - COMISION_MANEJO_FIJA;

        // Regla de negocio: No permite sobregiros (nunca menor a cero)
        if (nuevoSaldo < 0) {
            nuevoSaldo = 0;
        }

        setSaldo(nuevoSaldo);
        System.out.println("[Cuenta Ahorros " + getNumeroCuenta() + "] Rendimiento: +$" + rendimientos 
                           + " | Comision fija: -$" + COMISION_MANEJO_FIJA 
                           + " | Saldo final: $" + getSaldo());
    }
}