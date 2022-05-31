package repositorio;

import com.mongodb.client.FindIterable;
import exception.ClienteCadastradoException;
import model.Cliente;
import org.bson.Document;

public interface Repositorio {
     void inserir(Cliente cliente) throws ClienteCadastradoException;
     void atualizar(Cliente cliente);
     void remover(String id);
     Object buscarPorCpf(String cpf);
     FindIterable<Document> buscarTodos();
     Document buscarPorId(String id);
}

