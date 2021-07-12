/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package qubic;
import java.sql.Statement;
import java.sql.Connection ;
import java.sql.DatabaseMetaData ;
import java.sql.DriverManager ;
import java.sql.SQLException ;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;




public class Baza {
    //dodavanje u bazu
    public static void insert ( String ime_X , String ime_O , String vrsta, int broj_poteza , int pobjeda, Connection conn ) {
        String sql = " INSERT INTO igre (ime_X , ime_O , vrsta, broj_poteza, pobjeda) VALUES (? ,? ,?, ?, ?)";

        try {
            PreparedStatement pstmt = conn.prepareStatement ( sql ) ;
            pstmt.setString (1 , ime_X );
            pstmt.setString (2 , ime_O);
            pstmt.setString (3 , vrsta);
            pstmt.setInt (4 , broj_poteza );
            pstmt.setInt (5 , pobjeda);
            pstmt.executeUpdate () ;
        }
        catch ( SQLException e ) { } }
    
    //ispisivanje cijele tablice
    public static void selectAll ( Connection conn ) {
        String sql = " SELECT id, ime_X, ime_O, vrsta, broj_poteza, pobjeda FROM igre ";

        try {
            Statement stmt = conn.createStatement () ;
            ResultSet rs = stmt.executeQuery ( sql );
            while ( rs.next () ) {
                System.out.println ( rs.getInt("id") + "\t"
                        + rs.getString("ime_X") + "\t" 
                        + rs.getString("ime_O") +"\t"
                        + rs.getString("vrsta") +"\t"
                        + rs.getInt("broj_poteza")+"\t" 
                        + rs.getInt("pobjeda"));
            }
        } catch ( SQLException e ) {
            System.out.println ( e.getMessage () ) ;
        }
    }
    
    //--------------------
    //dobivanje statistike igraca
    //--------------------
    
