public class Musica {
    String titulo;
    String artista;
    int duracaoSegundos;
    String genero;

    void exibir() {
        int min = this.duracaoSegundos / 60;
        int seg = this.duracaoSegundos % 60;
        System.out.println("🎵 " + this.titulo + " | Artista: " + this.artista + 
                           " | Gênero: " + this.genero + " | Duração: " + min + ":" + String.format("%02d", seg));
    }

    boolean contemTitulo(String busca) {
        return this.titulo.toLowerCase().contains(busca.toLowerCase());
    }

    boolean contemArtista(String busca) {
        return this.artista.toLowerCase().contains(busca.toLowerCase());
    }
}