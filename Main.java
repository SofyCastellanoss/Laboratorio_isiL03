public class Main {
    public static void main(String[] args) {
        System.out.println("--- INICIO DE PRUEBAS DEL SISTEMA BANCARIO REFACTORIZADO ---\n");

        try (RegistroAuditoriaBancaria auditoria = new RegistroAuditoriaBancaria()) {

            CuentaBancaria ahorros = new CuentaAhorros("AH-101", "Ana Martinez", 50000.0, 0.015);
            CuentaBancaria corriente = new CuentaCorriente("CC-202", "Carlos Gomez", 20000.0, 100000.0, 0.05);

            auditoria.registrarOperacion("Intento de retiro en cuenta Ahorros AH-101");
            ahorros.retirar(10000.0);
            ahorros.aplicarComisionMensual();

            System.out.println("------------------------------------------------");

            auditoria.registrarOperacion("Intento de retiro con sobregiro en cuenta Corriente CC-202");
            corriente.retirar(70000.0);
            corriente.aplicarComisionMensual();

        } catch (Exception e) {
            System.err.println("Error en la ejecucion: " + e.getMessage());
        }
        
        System.out.println("\n--- FIN DE PRUEBAS ---");
    }
}