public class Musica {

    private String titulo;
    private String artista;
    private int duracaoSegundos;
    private String genero;

  
    public Musica() {
        this.titulo = "Sem título";
        this.artista = "Desconhecido";
        this.duracaoSegundos = 0;
        this.genero = "Indefinido";
    }

    
    public Musica(String titulo, String artista, int duracaoSegundos, String genero) {
        this();  
        setTitulo(titulo);
        setArtista(artista);
        setDuracaoSegundos(duracaoSegundos);
        setGenero(genero);
    }

    
    public Musica(String titulo, String artista, int duracaoSegundos) {
        this(titulo, artista, duracaoSegundos, "Indefinido");
    }

    
    public String getTitulo() {
        return titulo;
    }

    public String getArtista() {
        return artista;
    }

    public int getDuracaoSegundos() {
        return duracaoSegundos;
    }

    public String getGenero() {
        return genero;
    }

    
    public void setTitulo(String titulo) {
        if (titulo == null || titulo.trim().isEmpty()) {
            System.out.println("Aviso: título inválido. Mantendo valor anterior.");
            return;
        }
        this.titulo = titulo.trim();
    }

    public void setArtista(String artista) {
        if (artista == null || artista.trim().isEmpty()) {
            System.out.println("Aviso: artista inválido. Mantendo valor anterior.");
            return;
        }
        this.artista = artista.trim();
    }

    public void setDuracaoSegundos(int duracaoSegundos) {
        if (duracaoSegundos < 0) {
            System.out.println("Aviso: duração não pode ser negativa. Mantendo valor anterior.");
            return;
        }
        this.duracaoSegundos = duracaoSegundos;
    }

    public void setGenero(String genero) {
        if (genero == null || genero.trim().isEmpty()) {
            this.genero = "Indefinido";
            return;
        }
        this.genero = genero.trim();
    }

    public void exibir() {
        int min = this.duracaoSegundos / 60;
        int seg = this.duracaoSegundos % 60;
        System.out.println("🎵 " + this.titulo + " | Artista: " + this.artista +
                " | Gênero: " + this.genero + " | Duração: " + min + ":" + String.format("%02d", seg));
    }

    public boolean contemTitulo(String busca) {
        if (busca == null || busca.trim().isEmpty()) return false;
        return this.titulo.toLowerCase().contains(busca.toLowerCase());
    }

    public boolean contemArtista(String busca) {
        if (busca == null || busca.trim().isEmpty()) return false;
        return this.artista.toLowerCase().contains(busca.toLowerCase());
    }
}
