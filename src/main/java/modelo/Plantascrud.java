/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

/**
 *
 * @author Pablo
 */
public class Plantascrud {
    public static List <Plantas> getPlantas() {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("com.mycompany_CRUDplantas_war_1.0-SNAPSHOTPU");
        EntityManager manager = factory.createEntityManager();
        String sql = "SELECT * FROM plantas";
        Query q = manager.createNativeQuery(sql,Plantas.class); //método para consultas en SQL
        List<Plantas> productosBD =  q.getResultList();

        return productosBD;        
        }    
     
        public static int actualizaPlantaTest() {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("com.mycompany_CRUDplantas_war_1.0-SNAPSHOTPU");
        EntityManager manager = factory.createEntityManager();
        String sql = "UPDATE Productos p SET p.categoria = 'zumos' WHERE p.id = 10";
        Query q = manager.createQuery(sql,Plantas.class);
        manager.getTransaction().begin();
        int filasAfectadas = q.executeUpdate();
        manager.getTransaction().commit();
        //manager.close();
        return filasAfectadas;      
    }
       
       
       public static int actualizaPlanta(Plantas miPlanta) {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("com.mycompany_CRUDplantas_war_1.0-SNAPSHOTPU");
        EntityManager manager = factory.createEntityManager();
        String sql = "UPDATE Plantas p SET p.nombre = :nombre, p.precio = :precio WHERE p.id = :id";
        Query q = manager.createQuery(sql,Plantas.class);
        q.setParameter("id", miPlanta.getId());
        q.setParameter("nombre", miPlanta.getNombre());
        q.setParameter("precio", miPlanta.getPrecio());
        manager.getTransaction().begin();
        int filasAfectadas = q.executeUpdate();
        manager.getTransaction().commit();
        manager.close();
        return filasAfectadas;      
    }
       
        public static void insertaPlanta(Plantas planta) {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("com.mycompany_CRUDplantas_war_1.0-SNAPSHOTPU");
        EntityManager manager = factory.createEntityManager();
         manager.getTransaction().begin();
        manager.merge(planta);
        manager.getTransaction().commit();
        }
        
        public static int destroyPlanta(int id) {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("com.mycompany_CRUDplantas_war_1.0-SNAPSHOTPU");
        EntityManager manager = factory.createEntityManager();
        String sql = "DELETE from Plantas p WHERE p.id = " + id;
        Query q = manager.createQuery(sql);
        manager.getTransaction().begin();
        int filasAfectadas = q.executeUpdate(); //para las consultas de modif. datos se usa el método executeUpdate
        manager.getTransaction().commit();
        return filasAfectadas;  
    }
        
      public static Plantas getPlanta(int id) {  //devuelve un objeto de clase Productos
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("com.mycompany_CRUDplantas_war_1.0-SNAPSHOTPU");
        EntityManager manager = factory.createEntityManager();
        String sql = "SELECT p FROM Plantas p WHERE p.id=" + id;
        Query q = manager.createQuery(sql,Plantas.class); //método para consultas en SQL
        Plantas miPlanta =  ( Plantas ) q.getSingleResult(); //para un único registro
        manager.close();
        return  miPlanta;
        } 
}
