
public abstract class CuentaBancaria {
    private String numeroCuenta;
    private String titular;
    private double saldo;

    public CuentaBancaria(String numeroCuenta, String titular, double saldoInicial) {
        this.numeroCuenta = numeroCuenta;
        this.titular = titular;
        this.saldo = saldoInicial;
    }

    public String getNumeroCuenta() {
        return numeroCuenta;
    }

    public String getTitular() {
        return titular;
    }

    public double getSaldo() {
        return saldo;
    }

    protected void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public void depositar(double monto) {
        if (monto > 0) {
            this.saldo += monto;
            System.out.println("Deposito exitoso en " + numeroCuenta + ". Saldo actual: $" + this.saldo);
        } else {
            System.out.println("El monto a depositar debe ser positivo.");
        }
    }

    public boolean retirar(double monto) {
        if (monto > 0 && this.saldo >= monto) {
            this.saldo -= monto;
            System.out.println("Retiro exitoso de $" + monto + " en " + numeroCuenta + ". Saldo restante: $" + this.saldo);
            return true;
        }
        System.out.println("Retiro denegado en " + numeroCuenta + ": fondos insuficientes.");
        return false;
    }

    public abstract void aplicarComisionMensual();
}