    //dobivanje broja partija s odredenim tipom igre -- bez prepare statementsa
    /*
    public static void brojPartija (String ime, String vrsta,  Connection conn ) {
        String sql = " SELECT ime_X, ime_O, vrsta, pobjeda FROM igre ";
        int[] brojac = new int[4]; //nulti ukupno, prvi pobjede, drugi porazi, trece remiji
        for(int i=0; i<4; i++) brojac[i] = 0;
        try {
            Statement stmt = conn.createStatement () ;
            ResultSet rs = stmt.executeQuery ( sql );
            while ( rs.next () ) {
                if( (rs.getString("ime_X").equals(ime) || rs.getString("ime_O").equals(ime) ) && rs.getString("vrsta").equals(vrsta)){
                    if (rs.getInt("pobjeda") == 1) brojac[1]++;
                    if (rs.getInt("pobjeda") == -1) brojac[2]++;
                    if (rs.getInt("pobjeda") == 0) brojac[3]++;
                    brojac[0]++;
                }
            }
            System.out.println( String.valueOf(brojac[1]) + " pobjeda : " + String.valueOf(brojac[2])
                                + " poraza : " + String.valueOf(brojac[3]) + " remija, od ukupno "
                                + String.valueOf(brojac[0]) + " partija.");
        } catch ( SQLException e ) {
            System.out.println ( e.getMessage () ) ;
        }
    }
    */
    public static String brojPartija (String ime, String vrsta,  Connection conn ) {
        String sql = " SELECT count(*) AS brojac, pobjeda FROM igre WHERE (ime_X == ? OR ime_O ==?) AND vrsta ==? GROUP BY pobjeda";

        try {
            PreparedStatement pstmt = conn.prepareStatement ( sql ) ;
            pstmt.setString (1, ime );
            pstmt.setString (2, ime);
            pstmt.setString (3 , vrsta);
            ResultSet rs = pstmt.executeQuery();
            int ukupno = 0;
            int[] rezultati = new int[] {0,0,0};
            
            while ( rs.next () ) {
                rezultati[rs.getInt("pobjeda")+1] = rs.getInt("brojac");
            }
            ukupno = rezultati[0] + rezultati[1] + rezultati[2];
            System.out.println("Poraza: "+String.valueOf(rezultati[0])+", remija: "+String.valueOf(rezultati[1])+", pobjeda: "+String.valueOf(rezultati[2]));
            System.out.println("Od ukupno:" + String.valueOf(ukupno));
            rs.close();
            return String.valueOf(rezultati[0])+","+String.valueOf(rezultati[1])+","+String.valueOf(rezultati[2])+","+String.valueOf(ukupno);
        } catch ( SQLException e ) {
            System.out.println ( e.getMessage () ) ;
        }
        return "";
    }
    
    
    //prosjecan broj poteza u partijama odredenog igraca -- bez prepare statementsa
    /*
    public static int prosjecnoPoteza (String ime, String vrsta,  Connection conn ) {
        String sql = " SELECT ime_X, ime_O, vrsta, broj_poteza FROM igre ";
        int[] brojac = new int[2]; //nulti ukupno_poteza, prvi broj_partija
        for(int i=0; i<2; i++) brojac[i] = 0;
        try {
            Statement stmt = conn.createStatement () ;
            ResultSet rs = stmt.executeQuery ( sql );
            while ( rs.next () ) {
                System.out.println("mm");
                if( (rs.getString("ime_X").equals(ime) || rs.getString("ime_O").equals(ime) ) && rs.getString("vrsta").equals(vrsta)){
                    brojac[0] += rs.getInt("broj_poteza");
                    brojac[1]++;
                }
            }
            if(brojac[1] == 0) return 0;
            System.out.println("Prosječno poteza po partiji vrste " + vrsta +": " + brojac[0]/brojac[1]);
            return brojac[0]/brojac[1];
        } catch ( SQLException e ) {
            System.out.println ( e.getMessage () ) ;
        }
        return 0;
    }
    */
    public static double prosjecnoPoteza (String ime, String vrsta,  Connection conn ) {
        String sql = " SELECT AVG(broj_poteza) AS prosjek FROM igre WHERE (ime_X == ? OR ime_O ==?)AND vrsta ==?";
        try {
            PreparedStatement pstmt = conn.prepareStatement ( sql ) ;
            pstmt.setString (1, ime );
            pstmt.setString (2, ime);
            pstmt.setString (3 , vrsta);
            ResultSet rs = pstmt.executeQuery();
            Double rez = 0.0;
            while ( rs.next () ) {
                rez = rs.getDouble("prosjek");
            }
            if(rez == 0){
                rs.close();
                return 0;
            }
            rs.close();
            return rez;
        } catch ( SQLException e ) {
            System.out.println ( e.getMessage () ) ;
        }
        return 0;
    }
    
    //------------------
    //LJESTVICA NAJBOLJIH po vrsti
    //-------------------
    
    public static String ljestvica( String znak, String vrsta,  Connection conn ) {
        String sql;
        if(znak == "X"){
            sql = "SELECT ime_X AS ime, SUM(CASE WHEN pobjeda == 0 THEN 0.5 ELSE 1 END) AS broj"
                        + " FROM igre WHERE vrsta ==  ? AND (pobjeda == 1 OR pobjeda == 0) GROUP BY ime_X ORDER BY broj";
        }
        else{
            sql = "SELECT ime_O AS ime, SUM(CASE WHEN pobjeda == 0 THEN 0.5 ELSE 1 END) AS broj"
                        + " FROM igre WHERE vrsta ==  ? AND (pobjeda == -1 OR pobjeda == 0) GROUP BY ime_O ORDER BY broj";
        }
        
        try {
            PreparedStatement pstmt = conn.prepareStatement ( sql );
            pstmt.setString (1 , vrsta);
            ResultSet rs = pstmt.executeQuery();
            String rez = "";
            int brojac = 1;
            while ( rs.next () ) {
                rez = rez + String.valueOf(brojac) + ". " + rs.getString("ime") + " : " + String.valueOf(rs.getDouble("broj") + "\n");
                brojac++;
            }
            rs.close();
            return rez;
            
        } catch ( SQLException e ) {
            System.out.println ( e.getMessage () ) ;
        }
        return "";
    }
    
