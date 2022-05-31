package repositorio;

import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import model.Cliente;
import org.bson.Document;
import repositorio.document.ClienteDocument;

import java.util.Optional;


public class ClientesRepository implements Repositorio  {
    private static final String COLECAO = "clientes";
    MongoCollection<Document> mc;
    ClienteDocument clienteDocument;

    public ClientesRepository() {
        clienteDocument = ClienteDocument.builder().build();
        mc = MongoConexao.getInstance().getConexao(COLECAO);
    }

    public void inserir(Cliente cliente)  {
        if(Optional.ofNullable(buscarPorCpf(cliente.getCpf())).isEmpty()) {
            mc.insertOne(clienteDocument.from(cliente));
            System.out.println("Cliente inserido com sucesso");
        } else {
            System.out.println("Cliente já cadastrado");
        }
    }

    public void atualizar(Cliente cliente) {
        mc.updateOne(clienteDocument.filterId(cliente.getId()), clienteDocument.setNome(cliente.getNome()));
        System.out.println("Cliente atualizado com sucesso");
    }

    public void remover(String id) {
        if(Optional.ofNullable(buscarPorId(id)).isEmpty()) {
            System.out.println("Cliente não encontrado");
        }else{
            mc.deleteOne(clienteDocument.filterId(id));
            System.out.println("Cliente removido com sucesso");
        }
    }

    public Document buscarPorId(String id) {
        final var document = mc.find(clienteDocument.filterId(id)).first();
        System.out.println("Cliente encontrado com sucesso");
        return document;
    }

    public Document buscarPorCpf(String cpf) {
        final var document = mc.find(clienteDocument.findCpf(cpf)).first();
        System.out.println("Cliente exite".concat(document.toJson()));
       return document;
    }

    public FindIterable<Document> buscarTodos() {
        return mc.find();
    }
}
