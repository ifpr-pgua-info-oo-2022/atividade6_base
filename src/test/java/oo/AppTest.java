package oo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.beans.Transient;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.time.LocalDateTime;
import java.util.ArrayList;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


/**************/
/*REPITA COMIGO:*/
/*NÃO PRECISO ALTERAR ESSE ARQUIVO*/
/*NÃO PRECISO ALTERAR ESSE ARQUIVO*/
/*NÃO PRECISO ALTERAR ESSE ARQUIVO*/
/*NÃO PRECISO ALTERAR ESSE ARQUIVO*/

/*ESTA CLASSE POSSUI UMA SÉRIE DE TESTES AUTOMATIZADOS
 *PARA VERIFICAR SE O CÓDIGO QUE VOCÊ CRIOU ESTÁ FUNCIONANDO
 *E FAZENDO AQUILO QUE É ESPERADO.
 *O QUE VOCÊ PRECISA NESTE FAZER É CLICAR NA SETINHA
 * VERDE QUE FICA AO LADO DO NOME DE CADA MÉTODO.
 * SE O VSCODE INDICAR QUE EXISTEM ERROS DE COMPILAÇÃO,
 * PODE CLICAR NO CANTO INFERIOR DIREITO NO BOTÃO DE PROCEED.
 * A DICA É COMEÇAR A RESOLVER CADA UM DOS TESTES NA SEQUÊNCIA.
 * O OBJETIVO É DEIXAR TODOS OS TESTES PASSANDO (CHECK VERDE) AO FINAL
 * DA ATIVIDADE.
*/




public class AppTest 
{

   
    @Test
    @DisplayName("A classe livro possui todos os atributos com os tipos definidos")
    public void testaTiposAtributosLivro()throws NoSuchFieldException{
        Class<Livro> clazz = Livro.class;
        
        Field titulo = clazz.getDeclaredField("titulo");
        Field autor = clazz.getDeclaredField("autor");
        Field numeroPaginas = clazz.getDeclaredField("numeroPaginas");
        
        
        assertEquals(true,titulo.getType()==String.class,"O tipo do titulo está errado");
        assertEquals(true,autor.getType()==String.class,"O tipo do autor está errado");
        assertEquals(true,numeroPaginas.getType().getTypeName()=="int","O tipo do numeroPaginas está errado");
        
    }


    @Test
    @DisplayName("A classe livro possui todos os atributos e são privados")
    public void testaAtributosLivro()throws NoSuchFieldException{
        Class<Livro> clazz = Livro.class;
        
        Field titulo = clazz.getDeclaredField("titulo");
        Field autor = clazz.getDeclaredField("autor");
        Field numeroPaginas = clazz.getDeclaredField("numeroPaginas");
        
        
        assertEquals(true,Modifier.isPrivate(titulo.getModifiers()),"O atributo não está privado");
        assertEquals(true,Modifier.isPrivate(autor.getModifiers()),"O atributo não está privado");
        assertEquals(true,Modifier.isPrivate(numeroPaginas.getModifiers()),"O atributo não está privado");
    
    }

    @Test
    @DisplayName("Na classe livro existe somente um método construtor definido")
    public void testaConstrutorLivro(){

        String titulo = "Livro Legal";
        String autor = "Autor Bom";
        int numeroPaginas = 100;
        
        Livro livro = new Livro(titulo,autor,numeroPaginas);
        
        assertEquals(1, Livro.class.getDeclaredConstructors().length,"A classe livro possui mais de um construtor");

    }   

    @Test
    @DisplayName("Na classe livro existe os getters e os atributos estão com valores corretos")
    public void testaGettersEInicializacaoLivro(){

        String titulo = "Livro Legal";
        String autor = "Autor Bom";
        int numeroPaginas = 100;
        
        Livro livro = new Livro(titulo,autor,numeroPaginas);

        assertEquals(livro.getTitulo(), titulo,"O getter não está correto");
        assertEquals(livro.getAutor(), autor,"O getter não está correto");
        assertEquals(livro.getNumeroPaginas(), numeroPaginas,"O getter não está correto");
    
    }


    @Test
    @DisplayName("Existe os setters e os atributos são atualizados com valores corretos")
    public void testaSettersEAtualizacaoLivro(){

        
        String titulo = "Livro Legal";
        String autor = "Autor Bom";
        int numeroPaginas = 100;
        
        Livro livro = new Livro(titulo,autor,numeroPaginas);

        titulo = "Livro Legal Mudou";
        autor = "Autor Bom Mudou";
        numeroPaginas = 102;

        livro.setTitulo(titulo);
        livro.setAutor(autor);
        livro.setNumeroPaginas(numeroPaginas);

        assertEquals(livro.getTitulo(), titulo,"O setter não funcionou");
        assertEquals(livro.getAutor(), autor,"O setter não funcionou");
        assertEquals(livro.getNumeroPaginas(), numeroPaginas,"O setter não funcionou");
    
    }


