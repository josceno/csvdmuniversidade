package repositorio;


import model.Aluno;
import model.Curso;
import model.Diciplina;
import model.Professores;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PostgresConnection implements Repositorio {

    public Connection connectar(String dbname, String user, String pass) {

        Connection conn = null;
        try {
            Class.forName("org.postgresql.Driver");
            conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/" + dbname, user, pass);
            if (conn != null) {
               // System.out.println("Connection Established");
            } else {
                System.out.println("Connection Failed");
            }

        } catch (Exception e) {
            System.out.println(e);
        }
        return conn;
    }
    private final Connection connection = connectar("ETL-UNIVERSIDADE","postgres","changeme");
    @Override
    public List<Curso> cursos() {
        List<Curso> cursos = new ArrayList<>();
        try{
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM cursos");
            ResultSet resultSet = preparedStatement.executeQuery();
            while(resultSet.next()){
                cursos.add(
                    new Curso(
                    resultSet.getInt(1),
                    resultSet.getInt(2),
                    resultSet.getString(3),
                    professor(resultSet.getInt(4))
                    )
                );

            }
        }catch (Exception ex){
           System.out.println(ex);

        }

        return cursos;
    }
    public  Professores professor (int resultSet){
        for (Professores p: professores()) {
            if(p.getCodigoProfessor()== resultSet ){
                return  p;
            }

        }
        return null;

    }
    public Curso curso(int resultset){
        cursos();
        for (Curso c : cursos()){
            if(c.getCodigoCurso() == resultset){
                return  c;
            }
        }
        return null;

    }

    @Override
    public List<Professores> professores()  {
        List<Professores> professores = new ArrayList<>();
        try{
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM professores");
            ResultSet resultSet = preparedStatement.executeQuery();
            while(resultSet.next()){
                //System.out.println(resultSet.getInt(2));
                // System.out.println(curso(resultSet.getInt(2)));
                //curso(resultSet.getInt(2));
                //cursos().forEach(System.out::println);
                professores.add(
                        new Professores(
                                resultSet.getInt(1),
                                null,
                                resultSet.getString(3),
                                resultSet.getString(4)
                        )
                );
            }
        }catch (Exception ex){
            System.out.println(ex);

        }

        return professores;


    }

    @Override
    public List<Diciplina> disciplinas() {
        List<Diciplina> disciplinas = new ArrayList<>();
        try{
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM disciplinas");
            ResultSet resultSet = preparedStatement.executeQuery();
            while(resultSet.next()){
                disciplinas.add(
                        new Diciplina(
                                resultSet.getInt(1),
                                resultSet.getInt(2),
                                resultSet.getString(3),
                                null
                        )
                );
            }
        }catch (Exception e){

        }
        return disciplinas;
    }

    @Override
    public List<Aluno> alunos() {

        List<Aluno> alunos = new ArrayList<>();

        try{
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM alunos");
            ResultSet resultSet = preparedStatement.executeQuery();
            while(resultSet.next()){
                alunos.add(
                        new Aluno(
                                resultSet.getInt(1),
                                curso(resultSet.getInt(2)),
                                resultSet.getDate(3),
                                resultSet.getInt(4),
                                resultSet.getDouble(5),
                                resultSet.getString(6),
                                resultSet.getString(7)
                        )
                );
            }


        }catch (Exception ex){
            System.out.println(ex);
        }
        return alunos;
    }




}







