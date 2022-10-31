package linkedlist;

import java.util.List;

public class CadastroCliente {
    public static void main(String[] args)
    {
        LinkedList listaClientes = new LinkedList();
        Cliente c = new Cliente(221,
                                "Produtos excelentes LTDA",
                                "Rua sem fim, 200",
                                5000.0);

        listaClientes.addFirst(c);

        listaClientes.addFirst(new
                Cliente(185,
                "Negócios Importantes SA",
                "Avenida Principal, 10",
                12000.0));


        listaClientes.addFirst(new
                Cliente(443,
                "Parceiros Críticos LTDA",
                "Rua dos negócios, 2000",
                7000.0));

        listaClientes.showList().forEach(System.out::println);
        System.out.println("\nSEGUNDO OBJETO DA LISTA   "+listaClientes.findByIndex(2));
        System.out.println("\n Remove last index: " + listaClientes.removeFirst() + "\n");
        listaClientes.showList().forEach(System.out::println);

        listaClientes.clearList();

        System.out.println("\nAfter Delete------------------");
        listaClientes.addFirst(new
                Cliente(111,
                "After Delete",
                "Rua Rio de Janeiro, 2000",
                7000.0));
        listaClientes.showList().forEach(System.out::println);
    }
}