package br.com.alura.literalura.model;

import jakarta.persistence.*;

@Entity
@Table(name = "livros")
public class Livro {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private String titulo;

    @ManyToOne
    private Autor autor;

    private String idioma;
    private Double numeroDeDownloads;

    public Livro() {}

    public Livro(DadosLivro dadosLivro, Autor autor) {
        this.titulo = dadosLivro.titulo();
        this.idioma = dadosLivro.idiomas() != null && !dadosLivro.idiomas().isEmpty() ? dadosLivro.idiomas().get(0) : "N/A";
        this.numeroDeDownloads = dadosLivro.numeroDeDownloads();
        this.autor = autor;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getTitulo() { return titulo; }
    public void setTitulo(String titulo) { this.titulo = titulo; }

    public Autor getAutor() { return autor; }
    public void setAutor(Autor autor) { this.autor = autor; }

    public String getIdioma() { return idioma; }
    public void setIdioma(String idioma) { this.idioma = idioma; }

    public Double getNumeroDeDownloads() { return numeroDeDownloads; }
    public void setNumeroDeDownloads(Double numeroDeDownloads) { this.numeroDeDownloads = numeroDeDownloads; }

    @Override
    public String toString() {
        return "------ LIVRO ------\n" +
               "Título: " + titulo + "\n" +
               "Autor: " + (autor != null ? autor.getNome() : "Desconhecido") + "\n" +
               "Idioma: " + idioma + "\n" +
               "Número de downloads: " + numeroDeDownloads + "\n" +
               "-------------------";
    }
}
