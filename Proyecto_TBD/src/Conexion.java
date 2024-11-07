import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDate;
import javax.swing.JComboBox;
import javax.swing.JLabel;

/**
 *
 * @author Edmund
 */

public class Conexion {
    
    //Variables
    private static String usuario;
    private static String password;
    
    //public static String bd = "universidad";
    public static String url = "jdbc:mysql://localhost:3306/universidad";
    public static String driver = "com.mysql.cj.jdbc.Driver";
    
    static Connection cx;
    
    //Metodos de conexion y desconexion
    
    public static Connection conectar(){
        
        try {
            Class.forName(driver);
            cx = DriverManager.getConnection(url, usuario, password);
            return cx;
        } catch (SQLException | ClassNotFoundException ex) {
            System.out.println("No se pudo conectar a base de datos");
            return null;
        }
    }

    public void desconectar(){
        try{
            cx.close();
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, "El metodo desconectar no se ejecuto correctamente", "Desconectar", JOptionPane.ERROR_MESSAGE);
        } 
    }
    
    //Metodo para el login
    
    public static void login(String usuario, String password){
        Conexion.usuario = usuario;
        Conexion.password = password;
    }
    
    //Seleccion de Claves Foraneas
        public void claves(JComboBox selector, String claveforanea, String tabla){
        selector.removeAllItems();
        conectar();
        try{
            Statement sT=(Statement)cx.createStatement();
            ResultSet resSet = sT.executeQuery("SELECT " + claveforanea + " FROM " + tabla);
            while(resSet.next())
                selector.addItem(resSet.getString(1));
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null,"No se pueden mostrar las "+claveforanea+" de la tabla " + tabla +ex.getMessage());
        }
        desconectar();
    }
    
    //[DML - SELECT] Metodos para mostrar datos en la tabla principal
    //Maestros
    public void Maestros(JTable tabla){
        DefaultTableModel modelo = (DefaultTableModel)tabla.getModel();
        modelo.setRowCount(0);
        
        conectar();
        try{
            Statement sT = (Statement)cx.createStatement();
            ResultSet resSet = sT.executeQuery("SELECT * FROM misters");
            
            Object[]arreglo = new Object[9];
            
            while(resSet.next()){
                arreglo[0]=resSet.getInt(1);
                arreglo[1]=resSet.getInt(2);
                arreglo[2]=resSet.getString(3);
                arreglo[3]=resSet.getString(4);
                arreglo[4]=resSet.getString(5);
                arreglo[5]=resSet.getString(6);
                arreglo[6]=resSet.getString(7);
                arreglo[7]=resSet.getString(8);
                arreglo[8]=resSet.getInt(9);  
                modelo.addRow(arreglo);
            };
            
            tabla.setModel(modelo);           
        
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "No se pudo recabar los datos de la tabla misters", "Maestros", JOptionPane.ERROR_MESSAGE);
        }  
        desconectar();
    }
    
    //Alumnos
    public void Alumnos(JTable tabla){
        DefaultTableModel modelo = (DefaultTableModel)tabla.getModel();
        modelo.setRowCount(0);
        
        conectar();
        try{
            Statement sT = (Statement)cx.createStatement();
            ResultSet resSet = sT.executeQuery("SELECT * FROM students");
            
            Object[]arreglo = new Object[7];
            
            while(resSet.next()){
                arreglo[0]=resSet.getInt(1);
                arreglo[1]=resSet.getString(2);
                arreglo[2]=resSet.getString(3);
                arreglo[3]=resSet.getInt(4);
                arreglo[4]=resSet.getString(5);
                arreglo[5]=resSet.getString(6);
                arreglo[6]=resSet.getInt(7);
                modelo.addRow(arreglo);
            };
            
            tabla.setModel(modelo);           
        
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "No se pudo recabar los datos de la tabla students", "Alumnos", JOptionPane.ERROR_MESSAGE);
        }  
        desconectar();
    }
    
    //Calificaciones
    public void Calificaciones(JTable tabla){
        DefaultTableModel modelo = (DefaultTableModel)tabla.getModel();
        modelo.setRowCount(0);
        
        conectar();
        try{
            Statement sT = (Statement)cx.createStatement();
            ResultSet resSet = sT.executeQuery("SELECT * FROM notes");
            
            Object[]arreglo = new Object[4];
            
            while(resSet.next()){
                arreglo[0]=resSet.getInt(1);
                arreglo[1]=resSet.getInt(2);
                arreglo[2]=resSet.getInt(3);
                arreglo[3]=resSet.getInt(4);
                modelo.addRow(arreglo);
            };
            
            tabla.setModel(modelo);           
        
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "No se pudo recabar los datos de la tabla notes", "Calificaciones", JOptionPane.ERROR_MESSAGE);
        }  
        desconectar();
    }
    
    //Materias
    public void Materias(JTable tabla){
        DefaultTableModel modelo = (DefaultTableModel)tabla.getModel();
        modelo.setRowCount(0);
        
        conectar();
        try{
            Statement sT = (Statement)cx.createStatement();
            ResultSet resSet = sT.executeQuery("SELECT * FROM subjects");
            
            Object[]arreglo = new Object[4];
            
            while(resSet.next()){
                arreglo[0]=resSet.getInt(1);
                arreglo[1]=resSet.getString(2);
                arreglo[2]=resSet.getInt(3);
                modelo.addRow(arreglo);
            };
            
            tabla.setModel(modelo);           
        
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "No se pudo recabar los datos de la tabla subjects", "Materias", JOptionPane.ERROR_MESSAGE);
        }  
        desconectar();
    }
    
    //Usuarios
    public void Usuarios(JTable tabla){
        DefaultTableModel modelo = (DefaultTableModel)tabla.getModel();
        modelo.setRowCount(0);
        
        conectar();
        try{
            Statement sT = (Statement)cx.createStatement();
            ResultSet resSet = sT.executeQuery("SELECT * FROM users");
            
            Object[]arreglo = new Object[4];
            
            while(resSet.next()){
                arreglo[0]=resSet.getInt(1);
                arreglo[1]=resSet.getString(2);
                arreglo[2]=resSet.getString(3);
                arreglo[3]=resSet.getInt(4);
                modelo.addRow(arreglo);
            };
            
            tabla.setModel(modelo);           
        
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "No se pudo recabar los datos de la tabla users", "Usuarios", JOptionPane.ERROR_MESSAGE);
        }  
        desconectar();
    }
    
    //Roles_Usuarios
    public void Roles_Usuarios(JTable tabla){
        DefaultTableModel modelo = (DefaultTableModel)tabla.getModel();
        modelo.setRowCount(0);
        
        conectar();
        try{
            Statement sT = (Statement)cx.createStatement();
            ResultSet resSet = sT.executeQuery("SELECT * FROM rolesusers");
            
            Object[]arreglo = new Object[6];
            
            while(resSet.next()){
                arreglo[0]=resSet.getInt(1);
                arreglo[1]=resSet.getString(2);
                arreglo[2]=resSet.getString(3);
                arreglo[3]=resSet.getInt(4);
                arreglo[4]=resSet.getInt(5);
                arreglo[5]=resSet.getInt(6);
                modelo.addRow(arreglo);
            };
            
            tabla.setModel(modelo);           
        
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "No se pudo recabar los datos de la tabla rolesusers", "Roles_Usuarios", JOptionPane.ERROR_MESSAGE);
        }  
        desconectar();
    }   
    
    //Roles
    public void Roles(JTable tabla){
        DefaultTableModel modelo = (DefaultTableModel)tabla.getModel();
        modelo.setRowCount(0);
        
        conectar();
        try{
            Statement sT = (Statement)cx.createStatement();
            ResultSet resSet = sT.executeQuery("SELECT * FROM roles");
            
            Object[]arreglo = new Object[4];
            
            while(resSet.next()){
                arreglo[0]=resSet.getInt(1);
                arreglo[1]=resSet.getString(2);
                arreglo[2]=resSet.getInt(3);
                modelo.addRow(arreglo);
            };
            
            tabla.setModel(modelo);           
        
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "No se pudo recabar los datos de la tabla roles", "Roles", JOptionPane.ERROR_MESSAGE);
        }  
        desconectar();
    }
    
    //IdStudents
    public void IdStudents(JComboBox selector){
        
        selector.removeAllItems();

        conectar();

        try{
            Statement sT = (Statement)cx.createStatement();
            ResultSet resSet = sT.executeQuery("SELECT DISTINCT fk_id_student FROM notes;");
            
            while(resSet.next()){
                String studentID = resSet.getString("fk_id_student");
                selector.addItem(studentID);
            };
                 
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "No se pudo recabar los datos de la tabla sessions", "Sesiones", JOptionPane.ERROR_MESSAGE);
        }  
        desconectar();
    }
    
    //Metodo para utilizar el FUNCTION
    //IdStudents
    public void runFunction(JLabel resultado, int ID){
        
        resultado.setText("");

        conectar();

        try{
            Statement sT = (Statement)cx.createStatement();
            ResultSet resSet = sT.executeQuery("SELECT PromedioAlumno(" + ID + ") AS UWU;");
            
            if(resSet.next()){
                String promedio = resSet.getString("UWU");
                resultado.setText(promedio);
            }
                 
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "No se pudo recabar los datos de la tabla sessions", "Sesiones", JOptionPane.ERROR_MESSAGE);
        }  
        desconectar();
    }
    
    
    //Sesiones
    public void Sesiones(JTable tabla){
        DefaultTableModel modelo = (DefaultTableModel)tabla.getModel();
        modelo.setRowCount(0);
        
        conectar();
        try{
            Statement sT = (Statement)cx.createStatement();
            ResultSet resSet = sT.executeQuery("SELECT * FROM sessions");
            
            Object[]arreglo = new Object[5];
            
            while(resSet.next()){
                arreglo[0]=resSet.getInt(1);
                arreglo[1]=resSet.getDate(2);
                arreglo[2]=resSet.getDate(3);
                arreglo[3]=resSet.getString(4);
                arreglo[4]=resSet.getInt(5);
                modelo.addRow(arreglo);
            };
            
            tabla.setModel(modelo);           
        
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "No se pudo recabar los datos de la tabla sessions", "Sesiones", JOptionPane.ERROR_MESSAGE);
        }  
        desconectar();
    }
    
    //Permisos
    public void Permisos(JTable tabla){
        DefaultTableModel modelo = (DefaultTableModel)tabla.getModel();
        modelo.setRowCount(0);
        
        conectar();
        try{
            Statement sT = (Statement)cx.createStatement();
            ResultSet resSet = sT.executeQuery("SELECT * FROM permissions");
            
            Object[]arreglo = new Object[5];
            
            while(resSet.next()){
                arreglo[0]=resSet.getInt(1);
                arreglo[1]=resSet.getString(2);
                arreglo[2]=resSet.getString(3);
                arreglo[3]=resSet.getInt(4);
                arreglo[4]=resSet.getInt(5);
                modelo.addRow(arreglo);
            };
            
            tabla.setModel(modelo);           
        
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "No se pudo recabar los datos de la tabla permissions", "Permisos", JOptionPane.ERROR_MESSAGE);
        }  
        desconectar();
    }
    
    //VISTA Maestrosx
    public void Maestrosx(JTable tabla){
        DefaultTableModel modelo2 = (DefaultTableModel)tabla.getModel();
        modelo2.setRowCount(0);
        
        conectar();
        try{
            Statement sT = (Statement)cx.createStatement();
            ResultSet resSet = sT.executeQuery("SELECT * FROM MaestrosX");
            
            Object[]arreglo = new Object[4];
            
            while(resSet.next()){
                arreglo[0]=resSet.getString(1);
                arreglo[1]=resSet.getString(2);
                arreglo[2]=resSet.getInt(3);
                arreglo[3]=resSet.getString(4);
                modelo2.addRow(arreglo);
            };
            
            tabla.setModel(modelo2);           
        
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "No se pudo recabar los datos de la vista Maestrosx", "Maestrosx", JOptionPane.ERROR_MESSAGE);
        }  
        desconectar();
    }
    
    
    // [DML - DELETE] Metodo para eliminar fila de tabla segun ID
    public void eliminar(String tabla, String Id, int clave){
        conectar();
        try{
         String cad = "DELETE FROM " + tabla + " WHERE " + Id + " ='"+clave+"'";
         PreparedStatement pSt = cx.prepareStatement(cad);
         pSt.executeUpdate();
            
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "No se pudo elimnar los datos", "Eliminar", JOptionPane.ERROR_MESSAGE);        
        }
        desconectar();
    }

    //[DML - INSERT] Metodos para insertar datos en tablas
    //Maestros
    public void insertMaestros(int id_mister, int fk_id_sub, String name_mister, String lastname_mister, String direction_mister, String phone_mister, String birth_mister, String category_mister, int fk_id_session_m){
        conectar();
        try{
        String sentencia = "INSERT INTO misters (id_mister, fk_id_sub, name_mister, lastname_mister, direction_mister, phone_mister, birth_mister, category_mister, fk_id_session_m) VALUES (?,?,?,?,?,?,?,?,?)";
        PreparedStatement pSt = cx.prepareStatement(sentencia);
            
            pSt.setInt(1,id_mister);
            pSt.setInt(2,fk_id_sub);
            pSt.setString(3,name_mister);
            pSt.setString(4,lastname_mister);
            pSt.setString(5,direction_mister);
            pSt.setString(6,phone_mister);
            pSt.setString(7,birth_mister);
            pSt.setString(8,category_mister);
            pSt.setInt(9,fk_id_session_m);
                
        pSt.executeUpdate();
            
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "No se pudo insertar los datos", "Insertar", JOptionPane.ERROR_MESSAGE);   
        }
        desconectar();
    }
    //Estudiantes
        public void insertEstudiantes(int id_student, String name_student, String lastname_student, int birth_student, String direction_student, String phone_student, int fk_id_session_student){
        conectar();
        try{
        String sentencia = "INSERT INTO students (id_student, name_student, lastname_student, birth_student, direction_student, phone_student, fk_id_session_student) VALUES (?,?,?,?,?,?,?)";
        PreparedStatement pSt = cx.prepareStatement(sentencia);
            
            pSt.setInt(1,id_student);
            pSt.setString(2,name_student);
            pSt.setString(3,lastname_student);
            pSt.setInt(4,birth_student);
            pSt.setString(5,direction_student);
            pSt.setString(6,phone_student);
            pSt.setInt(7,fk_id_session_student);
                
        pSt.executeUpdate();
            
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "No se pudo insertar los datos", "Insertar", JOptionPane.ERROR_MESSAGE);   
        }
        desconectar();
    }
    //Calificaciones
        public void insertCalificaciones(int fk_id_student, int fk_id_sub, int score_notes, int fk_id_session_n){
        conectar();
        try{
        String sentencia = "INSERT INTO notes (fk_id_student, fk_id_sub, score_notes, fk_id_session_n) VALUES (?,?,?,?)";
        PreparedStatement pSt = cx.prepareStatement(sentencia);
            
            pSt.setInt(1,fk_id_student);
            pSt.setInt(2,fk_id_sub);
            pSt.setInt(3,score_notes);
            pSt.setInt(4,fk_id_session_n);
                
        pSt.executeUpdate();
            
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "No se pudo insertar los datos", "Insertar", JOptionPane.ERROR_MESSAGE);   
        }
        desconectar();
    }
    //Materias
        public void insertMaterias(int id_sub, String name_sub, int fk_id_session_subject){
        conectar();
        try{
        String sentencia = "INSERT INTO subjects (id_sub, name_sub, fk_id_session_subject) VALUES (?,?,?)";
        PreparedStatement pSt = cx.prepareStatement(sentencia);
            
            pSt.setInt(1,id_sub);
            pSt.setString(2,name_sub);
            pSt.setInt(3,fk_id_session_subject);
                
        pSt.executeUpdate();
            
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "No se pudo insertar los datos", "Insertar", JOptionPane.ERROR_MESSAGE);   
        }
        desconectar();
    }
    //Usuarios
        public void insertUsuarios(int id_user, String login_user, String password_user, int fk_id_session){
        conectar();
        try{
        String sentencia = "INSERT INTO users (id_user, login_user, password_user, fk_id_session) VALUES (?,?,?,?)";
        PreparedStatement pSt = cx.prepareStatement(sentencia);
            
            pSt.setInt(1,id_user);
            pSt.setString(2,login_user);
            pSt.setString(3,password_user);
            pSt.setInt(4,fk_id_session);
                
        pSt.executeUpdate();
            
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "No se pudo insertar los datos", "Insertar", JOptionPane.ERROR_MESSAGE);   
        }
        desconectar();
    }
    //Roles_Usuarios
        public void insertRoles_Usuarios(int id_roleUser, String asignament_roleUser, String vig_rolUser, int fk_id_session_ru, int fk_id_role_ru, int fk_id_user_ru){
        conectar();
        try{
        String sentencia = "INSERT INTO rolesusers (id_roleUser, asignament_roleUser, vig_rolUser, fk_id_session_ru, fk_id_role_ru, fk_id_user_ru) VALUES (?,?,?,?,?,?)";
        PreparedStatement pSt = cx.prepareStatement(sentencia);
            
            pSt.setInt(1,id_roleUser);
            pSt.setString(2, asignament_roleUser);
            pSt.setString(3, vig_rolUser);
            pSt.setInt(4,fk_id_session_ru);
            pSt.setInt(5,fk_id_role_ru);
            pSt.setInt(6,fk_id_user_ru);
                
        pSt.executeUpdate();
            
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "No se pudo insertar los datos", "Insertar", JOptionPane.ERROR_MESSAGE);   
        }
        desconectar();
    }
    //Roles
        public void insertRoles(int id_role, String name_role, int fk_id_session_r){
        conectar();
        try{
        String sentencia = "INSERT INTO roles (id_role, name_role, fk_id_session_r) VALUES (?,?,?)";
        PreparedStatement pSt = cx.prepareStatement(sentencia);
            
            pSt.setInt(1,id_role);
            pSt.setString(2, name_role);
            pSt.setInt(3, fk_id_session_r);
                
        pSt.executeUpdate();
            
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "No se pudo insertar los datos", "Insertar", JOptionPane.ERROR_MESSAGE);   
        }
        desconectar();
    }         
    //Sesiones
        public void insertSesiones(int id_session, String start_session, String endAct_session, String ip_session, int fk_id_user){
        conectar();
        try{
        String sentencia = "INSERT INTO sessions (id_session, start_session, endAct_session, ip_session, fk_id_user) VALUES (?,?,?,?,?)";
        PreparedStatement pSt = cx.prepareStatement(sentencia);
            
            pSt.setInt(1,id_session);
            pSt.setString(2, start_session);
            pSt.setString(3, endAct_session);
            pSt.setString(4, ip_session);
            pSt.setInt(5, fk_id_user);
                
        pSt.executeUpdate();
            
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "No se pudo insertar los datos", "Insertar", JOptionPane.ERROR_MESSAGE);   
        }
        desconectar();
    }
    //Permisos
        public void insertPermisos(int id_permission, String name_permission, String acces_permission, int fk_id_role_p, int fk_id_session_p){
        conectar();
        try{
        String sentencia = "INSERT INTO permissions (id_permission, name_permission, acces_permission, fk_id_role_p, fk_id_session_p) VALUES (?,?,?,?,?)";
        PreparedStatement pSt = cx.prepareStatement(sentencia);
            
            pSt.setInt(1,id_permission);
            pSt.setString(2, name_permission);
            pSt.setString(3, acces_permission);
            pSt.setInt(4, fk_id_role_p);
            pSt.setInt(5, fk_id_session_p);
                
        pSt.executeUpdate();
            
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "No se pudo insertar los datos \n"
                    + "Verifique que el Acceso sea llenado con  \n"
                    + "alguno de los valores permitidos : 'read' o 'write'", "Insertar", JOptionPane.ERROR_MESSAGE);   
        }
        desconectar();
    }    
}
