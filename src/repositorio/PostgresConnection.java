package repositorio;


import com.sun.tools.javac.Main;
import model.*;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PostgresConnection implements Repositorio {

    public PostgresConnection(){
        cursos();
        disciplinas();
        professores();

    }
    public  List<Diciplina> diciplinaList() throws SQLException {
        List<Diciplina> diciplinaList = disciplinas();
        for (int i = 0; i < disciplinas().size() ; i++) {
            PreparedStatement preparedStatement = connection
                    .prepareStatement("SELECT * FROM disciplinas");
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                Diciplina equivalente = null;
                Diciplina alvo = new Diciplina(0,0,"",null);
                if(resultSet.getInt(4) >0){
                    //System.out.println(resultSet.getInt(4));
                    for (Diciplina eq: disciplinas()) {
                        if(eq.getCodigoDisciplina() == resultSet.getInt(4)){
                            equivalente = eq;
                        }
                    }
                    for (Diciplina alv: disciplinas()) {
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
        List<Professores> professoresList = professores();

        for (Curso curso: cursos()) {
            for (int i = 0;  i<professores().size(); i++) {
                PreparedStatement preparedStatement =
                        connection
                                .prepareStatement("SELECT * FROM professores WHERE cod_curso = " +curso.getCodigoCurso());
                ResultSet resultSet = preparedStatement.executeQuery();

                while (resultSet.next()){
                    if(resultSet.getInt(1) == professores().get(i).getCodigoProfessor()){
                        professores().get(i).setCodigoCurso(curso);
                        professoresList.get(i).setCodigoCurso(curso) ;}

                }
            }

        }
        return professoresList;
    }
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
    public Diciplina disciplina(int resultset){
        for (Diciplina disciplina: disciplinas()) {
            if(disciplina.getCodigoDisciplina() == resultset){
                return disciplina;
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
    public List<Turma> turmas() {
        List<Turma> turmas = new ArrayList<>();
        try{
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM turmas");
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                turmas.add(
                        new Turma(
                            resultSet.getInt(1),
                            resultSet.getInt(2),
                            resultSet.getString(4),
                            disciplina(resultSet.getInt(3)),
                            resultSet.getInt(5),
                            resultSet.getInt(6),
                            professor(resultSet.getInt(7))
                        )
                );
            }

        }catch (Exception ex){

        }
        return turmas;
    }

    @Override
    public List<TurmasMatricula> turmasMatriculadas() {
        return null;
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







