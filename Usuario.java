import java.util.ArrayList;

public class Usuario {

    private String nome;
    private ArrayList<Playlist> playlists;

    
    public Usuario() {
        this.nome = "Usuário";
        this.playlists = new ArrayList<>();
    }

    
    public Usuario(String nome) {
        this();  
        setNome(nome);
    }

    
    public String getNome() {
        return nome;
    }

    public ArrayList<Playlist> getPlaylists() {
        return playlists;
    }

    
    public void setNome(String nome) {
        if (nome == null || nome.trim().isEmpty()) {
            System.out.println("Aviso: nome de usuário inválido. Mantendo valor anterior.");
            return;
        }
        this.nome = nome.trim();
    }

    public void criarPlaylist(String nome) {
        if (nome == null || nome.trim().isEmpty()) {
            System.out.println("Aviso: informe um nome válido para a playlist.");
            return;
        }
        Playlist nova = new Playlist(nome);
        this.playlists.add(nova);
        System.out.println("Playlist '" + nova.getNome() + "' criada!");
    }

    public void listarPlaylists() {
        if (playlists.isEmpty()) {
            System.out.println("Você ainda não tem playlists.");
        } else {
            for (int i = 0; i < playlists.size(); i++) {
                System.out.println(i + " - " + playlists.get(i).getNome() +
                        " [" + playlists.get(i).getQuantidadeMusicas() + " músicas]");
            }
        }
    }
}
