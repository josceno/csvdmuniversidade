import modelo_dimensional.AlunoDm;
import modelo_dimensional.ProfessorDm;
import modelo_relacional.Aluno;
import modelo_relacional.Professores;
import repositorio.CsvConnection;
import repositorio.PostgresConnection;
import repositorio.Repositorio;

import java.sql.SQLException;

import javax.sound.sampled.SourceDataLine;

public class Main {
    public static Repositorio repositorio = new CsvConnection();
    //Connection connection = repositorio.connectar("ETL-UNIVERSIDADE","postgres","changeme");
    public static void main(String[] args) throws Exception {;

        //PostgresConnection prin = new PostgresConnection();

        /*Professores prof = repositorio.professoresList().get(1);
        Aluno alu = repositorio.alunos().get(1);
        for(int i = 0; i<repositorio.professores().size(); i++){
            if (repositorio.professoresList().get(i).getCodigoProfessor() == 103){
                prof = repositorio.professoresList().get(i);
            }
        }


        ProfessorDm professorDm = new ProfessorDm(prof.getCodigoProfessor(),prof.getNomeProfessor(),prof.getEmail(),repositorio);
        AlunoDm alunoDm = new AlunoDm(alu.getMatricula(),alu.getDatanascimento(),alu.getNomeAluno(),alu.getEmail(),repositorio);
        System.out.println(alunoDm);
        System.out.println(professorDm);*/
        //repositorio.professores().forEach(System.out::println);
        //repositorio.cursos().forEach(System.out::println);
        //repositorio.cursos().forEach(System.out::println);
        //prin.professoresList().forEach(System.out::println);
        //prin.diciplinaList().forEach(System.out::println);
        //repositorio.alunos().forEach(System.out::println);
        //repositorio.turmas().forEach(System.out::println);
        //repositorio.turmasMatriculadas().forEach(System.out::println);
        mai();


    }
    
        public static void mai() {
            String I;
            int l = 0;
            for (int i = 1000; i <2500; i++) {
                 I = ""+i; 
                 
                 String[] digitos = I.split("");
                 int d = 0;
                 for (int j = 0; j < digitos.length; j++) {
                    d += Integer.parseInt( digitos[j]);
                 }
                 if(d == 19 && i%2 == 0){
                    System.out.println(i+":"+d);
                    l+=1;
    
                 }
            }
            System.out.println(l);
        }
    
    
}