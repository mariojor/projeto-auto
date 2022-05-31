package repositorio.document;
import model.Cliente;
import org.bson.Document;
import org.bson.types.ObjectId;


public class ClienteDocument {

    private static final String ID = "_id";
    private static final String NOME = "nome";
    private static final String CPF = "cpf";
    private static final String TELEFONE = "telefone";
    private static final String ENDERECO = "endereco";


    public static Document from(Cliente cliente) {
        return new Document(NOME, cliente.getNome())
                .append(CPF, cliente.getCpf())
                .append(TELEFONE, cliente.getTelefone())
                .append(ENDERECO, cliente.getEndereco());
    }

    public static Document findCpf(String cpf) {
        return new Document(CPF, cpf);
    }

    public static Document findId(String id) {
        return new Document(ID, new ObjectId(id));
    }
}
