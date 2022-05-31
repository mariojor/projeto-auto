package repositorio.document;

import lombok.Builder;
import lombok.Data;
import model.Cliente;
import org.bson.Document;
import org.bson.conversions.Bson;
import org.bson.types.ObjectId;

import static com.mongodb.client.model.Filters.eq;
import static com.mongodb.client.model.Updates.set;

@Data
@Builder
public class ClienteDocument {

    private static final String ID = "_id";
    private static final String NOME = "nome";
    private static final String CPF = "cpf";
    private static final String TELEFONE = "telefone";
    private static final String ENDERECO = "endereco";

    private String id;
    private String nome;
    private String cpf;
    private String endereco;
    private String telefone;

    public Document from(Cliente cliente) {
        return new Document(NOME, cliente.getNome())
                .append(CPF, cliente.getCpf())
                .append(TELEFONE, cliente.getTelefone())
                .append(ENDERECO, cliente.getEndereco());
    }

    public Document findCpf(String cpf) {
        return new Document(CPF, cpf);
    }

    public Bson filterId(String id){
        return eq(ID, ObjectId.isValid(id) ? new ObjectId(id) : id);
    }

    public Bson setNome(String nome) {
        return set(NOME, nome);
    }

}
