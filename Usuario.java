import java.util.ArrayList;

public class Usuario {
    String nome;
    ArrayList<Playlist> playlists = new ArrayList<>();

    void criarPlaylist(String nome) {
        Playlist nova = new Playlist();
        nova.nome = nome;
        this.playlists.add(nova);
        System.out.println("Playlist '" + nome + "' criada!");
    }

    void listarPlaylists() {
        if (playlists.isEmpty()) {
            System.out.println("Você ainda não tem playlists.");
        } else {
            for (int i = 0; i < playlists.size(); i++) {
                System.out.println(i + " - " + playlists.get(i).nome + 
                    " [" + playlists.get(i).getQuantidadeMusicas() + " músicas]");
            }
        }
    }
}