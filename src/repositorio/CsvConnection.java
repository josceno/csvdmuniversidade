package repositorio;

import java.io.BufferedReader;
import java.io.FileReader;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sound.sampled.Line;

import modelo_relacional.Aluno;
import modelo_relacional.Curriculo;
import modelo_relacional.Curso;
import modelo_relacional.Diciplina;
import modelo_relacional.HistoricosEscolares;
import modelo_relacional.Professores;
import modelo_relacional.Turma;
import modelo_relacional.TurmasMatricula;

public class CsvConnection implements Repositorio {
    String path = "c:\\csvdmuniversidade\\";
    String arquivo; 
    @Override
    public Connection connectar(String dbname, String user, String pass) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'connectar'");
    }

    @Override
    public List<Aluno> alunos() {
        arquivo = "aluno.csv";
        List<Aluno> alunos = new ArrayList<>();
        try(BufferedReader br = new BufferedReader(new  FileReader(path+arquivo))) {
            String line = br.readLine();
            while(line !=null){
                String[] lines = line.split(",");
              
            }
            
        } catch (Exception e) {
            // TODO: handle exception
        }
        throw new UnsupportedOperationException("Unimplemented method 'alunos'");
    }
    Professores professor(int line) throws SQLException {
        for (Professores p: professores()) {
            if(p.getCodigoProfessor() == line){
                return p;
            }
        }
        return null;

    }
    @Override
    public List<Curso> cursos() {
        arquivo = "cursos.csv";
        List<Curso> cursos = new ArrayList<>();
        try(BufferedReader br = new BufferedReader(new  FileReader(path+arquivo))) {
            String line = br.readLine();
            
            while(line !=null){
                String[] lines = line.split(",");
                cursos.add(new Curso(
                    Integer.parseInt(lines[0]),
                    Integer.parseInt(lines[1]),
                    lines[2],
                    professor(Integer.parseInt(lines[3])))
                    );
                line = br.readLine();    

            }
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        return cursos;
        
    
    }
    public Curso curso(int line){
        for (Curso curso : cursos()) {
            if(curso.getCodigoCurso() == line){
                return curso;
            }
        }
        return null;
    }

    @Override
    public List<Professores> professores(){
        arquivo = "professores.csv";
        List<Professores> professores = new ArrayList<>();
        try(BufferedReader br = new BufferedReader(new FileReader(path+ arquivo))){
            String line = br.readLine();
            while(!line.equals(null) || line.equals("")){
                String[] lines = line.split(",");
                professores.add(
                    new Professores(
                        Integer.parseInt(lines[0]),
                        curso(Integer.parseInt(lines[1])),
                        lines[2],
                        lines[3]
                    )
                );
                line = br.readLine();
            }  

        }catch(Exception e){
            System.out.println(e.getMessage());
        }
        return professores;
    }

    @Override
    public List<Diciplina> disciplinas() {
        arquivo = "disciplinas.csv";
        List<Diciplina> disciplinas = new ArrayList<>();
        try(BufferedReader br = new BufferedReader(new FileReader(path + arquivo)) ){
            String line = br.readLine();
            while(!line.equals(null)){
                String[] lines = line.split(",");
                disciplinas.add( 
                    new Diciplina(
                        Integer.parseInt(lines[0]), 
                        Integer.parseInt(lines[1]),
                        lines[2],
                        null
                    )

                );
                line = br.readLine();

            }

        }catch (Exception e) {
            // TODO: handle exception
        }
        return disciplinas;
        
    }

    @Override
    public List<Turma> turmas() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'turmas'");
    }

    @Override
    public List<TurmasMatricula> turmasMatriculadas() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'turmasMatriculadas'");
    }

    @Override
    public List<HistoricosEscolares> historcosEscolares() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'historcosEscolares'");
    }

    @Override
    public List<Curriculo> curriculos() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'curriculos'");
    }

    @Override
    public List<Diciplina> diciplinaList() throws SQLException {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'diciplinaList'");
    }

    @Override
    public List<Professores> professoresList() throws SQLException {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'professoresList'");
    }
    
}
