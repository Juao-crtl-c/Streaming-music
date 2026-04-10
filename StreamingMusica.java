import java.util.ArrayList;
import java.util.Scanner;

public class StreamingMusica {

    private static ArrayList<Musica> listaGeral = new ArrayList<>();
    private static Usuario usuario;
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        usuario = new Usuario("Usuário Logado");
        adicionarMusicasTeste();

        int opcao;
        do {
            exibirMenu();
            opcao = lerOpcao();
            processarOpcao(opcao);
        } while (opcao != 0);

        System.out.println("Saindo...");
        scanner.close();
    }

    public static void exibirMenu() {
        System.out.println("\n=== SISTEMA DE STREAMING ===");
        System.out.println("1. Cadastrar música");
        System.out.println("2. Listar todas as músicas");
        System.out.println("3. Buscar música");
        System.out.println("4. Criar playlist");
        System.out.println("5. Gerenciar playlists");
        System.out.println("0. Sair");
        System.out.print("Escolha: ");
    }

    public static void processarOpcao(int opcao) {
        switch (opcao) {
            case 1:
                cadastrarMusica();
                break;
            case 2:
                listarMusicas();
                break;
            case 3:
                buscarMusica();
                break;
            case 4:
                System.out.print("Nome da playlist: ");
                usuario.criarPlaylist(scanner.nextLine());
                break;
            case 5:
                gerenciarPlaylists();
                break;
            case 0:
                break;
            default:
                System.out.println("Opção inválida!");
        }
    }

    public static void cadastrarMusica() {
        System.out.print("Título: ");
        String titulo = scanner.nextLine();
        System.out.print("Artista: ");
        String artista = scanner.nextLine();
        System.out.print("Gênero: ");
        String genero = scanner.nextLine();
        System.out.print("Duração (segundos): ");
        int duracao = lerOpcao();

        Musica m = new Musica(titulo, artista, duracao, genero);
        listaGeral.add(m);
        System.out.println("Música adicionada ao sistema.");
    }

    public static void listarMusicas() {
        System.out.println("\n--- BIBLIOTECA GERAL ---");
        for (int i = 0; i < listaGeral.size(); i++) {
            System.out.print(i + ". ");
            listaGeral.get(i).exibir();
        }
    }

    public static void buscarMusica() {
        System.out.print("Digite o título para buscar: ");
        String busca = scanner.nextLine();
        boolean encontrou = false;
        for (Musica m : listaGeral) {
            if (m.contemTitulo(busca)) {
                m.exibir();
                encontrou = true;
            }
        }
        if (!encontrou) {
            System.out.println("Nenhuma música encontrada para: " + busca);
        }
    }

    public static void gerenciarPlaylists() {
        if (usuario.getPlaylists().isEmpty()) {
            System.out.println("Crie uma playlist primeiro (Opção 4).");
            return;
        }
        usuario.listarPlaylists();
        System.out.print("Digite o índice da playlist: ");
        int idx = lerOpcao();

        if (idx >= 0 && idx < usuario.getPlaylists().size()) {
            Playlist p = usuario.getPlaylists().get(idx);
            System.out.println("\n1. Adicionar Música | 2. Remover | 3. Ver Detalhes | 0. Voltar");
            int sub = lerOpcao();

            if (sub == 1) {
                listarMusicas();
                System.out.print("Índice da música para adicionar à playlist: ");
                int mIdx = lerOpcao();
                if (mIdx >= 0 && mIdx < listaGeral.size()) {
                    p.adicionarMusica(listaGeral.get(mIdx));
                }
            } else if (sub == 2) {
                p.listarMusicas();
                System.out.print("Número da música para remover: ");
                p.removerMusica(lerOpcao() - 1);
            } else if (sub == 3) {
                p.listarMusicas();
                System.out.println("Tempo total: " + (p.getDuracaoTotal() / 60) + " min");
            }
        } else {
            System.out.println("Índice de playlist inválido.");
        }
    }

    public static int lerOpcao() {
        try {
            return Integer.parseInt(scanner.nextLine());
        } catch (Exception e) {
            return -1;
        }
    }

    public static void adicionarMusicasTeste() {
        listaGeral.add(new Musica("Bohemian Rhapsody", "Queen", 354, "Rock"));
        listaGeral.add(new Musica("Billie Jean", "Michael Jackson", 293, "Pop"));
    }
}
