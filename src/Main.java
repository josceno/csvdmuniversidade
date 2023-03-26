import repositorio.PostgresConnection;
import repositorio.Repositorio;

import java.sql.SQLException;

public class Main {
    public static Repositorio repositorio = new PostgresConnection();
    //Connection connection = repositorio.connectar("ETL-UNIVERSIDADE","postgres","changeme");
    public static void main(String[] args) throws SQLException {;

        PostgresConnection prin = new PostgresConnection();


        //repositorio.cursos().forEach(System.out::println);
        //prin.professoresList().forEach(System.out::println);
        //prin.diciplinaList().forEach(System.out::println);
        //repositorio.alunos().forEach(System.out::println);
        //repositorio.turmas().forEach(System.out::println);
        //repositorio.turmasMatriculadas().forEach(System.out::println);


    }
}