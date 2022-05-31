package repositorio;

import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import org.bson.Document;

public class MongoConexao {

    private static final String URL_CONEXAO = "mongodb://localhost:27017";
    private static final String BANCO = "autodb";
    private static final String ERRO = "Erro ao configurar o MongoDB:";
    private static MongoConexao instance;
    private MongoCollection<Document> db;

    public static synchronized MongoConexao getInstance() {
        if (instance == null) {
            instance = new MongoConexao();
        }
        return instance;
    }
    private MongoConexao() {
    }

    public MongoCollection<Document> getConexao(String colecao) {
        try{
            db = MongoClients.create(URL_CONEXAO).getDatabase(BANCO).getCollection(colecao);
        } catch(Exception e){
            System.out.println(ERRO + e.getMessage());
        }
        return db;
    }

}
