package repositorio;

import model.Aluno;
import model.Curso;
import model.Diciplina;
import model.Professores;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public interface Repositorio {
    public Connection connectar(String dbname, String user, String pass);
    public List<Aluno> alunos();
    public List<Curso> cursos();
    public List<Professores> professores() throws SQLException;
    List<Diciplina> disciplinas();

}
