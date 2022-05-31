package repositorio;

import com.mongodb.client.FindIterable;
import model.Cliente;
import org.bson.Document;
import repositorio.document.ClienteDocument;

import java.util.Optional;


public class ClientesRepository implements Repositorio  {
    private static final String COLECAO = "clientes";
    MongoConexao mongoConexao = MongoConexao.getInstance();

    public void inserir(Cliente cliente)  {
        if(Optional.ofNullable(buscarPorCpf(cliente.getCpf())).isEmpty()) {
            mongoConexao.getConexao(COLECAO).insertOne(ClienteDocument.from(cliente));
        } else {
            System.out.println("Cliente já cadastrado");
        }
    }


    public void atualizar(Object obj) {

    }

    public void remover(Object obj) {

    }

    public Document buscarPorId(String id) {
        return mongoConexao.getConexao(COLECAO).find(ClienteDocument.findId(id)).first();
    }

    public Document buscarPorCpf(String cpf) {
       return mongoConexao.getConexao(COLECAO).find(ClienteDocument.findCpf(cpf)).first();
    }


    public FindIterable<Document> buscarTodos() {
        return mongoConexao.getConexao(COLECAO).find();
    }
}
