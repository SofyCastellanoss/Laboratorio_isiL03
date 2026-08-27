public class CuentaCorriente extends CuentaBancaria {
    private double cupoSobregiro;
    private double tasaComisionSobregiro;

    public CuentaCorriente(String numeroCuenta, String titular, double saldoInicial, double cupoSobregiro, double tasaComisionSobregiro) {
        super(numeroCuenta, titular, saldoInicial);
        this.cupoSobregiro = cupoSobregiro;
        this.tasaComisionSobregiro = tasaComisionSobregiro;
    }

    @Override
    public boolean retirar(double monto) {
        if (monto > 0 && (getSaldo() + cupoSobregiro) >= monto) {
            setSaldo(getSaldo() - monto);
            System.out.println("Retiro exitoso de $" + monto + " en Corriente " + getNumeroCuenta() + ". Saldo actual: $" + getSaldo());
            return true;
        }
        System.out.println("Retiro denegado en Corriente " + getNumeroCuenta() + ": Excede el cupo de sobregiro autorizado.");
        return false;
    }

    @Override
    public void aplicarComisionMensual() {

        if (getSaldo() < 0) {
            double interesMora = Math.abs(getSaldo()) * tasaComisionSobregiro;
            setSaldo(getSaldo() - interesMora);
            System.out.println("[Cuenta Corriente " + getNumeroCuenta() + "] Sobregiro detectado. Interes de mora aplicado: -$" 
                               + interesMora + " | Saldo actual: $" + getSaldo());
        } else {
            System.out.println("[Cuenta Corriente " + getNumeroCuenta() + "] Saldo positivo. Sin cobros por mora.");
        }
    }
}