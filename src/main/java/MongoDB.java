import lombok.AllArgsConstructor;
import model.Cliente;
import repositorio.ClientesRepository;

public class MongoDB {

    public static void main(String[] args) {

        ClientesRepository clientesRepository = new ClientesRepository();


        clientesRepository.inserir(Cliente.builder()
                .nome("Carlos")
                .telefone("123233")
                .cpf("1233433")
                .endereco("Avenida")
                .build());

        clientesRepository.buscarTodos().forEach(System.out::println);
    }
}
