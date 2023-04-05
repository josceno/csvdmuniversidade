package repositorio;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import modelo_dimensional.AlunoDm;
import modelo_dimensional.CursoDm;
import modelo_dimensional.DisciplinaDm;
import modelo_dimensional.HistoricoDm;
import modelo_dimensional.ProfessorDm;
import modelo_dimensional.TempoDm;
import modelo_dimensional.TurmaDm;
import modelo_relacional.Aluno;
import modelo_relacional.Curso;
import modelo_relacional.Diciplina;
import modelo_relacional.HistoricosEscolares;
import modelo_relacional.Professores;
import modelo_relacional.Turma;
import modelo_relacional.TurmasMatricula;

public class InserirWarehouse {
    static Repositorio repositorio = new PostgresConnection();
    
    public static List<AlunoDm> pegarAlunos(){
   
        List<AlunoDm> alunosDm = new ArrayList<>();
        for (Aluno aluno : repositorio.alunos()) {
            alunosDm.add( new AlunoDm(aluno.getMatricula()
            ,aluno.getDatanascimento()
            ,aluno.getNomeAluno()
            ,aluno.getEmail()
            ,repositorio)
            );
        }

        return alunosDm;        
    }
    public static void inserirAluno(){
        Connection connection = repositorio.connectar("ETL-UNIVERSIDADE","postgres","changeme");    
        try {
            for(AlunoDm alunoDm : InserirWarehouse.pegarAlunos()){
                PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO dm_aluno" 
                +"(dm_aluno_matricula,dm_aluno_nome,dm_aluno_dtnascimeto,dm_aluno_percentual_aprovacao)"
                +"values (?,?,?,?,?)"  
                );
    
                preparedStatement.setString(1, ""+alunoDm.getMatricula());
                preparedStatement.setString(2, alunoDm.getNomeAluno());
                preparedStatement.setString(3, alunoDm.getEmail());
                preparedStatement.setDate(4, alunoDm.getDatanascimento());
                preparedStatement.setDouble(5, alunoDm.getPctualAprovacao());

                preparedStatement.executeUpdate();
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    public static List<CursoDm> pegarCursoDm(){
        
        List<CursoDm> cursosDm = new ArrayList<>();
        for (Curso curso : repositorio.cursos()) {
            cursosDm.add( new CursoDm(
              curso.getCodigoCurso(),
              repositorio)
            );
        }

        return cursosDm;        
    }
    public static void inserirCursoDm(){
        Connection connection = repositorio.connectar("ETL-UNIVERSIDADE","postgres","changeme");    
        try {
            for(CursoDm cursoDm : InserirWarehouse.pegarCursoDm()){
                PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO dm_curso" 
                +"(dm_curso_pk,dm_curso_qtd,dm_curso_mgp)"
                +"values (?,?,?)"  
                );
    
                preparedStatement.setInt(1, cursoDm.getCodigoCurso());
                preparedStatement.setDouble(2,cursoDm.getMgp());
                preparedStatement.setInt(3, cursoDm.getQtdAlunos());
               

                preparedStatement.executeUpdate();
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    public static List<DisciplinaDm> pegarDisciplinaDm(){
        
        List<DisciplinaDm> disciplinasDm = new ArrayList<>();
        try {
            for (Aluno aluno : repositorio.alunos()) {
                for (Diciplina disciplina : repositorio.diciplinaList()) {
                    disciplinasDm.add( 
                     new DisciplinaDm(
                      disciplina.getCodigoDisciplina(),
                      disciplina.getNomeDisciplina(),
                      aluno
                      )
                    );
                  
                }
            }
        }catch (Exception e) {
           System.out.println(e.getMessage());
        }
    
        return disciplinasDm;

            
    }
    public static void inserirDisciplinaDm(){
        Connection connection = repositorio.connectar("ETL-UNIVERSIDADE","postgres","changeme");    
        try {
            for(CursoDm cursoDm : InserirWarehouse.pegarCursoDm()){
                PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO dm_disciplina" 
                +"(dm_disciplina_pk,dm_disciplina_qtd,dm_disciplina_mgp)"
                +"values (?,?,?)"  
                );
    
                preparedStatement.setInt(1, cursoDm.getCodigoCurso());
                preparedStatement.setDouble(2,cursoDm.getMgp());
                preparedStatement.setInt(3, cursoDm.getQtdAlunos());
               

                preparedStatement.executeUpdate();
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    public static void inserirHistoricoDm() {
        Connection connection = repositorio.connectar("ETL-UNIVERSIDADE", "postgres", "changeme");
        try {
            for (HistoricoDm historicoDm : InserirWarehouse.pegarHistoricoDm()) {
                PreparedStatement preparedStatement = connection.prepareStatement(
                        "INSERT INTO dm_historico ("
                        +"dm_historico_nota1"
                        +",dm_historico_nota2,"
                        +"dm_historico_nota3"
                        +",dm_historico_nota4"
                        +",dm_historico_faltas"
                        +",dm_historico_situacao"+") VALUES (?,?,?,?,?,?)"
                );
    
                preparedStatement.setDouble(2, historicoDm.getNota1());
                preparedStatement.setDouble(3, historicoDm.getNota2());
                preparedStatement.setDouble(4, historicoDm.getNota3());
                preparedStatement.setDouble(5, historicoDm.getNota4());
                preparedStatement.setInt(5, historicoDm.getFaltas());
                preparedStatement.setString(6, ""+historicoDm.getAluno().getMatricula());
    
                preparedStatement.executeUpdate();
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    
    public static List<HistoricoDm> pegarHistoricoDm() {
        List<HistoricoDm> historicosDm = new ArrayList<>();
        try {
            for (HistoricosEscolares historicoE : repositorio.historcosEscolares()) {
                historicosDm.add(new HistoricoDm(repositorio, historicoE.getSituacao(), historicoE.getAluno()));
                    
            }         
            
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return historicosDm;
    }
    public static void inserirProfessorDm() {
        Connection connection = repositorio.connectar("ETL-UNIVERSIDADE", "postgres", "changeme");
        try {
            for (ProfessorDm professorDm : pegarProfessorDm()) {
                PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO dm_professor" +
                        "(dm_professor_pk, dm_professor_nome, dm_professor_email, dm_professor_reprovacao_pctg, dm_professor_coordenador)" +
                        "values (?,?,?,?,?)"
                );
    
                preparedStatement.setInt(1, professorDm.getCodigoProfessor());
                preparedStatement.setString(2, professorDm.getNome());
                preparedStatement.setString(3, professorDm.getEmail());
                preparedStatement.setDouble(4, professorDm.getReprovacaopctg());
                preparedStatement.setBoolean(5, professorDm.isCoordenador());
    
                preparedStatement.executeUpdate();
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    
    public static List<ProfessorDm> pegarProfessorDm() throws Exception {
        List<ProfessorDm> professoresDm = new ArrayList<>();
        try {
            for (Professores professor : repositorio.professores()) {
                professoresDm.add(new ProfessorDm(
                        professor.getCodigoProfessor(),
                        professor.getNomeProfessor(),
                        professor.getEmail(),
                        repositorio
                ));
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return professoresDm;
    }
    public static void inserirTempoDm() {
        Connection connection = repositorio.connectar("ETL-UNIVERSIDADE", "postgres", "changeme");
        try {
            for (TempoDm tempoDm : pegarTempoDm()) {
                PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO dm_tempo" +
                        "(dm_tempo_ano, dm_tempo_semestre)" +
                        "values (?,?)"
                );
    
                preparedStatement.setInt(2, tempoDm.getAno());
                preparedStatement.setInt(3, tempoDm.getSemestre());
    
                preparedStatement.executeUpdate();
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    
    public static List<TempoDm> pegarTempoDm() {
        List<TempoDm> temposDm = new ArrayList<>();
        for (int ano = 2010; ano <= 3000; ano++) {
            for (int semestre = 1; semestre <= 2; semestre++) {
                temposDm.add(new TempoDm(ano, semestre));
            }
        }
        return temposDm;
    }
    public static void inserirTurmaDm() {
        Connection connection = repositorio.connectar("ETL-UNIVERSIDADE", "postgres", "changeme");
        try {
            for (TurmaDm turmaDm : pegarTurmaDm()) {
                PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO dm_turma" +
                        "(dm_turma_pk, dm_turma_nome, dm_turma_nota1, dm_turma_nota2, dm_turma_nota3, dm_turma_nota4, dm_turma_faltas1, dm_turma_media)" +
                        "values (?,?,?,?,?,?,?)"
                );
    
                preparedStatement.setString(2, turmaDm.getNome());
                preparedStatement.setDouble(3, turmaDm.getNota1());
                preparedStatement.setDouble(4, turmaDm.getNota2());
                preparedStatement.setDouble(5, turmaDm.getNota3());
                preparedStatement.setDouble(6, turmaDm.getNota4());
                preparedStatement.setInt(7, turmaDm.getFaltas1());
                preparedStatement.setDouble(8, turmaDm.getMedia());
    
                preparedStatement.executeUpdate();
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    
    public static List<TurmaDm> pegarTurmaDm() throws Exception {
        List<TurmaDm> turmasDm = new ArrayList<>();
        try {
            
            for (TurmasMatricula turmaM : repositorio.turmasMatriculadas()) {
                turmasDm.add(new TurmaDm(
                     turmaM.getNome(),
                     turmaM.getNota1(),
                     turmaM.getNota2(),
                     turmaM.getNota3(),
                     turmaM.getNota4(),
                     
                     turmaM.getFaltas1() + turmaM.getFaltas2()+ turmaM.getFaltas3()
                ));
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return turmasDm;
    }
    
    
    
}
