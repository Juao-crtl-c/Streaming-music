import java.util.ArrayList;

public class Playlist {
    String nome;
    ArrayList<Musica> musicas = new ArrayList<>();

    void adicionarMusica(Musica musica) {
        this.musicas.add(musica);
    }

    void removerMusica(int indice) {
        if (indice >= 0 && indice < musicas.size()) {
            this.musicas.remove(indice);
        } else {
            System.out.println("Índice inválido.");
        }
    }

    void listarMusicas() {
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

    int getDuracaoTotal() {
        int total = 0;
        for (Musica m : musicas) {
            total += m.duracaoSegundos;
        }
        return total;
    }

    int getQuantidadeMusicas() {
        return this.musicas.size();
    }
}