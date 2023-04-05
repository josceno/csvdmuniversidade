package repositorio;

import modelo_relacional.*;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public interface Repositorio {
    public Connection connectar(String dbname, String user, String pass);
    public List<Aluno> alunos();
    public List<Curso> cursos();
    public List<Professores> professores() throws Exception;
    public  List<Diciplina> disciplinas();
    public  List<Turma> turmas();
    public  List<TurmasMatricula> turmasMatriculadas();
    public  List<HistoricosEscolares> historcosEscolares();
    public List<Curriculo> curriculos();

    public List<Diciplina> diciplinaList() throws Exception;
    public List<Professores> professoresList() throws Exception;

}
