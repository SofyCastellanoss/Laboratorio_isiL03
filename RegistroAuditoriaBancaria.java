public class RegistroAuditoriaBancaria implements AutoCloseable {

    public RegistroAuditoriaBancaria() {
        System.out.println(">>> [AUDITORIA] Abriendo recurso de log bancario...");
    }

    public void registrarOperacion(String detalle) {
        System.out.println(">>> [LOG]: " + detalle);
    }

    @Override
    public void close() {
        System.out.println(">>> [AUDITORIA] Recurso de log cerrado de forma segura.");
    }
}