    public static void call (String ime_X , String ime_O , String vrsta, int broj_poteza , int pobjeda) {
        String imeBaze = "baza.db";
        //treba promjeniti
        String path = "C:\\Users\\Nela\\Desktop\\JAVA-PROJEKT\\src\\qubic\\";
        String url = "jdbc:sqlite:" + path + imeBaze ;

        try ( Connection conn = DriverManager.getConnection ( url ) ) {
            if ( conn != null ) {
                DatabaseMetaData meta = conn.getMetaData () ;
                //System.out.println ("Ime biblioteke za rad s bazom podataka " + meta.getDriverName () ) ;
                System.out.println (" Stvorena je nova baza .") ;
            }
        } catch ( SQLException e ) {
            System.out.println ( e.getMessage () ) ;
        }
        String sql = " CREATE TABLE IF NOT EXISTS igre (\n" 
                        + " id integer PRIMARY KEY ,\n"
                        + " ime_X text NOT NULL ,\n"
                        + " ime_O text NOT NULL ,\n"
                        + " vrsta text NOT NULL ,\n"
                        + " broj_poteza integer, \n"
                        + " pobjeda integer NOT NULL \n"    //1 za x, -1 za O i 0 za remi
                        + ");";
        try ( Connection conn1 = DriverManager.getConnection ( url ) ;
            Statement stmt = conn1.createStatement() ) {
            if ( conn1 != null ) { stmt.execute ( sql ) ;}
               
        } catch ( SQLException e ) {
            System.out.println ( e.getMessage () ) ; }

    }
    //pomocna funckija za insert
    public static void ubaci (String ime_X , String ime_O , String vrsta, int broj_poteza , int pobjeda) {
        String imeBaze = "baza.db";
        //treba promjeniti
        String path = "C:\\Users\\Nela\\Desktop\\JAVA-PROJEKT\\src\\qubic\\";
        String url = "jdbc:sqlite:" + path + imeBaze ;

        try ( Connection conn1 = DriverManager.getConnection ( url ) ;
            Statement stmt = conn1.createStatement() ) {
            Baza.insert(ime_X, ime_O, vrsta, broj_poteza, pobjeda, conn1 );
               
        } catch ( SQLException e ) {
            System.out.println ( e.getMessage () ) ; }

    }
    //pomocna funckija za statistiku
    public static String stat (String ime, String vrsta) {
        String imeBaze = "baza.db";
        //treba promjeniti
        String path = "C:\\Users\\Nela\\Desktop\\JAVA-PROJEKT\\src\\qubic\\";
        String url = "jdbc:sqlite:" + path + imeBaze ;
        
        String rez = "";
        try ( Connection conn1 = DriverManager.getConnection ( url ) ;
            Statement stmt = conn1.createStatement() ) {
            if ( conn1 != null ) {
                rez = Baza.brojPartija(ime,vrsta, conn1);
            }
        } catch ( SQLException e ) {
            System.out.println ( e.getMessage () ) ; }
        return rez;
    }
    
    //pomocna za poteze
    public static Double potezi (String ime, String vrsta) {
        String imeBaze = "baza.db";
        //treba promjeniti
        String path = "C:\\Users\\Nela\\Desktop\\JAVA-PROJEKT\\src\\qubic\\";
        String url = "jdbc:sqlite:" + path + imeBaze ;
        
        Double rez = 0.0;
        try ( Connection conn1 = DriverManager.getConnection ( url ) ;
            Statement stmt = conn1.createStatement() ) {
            if ( conn1 != null ) {
                rez = Baza.prosjecnoPoteza(ime,vrsta, conn1);
            }
        } catch ( SQLException e ) {
            System.out.println ( e.getMessage () ) ; }
        return rez;
    }
    //pomocna za ljestvice
    public static String getLjestvica (String znak, String vrsta) {
        String imeBaze = "baza.db";
        //treba promjeniti
        String path = "C:\\Users\\Nela\\Desktop\\JAVA-PROJEKT\\src\\qubic\\";
        String url = "jdbc:sqlite:" + path + imeBaze ;
        
        String rez = "";
        try ( Connection conn1 = DriverManager.getConnection ( url ) ;
            Statement stmt = conn1.createStatement() ) {
            if ( conn1 != null ) {
                rez = Baza.ljestvica(znak,vrsta, conn1);
            }
        } catch ( SQLException e ) {
            System.out.println ( e.getMessage () ) ; }
        return rez;
    }
}
