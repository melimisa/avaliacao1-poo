package avaliacao1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author isame
 */
public class Disciplina {
    private String nome;
    private String ementa;
    private Double nota;
    private int ciclo;
    
    public static final String DRIVER_CLASS ="org.sqlite.JDBC";
    public static final String DATABASE_URL ="jdbc:sqlite:disciplinas_p2.db";
    
    public static Exception e = null;
    
    public static Connection getConnection() throws Exception{
        return DriverManager.getConnection(DATABASE_URL);
    }


    public Disciplina(String nome, String ementa, int ciclo, double nota) {
        this.nome = nome;
        this.ementa = ementa;
        this.ciclo = ciclo;
        this.nota = nota;
    }

    public int getId() {
        Connection con = null;
        Statement stmt = null;
        ResultSet rs = null;
        int id= 0;
        try{
             Class.forName(DRIVER_CLASS);
               con = getConnection();
                stmt = con.createStatement();
                rs = stmt.executeQuery("SELECT id FROM disciplinas");
                if(rs.next()){
                    id = rs.getInt("id");
                }
            
            rs.close();
            stmt.close();
            con.close();
            
        }catch(Exception ex){
            e = ex;
            try{rs.close();}catch(Exception ex2){}
            try{stmt.close();}catch(Exception ex2){}
            try{con.close();}catch(Exception ex2){}          
        }
        return id;
         
    }
    
    public int getCiclo() {
        Connection con = null;
        Statement stmt = null;
        ResultSet rs = null;
        int ciclo= 0;
        try{
             Class.forName(DRIVER_CLASS);
               con = getConnection();
                stmt = con.createStatement();
                rs = stmt.executeQuery("SELECT ciclo FROM disciplinas");
                if(rs.next()){
                    ciclo = rs.getInt("ciclo");
                }
            
            rs.close();
            stmt.close();
            con.close();
            
        }catch(Exception ex){
            e = ex;
            try{rs.close();}catch(Exception ex2){}
            try{stmt.close();}catch(Exception ex2){}
            try{con.close();}catch(Exception ex2){}          
        }
        return ciclo;
         
    }

    public void setCiclo(int ciclo) {
        this.ciclo = ciclo;
    }

    public String getNome() {
        Connection con = null;
        Statement stmt = null;
        ResultSet rs = null;
        String nome = null;
        try{
             Class.forName(DRIVER_CLASS);
               con = getConnection();
                stmt = con.createStatement();
                rs = stmt.executeQuery("SELECT nome FROM disciplinas");
                if(rs.next()){
                    nome = rs.getString("nome");
                }
            
            rs.close();
            stmt.close();
            con.close();
            
        }catch(Exception ex){
            e = ex;
            try{rs.close();}catch(Exception ex2){}
            try{stmt.close();}catch(Exception ex2){}
            try{con.close();}catch(Exception ex2){}          
        }
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmenta() {
        Connection con = null;
        Statement stmt = null;
        ResultSet rs = null;
        String ementa = null;
        try{
             Class.forName(DRIVER_CLASS);
               con = getConnection();
                stmt = con.createStatement();
                rs = stmt.executeQuery("SELECT ementa FROM disciplinas");
                if(rs.next()){
                    ementa = rs.getString("ementa");
                }
            
            rs.close();
            stmt.close();
            con.close();
            
        }catch(Exception ex){
            e = ex;
            try{rs.close();}catch(Exception ex2){}
            try{stmt.close();}catch(Exception ex2){}
            try{con.close();}catch(Exception ex2){}          
        }
        return ementa;
    }

    public void setEmenta(String ementa) {
        this.ementa = ementa;
    }

    public Double getNota() {
        Connection con = null;
        Statement stmt = null;
        ResultSet rs = null;
        double nota = 0;
        try{
             Class.forName(DRIVER_CLASS);
               con = getConnection();
                stmt = con.createStatement();
                rs = stmt.executeQuery("SELECT nota FROM disciplinas");
                if(rs.next()){
                    nota = rs.getDouble("nota");
                }
            
            rs.close();
            stmt.close();
            con.close();
            
        }catch(Exception ex){
            e = ex;
            try{rs.close();}catch(Exception ex2){}
            try{stmt.close();}catch(Exception ex2){}
            try{con.close();}catch(Exception ex2){}          
        }

        return nota;
    }

    public void setNota(Double nota) {
        this.nota = nota;
    }
    
    public static int getDisciplinasCount(){
        Connection con = null;
        Statement stmt = null;
        ResultSet rs = null;
        int count = 0;
        try{
             Class.forName(DRIVER_CLASS);
               con = getConnection();
                stmt = con.createStatement();
                rs = stmt.executeQuery("SELECT COUNT(*) as count FROM disciplinas");
                if(rs.next()){
                    count = rs.getInt("count");
                }
            
            rs.close();
            stmt.close();
            con.close();
            
        }catch(Exception ex){
            e = ex;
            try{rs.close();}catch(Exception ex2){}
            try{stmt.close();}catch(Exception ex2){}
            try{con.close();}catch(Exception ex2){}          
        }
        return count;
    }
    
        public static ArrayList<Disciplina> getList() throws Exception{
        ArrayList<Disciplina> list = new ArrayList<>();
        
        Connection con = null;
        Statement stmt = null;
        ResultSet rs = null;
        
        Exception methodException = null;
        
        try{
            con = Listener.getConnection();
            stmt = con.createStatement();
            rs = stmt.executeQuery("SELECT * FROM disciplinas");
            
            while(rs.next()){
                list.add(new Disciplina(
                        rs.getString("nome"),
                        rs.getString("ementa"),
                        rs.getInt("ciclo"),
                        rs.getInt("nota")
                ));
            }
            
        }catch(Exception ex){
            methodException = ex;
        }finally{
            try{rs.close();}catch(Exception ex){}
            try{stmt.close();}catch(Exception ex){}
            try{con.close();}catch(Exception ex){}
        }
        
        if(methodException != null) throw methodException;
        
        return list;
    }
        
    public static void  insert(String nome, String ementa, int ciclo, double nota) throws Exception{
        Connection con = null;
        Statement stmt = null;
        ResultSet rs = null;
        int count = 0;
        try{
             Class.forName(DRIVER_CLASS);
               con = getConnection();
                stmt = con.createStatement();
        stmt.execute("insert into disciplinas values('"+nome+", '"+ementa+"' , '"+ciclo+"', '"+nota+"')");
        
        stmt.close();
        con.close();
        }catch(Exception ex){
            e = ex;
            try{rs.close();}catch(Exception ex2){}
            try{stmt.close();}catch(Exception ex2){}
            try{con.close();}catch(Exception ex2){}          
        }
    }

    public static void  delete(int id) throws Exception{
        Connection con = null;
        Statement stmt = null;
        ResultSet rs = null;
        try{
             Class.forName(DRIVER_CLASS);
               con = getConnection();
                stmt = con.createStatement();
        stmt.execute("DELETE FROM disciplinas WHERE nome='"+id+"'");
        
        stmt.close();
        con.close();
        }catch(Exception ex){
            e = ex;
            try{rs.close();}catch(Exception ex2){}
            try{stmt.close();}catch(Exception ex2){}
            try{con.close();}catch(Exception ex2){}          
        }
    }
    
        
    
}
