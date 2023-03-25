import model.Curso;
import model.Diciplina;
import model.Professores;
import repositorio.PostgresConnection;
import repositorio.Repositorio;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static Repositorio repositorio = new PostgresConnection();
    //Connection connection = repositorio.connectar("ETL-UNIVERSIDADE","postgres","changeme");
    public static void main(String[] args) throws SQLException {;

        PostgresConnection prin = new PostgresConnection();

        for (int i = 0; i < 3; i++) {
            //repositorio.cursos().forEach(System.out::println);
            //prin.professoresList().forEach(System.out::println);
            prin.diciplinaList().forEach(System.out::println);
            repositorio.alunos().forEach(System.out::println);
           //repositorio.turmas().forEach(System.out::println);
        }

    }
}