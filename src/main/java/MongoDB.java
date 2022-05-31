import model.Cliente;
import repositorio.ClientesRepository;
import repositorio.Repositorio;

public class MongoDB {

    public static void main(String[] args) {
    ClientesRepository cr = new ClientesRepository();

        cr.remover("62957e97bd8fe307d63feed0");


//        clientesRepository.atualizar(Cliente.builder()
//                .id("62958404b598e41a7bb31ec6")
//                .nome("Tonaho")
//                .build());

       // clientesRepository.buscarPorId("62957e97bd8fe307d63feed0");

//        clientesRepository.inserir(Cliente.builder()
//
//                .nome("Maria")
//                .telefone("123233")
//                .cpf("234324234")
//                .endereco("teste")
//                .build());

//        clientesRepository.buscarTodos().forEach(System.out::println);
    }
}
