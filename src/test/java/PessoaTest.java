import br.sapiens.MeuException;
import br.sapiens.modelo.CursosEnum;
import br.sapiens.modelo.Pessoa;
import br.sapiens.modelo.ProfissaoEnum;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class PessoaTest {

    @Test
    public void criaPessoaValida() throws MeuException {
        new Pessoa("Windson","Gadelha","windson@gmail.com",CursosEnum.SISTEMAS, ProfissaoEnum.Nenhum, true);
    }

    @Test
    public void naoPermitePessoaSemNome(){
        assertThrows(Throwable.class,() -> {
            new Pessoa(null,"Gadelha","windson@gmail.com",CursosEnum.SISTEMAS, ProfissaoEnum.Nenhum, true);
            new Pessoa("","Gadelha","windson@gmail.com",CursosEnum.SISTEMAS, ProfissaoEnum.Nenhum, true);
        });
    }

    @Test
    public void naoPermitePessoaSemSobreNome(){
        assertThrows(Throwable.class,() -> {
            new Pessoa("windson",null,"windson@gmail.com",CursosEnum.SISTEMAS, ProfissaoEnum.Nenhum, true);
            new Pessoa("windson","","windson@gmail.com",CursosEnum.SISTEMAS, ProfissaoEnum.Nenhum, true);
        });
    }

    @Test
    public void deveTerEmailValido(){
        assertThrows(Throwable.class,() -> {
            new Pessoa("Windson","Gadelha","windson",CursosEnum.SISTEMAS, ProfissaoEnum.Nenhum, true);
            new Pessoa("Windson","Gadelha","@",CursosEnum.SISTEMAS, ProfissaoEnum.Nenhum, true);
            new Pessoa("Windson","Gadelha","windson@gmail",CursosEnum.SISTEMAS, ProfissaoEnum.Nenhum, true);
            new Pessoa("Windson","Gadelha","windson@.com",CursosEnum.SISTEMAS, ProfissaoEnum.Nenhum, true);
        });
    }

    @Test
    public void profissaoPadraoDeveSerNenhum() throws MeuException {
        //TODO criar um enum de profissoes
        var pessoa = new Pessoa("Windson","Gadelha","windson@.com",CursosEnum.SISTEMAS, ProfissaoEnum.Nenhum, true);
        assertTrue(pessoa.getProfissao().equals(ProfissaoEnum.Nenhum));
    }

    @Test
    public void naoDeveConterNenhumaDisciplinaEmPessoa() throws MeuException {
        //TODO criar a propriedade disciplina e relacionar com o objeto pessoa!
        // Elaborar uma forma de represemtar o aluno na diciplina
        // Existe uma palavra epecial para essa rela????o aluno - diciplina
        // Matricula
        var pessoa = new Pessoa("Windson","Gadelha","windson@.com",CursosEnum.SISTEMAS, ProfissaoEnum.Nenhum, true);
        assertTrue(pessoa.getMatriculas().size() == 0);
    }

    @Test
    public void pessoaTemBolsa() throws MeuException {
        //TODO criar uma propriedade boleana
        // que informa se esse aluno tem bolsa de estudos, padr??o falso
        var pessoa = new Pessoa("Windson","Gadelha","windson@.com",CursosEnum.SISTEMAS, ProfissaoEnum.Nenhum, true);
        assertFalse(pessoa.getBolsa());
        pessoa.setBolsa(true); //Estou dando uma bolsa para o auno
        assertTrue(pessoa.getBolsa());
    }

    @Test
    public void pessoaSempreTerCurso() throws MeuException {
        //TODO criar uma propriedade curso em pessoa
        // validar que a pessoa nunca tenha curso == null
        // Curso pode ser um enum, coloque duas op????es, sistemas e direito
        var pessoa = new Pessoa("Windson","Gadelha","windson@.com", CursosEnum.SISTEMAS, ProfissaoEnum.Nenhum, true);
        assertTrue(pessoa.getCurso() != null);
    }

    @Test
    public void pessoaNaoPodeFazerDiciplinaOutroCurso(){
        //TODO criar uma propriedade pessoa
        // validar que a pessoa nunca tenha curso = null

        //Fazer a interface para adcionar pessoas a um curso -- depois de fazer a UI
    }
}
