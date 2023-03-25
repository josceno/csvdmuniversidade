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
    Repositorio repositorio = new PostgresConnection();
    Connection connection = repositorio.connectar("ETL-UNIVERSIDADE","postgres","changeme");
    public  List<Diciplina> diciplinaList() throws SQLException {
        List<Diciplina> diciplinaList = repositorio.disciplinas();
        for (int i = 0; i < repositorio.disciplinas().size() ; i++) {
            PreparedStatement preparedStatement = connection
                    .prepareStatement("SELECT * FROM disciplinas");
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                Diciplina equivalente = null;
                Diciplina alvo = new Diciplina(0,0,"",null);
                if(resultSet.getInt(4) >0){
                    //System.out.println(resultSet.getInt(4));
                    for (Diciplina eq: repositorio.disciplinas()) {
                        if(eq.getCodigoDisciplina() == resultSet.getInt(4)){
                            equivalente = eq;
                        }
                    }
                    for (Diciplina alv: repositorio.disciplinas()) {
                        if(alv.getCodigoDisciplina() == resultSet.getInt(1)){
                            alvo = alv;
                        }
                    }
                };

                if(diciplinaList.get(i).getCodigoDisciplina() == alvo.getCodigoDisciplina()){
                    diciplinaList.get(i).setEquivalente(equivalente);
                }


            }



        }
        return diciplinaList;

    }
    public  List<Professores> professoresList() throws SQLException {
        List<Professores> professoresList = repositorio.professores();

        for (Curso curso: repositorio.cursos()) {
            for (int i = 0;  i<repositorio.professores().size(); i++) {
                PreparedStatement preparedStatement =
                        connection
                                .prepareStatement("SELECT * FROM professores WHERE cod_curso = " +curso.getCodigoCurso());
                ResultSet resultSet = preparedStatement.executeQuery();

                while (resultSet.next()){
                    if(resultSet.getInt(1) == repositorio.professores().get(i).getCodigoProfessor()){
                        repositorio.professores().get(i).setCodigoCurso(curso);
                        professoresList.get(i).setCodigoCurso(curso) ;}

                }
            }

        }
        return professoresList;
    }
    public static void main(String[] args) throws SQLException {
        Repositorio repositorio = new PostgresConnection();


        PostgresConnection prin = new PostgresConnection();

        for (int i = 0; i < 3; i++) {
            //repositorio.cursos().forEach(System.out::println);
            prin.professoresList().forEach(System.out::println);
            //prin.diciplinaList()
            //repositorio.alunos().forEach(System.out::println);
           repositorio.turmas().forEach(System.out::println);

            /*for (Diciplina d: prin.diciplinaList()) {
                   try {
                       System.out.println(d);
                   }catch (NullPointerException e){
                       throw  e;

                   }
            }*/

        }

    }
}