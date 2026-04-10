import java.util.ArrayList;

public class Playlist {

    private String nome;
    private ArrayList<Musica> musicas;

    
    public Playlist() {
        this.nome = "Nova Playlist";
        this.musicas = new ArrayList<>();
    }

    
    public Playlist(String nome) {
        this();  
        setNome(nome);
    }

    
    public String getNome() {
        return nome;
    }

    public ArrayList<Musica> getMusicas() {
        return new ArrayList<>(musicas); 
    }

  
    public void setNome(String nome) {
        if (nome == null || nome.trim().isEmpty()) {
            System.out.println("Aviso: nome inválido para playlist. Mantendo valor anterior.");
            return;
        }
        this.nome = nome.trim();
    }

    public void adicionarMusica(Musica musica) {
        if (musica == null) {
            System.out.println("Aviso: não é possível adicionar uma música nula.");
            return;
        }
        this.musicas.add(musica);
    }

    public void removerMusica(int indice) {
        if (indice >= 0 && indice < musicas.size()) {
            this.musicas.remove(indice);
        } else {
            System.out.println("Índice inválido.");
        }
    }

    public void listarMusicas() {
        System.out.println("\n--- Playlist: " + this.nome + " ---");
        if (musicas.isEmpty()) {
            System.out.println("Nenhuma música nesta playlist.");
        } else {
            for (int i = 0; i < musicas.size(); i++) {
                System.out.print((i + 1) + ". ");
                musicas.get(i).exibir();
            }
        }
    }

    public int getDuracaoTotal() {
        int total = 0;
        for (Musica m : musicas) {
            total += m.getDuracaoSegundos();
        }
        return total;
    }

    public int getQuantidadeMusicas() {
        return this.musicas.size();
    }
}
