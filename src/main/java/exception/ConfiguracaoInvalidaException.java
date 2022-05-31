package exception;

public class ConfiguracaoInvalidaException extends Throwable {
    public ConfiguracaoInvalidaException(String erro_ao_configurar_o_mongoDB) {
        super(erro_ao_configurar_o_mongoDB);
    }
}
