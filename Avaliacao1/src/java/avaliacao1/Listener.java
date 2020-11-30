/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package avaliacao1;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/**
 * Web application lifecycle listener.
 *
 * @author isame
 */
public class Listener implements ServletContextListener {
    public static final String DRIVER_CLASS ="org.sqlite.JDBC";
    public static final String DATABASE_URL ="jdbc:sqlite:disciplinas_p2.db";
    
    public static Exception e = null;
    
    public static Connection getConnection() throws Exception{
        return DriverManager.getConnection(DATABASE_URL);
    }
    
    @Override
    public void contextInitialized(ServletContextEvent sce) {
             Connection con = null;
        Statement stmt = null;
        
        try{
             Class.forName(DRIVER_CLASS);
               con = getConnection();
                stmt = con.createStatement();
            stmt.execute("CREATE TABLE IF NOT EXISTS disciplinas("
                    + "id int autoincrement primary key,"
                    + "nome VARCHAR(200) NOT NULL,"
                    + "ementa VARCHAR(250) NOT NULL,"
                    + "ciclo INT NOT NULL,"
                    + "nota INT"
                    + " )"); 
            
            if(Disciplina.getDisciplinasCount()==0){
               stmt.execute("INSERT INTO disciplinas VALUES("
                       + "'Teste',"
                       + "'Teste Ementa',"
                       + "3,"
                       + "10"
                       +")");
           }
            
            stmt.close();
            con.close();
        }catch(Exception ex){
            e = ex;
            try{stmt.close();}catch(Exception ex2){}
            try{con.close();}catch(Exception ex2){}
        }
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
    }
}
