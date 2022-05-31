package repositorio;

import com.mongodb.client.FindIterable;
import exception.ClienteCadastradoException;
import model.Cliente;
import org.bson.Document;

public interface Repositorio {
     void inserir(Cliente cliente) throws ClienteCadastradoException;
     void atualizar(Object obj);
     void remover(Object obj);
     Object buscarPorCpf(String cpf);
     FindIterable<Document> buscarTodos();
}