    @Test
    @DisplayName("A classe Biblioteca existe e possui os atributos corretos e privados")
    public void testaBibliotecaDeclaradoCorreto() throws NoSuchFieldException{
        Class clazz = Biblioteca.class;

        Field nome = clazz.getDeclaredField("nome");
        Field telefone = clazz.getDeclaredField("telefone");
        Field livros = clazz.getDeclaredField("livros");

        assertEquals(true, nome.getType() == String.class,"O tipo está errado");
        assertEquals(true, telefone.getType() == String.class,"O tipo está errado");
        assertEquals(true, livros.getType() == ArrayList.class,"O tipo está errado");
        

        assertEquals(true, Modifier.isPrivate(nome.getModifiers()),"O atributo nome não está privado");
        assertEquals(true, Modifier.isPrivate(telefone.getModifiers()),"O atributo telefone não está privado");
        assertEquals(true, Modifier.isPrivate(livros.getModifiers()),"O atributo livros não está privado");
        
    }

    @Test
    @DisplayName("A classe Biblioteca possui somente o construtor declarado")
    public void testaInstanciarBiblioteca(){

        Biblioteca biblioteca = new Biblioteca("Biblioteca","1122");
        
        assertEquals(1, Biblioteca.class.getDeclaredConstructors().length,"A classe biblioteca possui mais de um construtor");

    }

    @Test
    @DisplayName("A classe biblioteca permite listar todos os livros")
    public void testaListaTodosLivros(){
        
        Biblioteca biblioteca = new Biblioteca("Biblioteca","1122");

        ArrayList<Livro> lista = biblioteca.listarLivros();

        assertNotNull(lista,"O retorno do método listarLivros não pode ser null");
        assertEquals(0, lista.size(),"A quantidade de elementos da lista deveria ser 0");

    }


    @Test
    @DisplayName("A classe biblioteca permite registrar um livro e armazena no arraylist")
    public void testaCadastrarLivro(){
        String titulo = "Livro Legal";
        String autor = "Autor Bom";
        int numeroPaginas = 100;
        
        
        Biblioteca biblioteca = new Biblioteca("Biblioteca","1122");

        
        boolean ret = biblioteca.cadastrarLivro(titulo, autor, numeroPaginas);
        
        assertEquals(true,ret,"O método cadastrarLivro deve retornar true neste caso");
        assertEquals(1, biblioteca.listarLivros().size(),"Depois de cadastrar um livro o tamanho da lista deve ser 1");
        assertEquals(titulo, biblioteca.listarLivros().get(0).getTitulo(),"O titulo do livro cadastrado deve estar na lista");

    }


    @Test
    @DisplayName("A classe biblioteca não permite registrar dois livros com a mesmo titulo")
    public void testaNaoCadastrarLivroRepetido(){
        
        Biblioteca biblioteca = new Biblioteca("Biblioteca","1122");
        
        String titulo1 = "Livro Legal 1";
        String autor1 = "Autor Bom 1";
        int numeroPaginas1 = 101;

        String titulo2 = "Livro Legal 1";
        String autor2 = "Autor Bom 2";
        int numeroPaginas2 = 102;

        boolean ret1 = biblioteca.cadastrarLivro(titulo1,autor1,numeroPaginas1);
        boolean ret2 = biblioteca.cadastrarLivro(titulo2,autor2,numeroPaginas2);
        
        assertEquals(true,ret1,"O retorno do método cadastrarLivro deve ser true neste caso");
        assertEquals(false, ret2,"O retorno do método cadastrarLivro deve ser false");
        assertEquals(1, biblioteca.listarLivros().size(),"O tamanho da lista deve ser 1 depois de cadastrar um livro");
    
    }

    @Test
    @DisplayName("A classe biblioteca permite buscar um livro pelo titulo")
    public void testaBuscarLivroTitulo(){
        Biblioteca biblioteca = new Biblioteca("Biblioteca","1122");
        
        String titulo1 = "Livro Legal 1";
        String autor1 = "Autor Bom 1";
        int numeroPaginas1 = 101;

        String titulo2 = "Livro Legal 2";
        String autor2 = "Autor Bom 2";
        int numeroPaginas2 = 102;

        boolean ret1 = biblioteca.cadastrarLivro(titulo1,autor1,numeroPaginas1);
        boolean ret2 = biblioteca.cadastrarLivro(titulo2,autor2,numeroPaginas2);

        Livro livro = biblioteca.buscarLivro(titulo1);

        assertEquals(titulo1,livro.getTitulo(),"O livro não foi encontrado corretamente");
    }

    @Test
    @DisplayName("A classe biblioteca retorna null buscar um livro por um titulo que não existe")
    public void testaNullBuscarLivroTituloNaoCadastrado(){
        Biblioteca biblioteca = new Biblioteca("Biblioteca","1122");
        
        String titulo1 = "Livro Legal 1";
        String autor1 = "Autor Bom 1";
        int numeroPaginas1 = 101;

        String titulo2 = "Livro Legal 2";
        String autor2 = "Autor Bom 2";
        int numeroPaginas2 = 102;

        String titulo3 = "Livro Legal 3";

        boolean ret1 = biblioteca.cadastrarLivro(titulo1,autor1,numeroPaginas1);
        boolean ret2 = biblioteca.cadastrarLivro(titulo2,autor2,numeroPaginas2);

        Livro livro = biblioteca.buscarLivro(titulo3);

        assertNull(livro,"O livro não deveria ter sido encontrado");
    }

}