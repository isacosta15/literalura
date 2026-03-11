package br.com.alura.literalura.principal;

import br.com.alura.literalura.model.Autor;
import br.com.alura.literalura.model.DadosLivro;
import br.com.alura.literalura.model.Livro;
import br.com.alura.literalura.model.Resultados;
import br.com.alura.literalura.repository.AutorRepository;
import br.com.alura.literalura.repository.LivroRepository;
import br.com.alura.literalura.service.ConsumoApi;
import br.com.alura.literalura.service.ConverteDados;

import java.util.List;
import java.util.Scanner;

public class Principal {
    private Scanner leitura = new Scanner(System.in);
    private ConsumoApi consumo = new ConsumoApi();
    private ConverteDados conversor = new ConverteDados();
    private final String ENDERECO = "https://gutendex.com/books/?search=";

    private LivroRepository livroRepository;
    private AutorRepository autorRepository;

    public Principal(LivroRepository livroRepository, AutorRepository autorRepository) {
        this.livroRepository = livroRepository;
        this.autorRepository = autorRepository;
    }

    public void exibeMenu() {
        var opcao = -1;
        while (opcao != 0) {
            var menu = """
                    \n---------------------------------
                    Escolha o número de sua opção:
                    1- buscar livro pelo título
                    2- listar livros registrados
                    3- listar autores registrados
                    4- listar autores vivos em um determinado ano
                    5- listar livros em um determinado idioma
                    
                    0- sair
                    ---------------------------------
                    """;

            System.out.println(menu);
            try {
                opcao = Integer.parseInt(leitura.nextLine());

                switch (opcao) {
                    case 1:
                        buscarLivroWeb();
                        break;
                    case 2:
                        listarLivrosRegistrados();
                        break;
                    case 3:
                        listarAutoresRegistrados();
                        break;
                    case 4:
                        listarAutoresVivosPorAno();
                        break;
                    case 5:
                        listarLivrosPorIdioma();
                        break;
                    case 0:
                        System.out.println("Saindo...");
                        break;
                    default:
                        System.out.println("Opção inválida!");
                }
            } catch (NumberFormatException e) {
                System.out.println("Por favor, digite um número válido.");
            }
        }
    }

    private void buscarLivroWeb() {
        System.out.println("Insira o nome do livro que você deseja procurar:");
        var tituloBusca = leitura.nextLine();
        var json = consumo.obterDados(ENDERECO + tituloBusca.replace(" ", "%20"));
        Resultados dadosBusca = conversor.obterDados(json, Resultados.class);

        if (dadosBusca.resultados() != null && !dadosBusca.resultados().isEmpty()) {
            DadosLivro dadosLivro = dadosBusca.resultados().get(0);
            
            // Verifica se o livro já está cadastrado
            Livro livroExistente = livroRepository.findByTituloIgnoreCase(dadosLivro.titulo());
            if (livroExistente != null) {
                System.out.println("Não é possível registrar o mesmo livro mais de uma vez.");
                System.out.println(livroExistente);
                return;
            }

            Autor autor;
            if (dadosLivro.autores() != null && !dadosLivro.autores().isEmpty()) {
                var dadosAutor = dadosLivro.autores().get(0);
                Autor autorExistente = autorRepository.findByNome(dadosAutor.nome());
                
                if (autorExistente != null) {
                    autor = autorExistente;
                } else {
                    autor = new Autor(dadosAutor);
                    autorRepository.save(autor);
                }
            } else {
                autor = new Autor();
                autor.setNome("Desconhecido");
                autorRepository.save(autor);
            }

            Livro livro = new Livro(dadosLivro, autor);
            livroRepository.save(livro);
            System.out.println("Livro salvo com sucesso:");
            System.out.println(livro);
        } else {
            System.out.println("Livro não encontrado.");
        }
    }

    private void listarLivrosRegistrados() {
        List<Livro> livros = livroRepository.findAll();
        if (livros.isEmpty()) {
            System.out.println("Nenhum livro registrado no banco de dados.");
        } else {
            livros.forEach(System.out::println);
        }
    }

    private void listarAutoresRegistrados() {
        List<Autor> autores = autorRepository.findAll();
        if (autores.isEmpty()) {
            System.out.println("Nenhum autor registrado no banco de dados.");
        } else {
            autores.forEach(a -> {
                System.out.println("\nAutor: " + a.getNome());
                System.out.println("Ano de nascimento: " + (a.getAnoNascimento() != null ? a.getAnoNascimento() : "Desconhecido"));
                System.out.println("Ano de falecimento: " + (a.getAnoFalecimento() != null ? a.getAnoFalecimento() : "Desconhecido"));
                System.out.println("Livros: " + a.getLivros().stream().map(Livro::getTitulo).toList());
            });
        }
    }

    private void listarAutoresVivosPorAno() {
        System.out.println("Insira o ano que deseja pesquisar:");
        try {
            int ano = Integer.parseInt(leitura.nextLine());
            List<Autor> autoresVivos = autorRepository.buscarAutoresVivosNoAno(ano);
            
            if (autoresVivos.isEmpty()) {
                System.out.println("Nenhum autor encontrado vivo no ano de " + ano);
            } else {
                autoresVivos.forEach(a -> {
                    System.out.println("\nAutor: " + a.getNome());
                    System.out.println("Ano de nascimento: " + a.getAnoNascimento());
                    System.out.println("Ano de falecimento: " + (a.getAnoFalecimento() != null ? a.getAnoFalecimento() : "Desconhecido"));
                    System.out.println("Livros: " + a.getLivros().stream().map(Livro::getTitulo).toList());
                });
            }
        } catch (NumberFormatException e) {
            System.out.println("Por favor, digite um ano válido.");
        }
    }

    private void listarLivrosPorIdioma() {
        System.out.println("""
                Insira o idioma para realizar a busca:
                es- espanhol
                en- inglês
                fr- francês
                pt- português
                """);
        String idioma = leitura.nextLine();
        
        List<Livro> livrosIdioma = livroRepository.findByIdioma(idioma);
        if (livrosIdioma.isEmpty()) {
            System.out.println("Não existem livros nesse idioma no banco de dados.");
        } else {
            livrosIdioma.forEach(System.out::println);
        }
    }
}
