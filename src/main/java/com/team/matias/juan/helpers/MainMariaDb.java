package com.team.matias.juan.helpers;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class MainMariaDb {
    
    public static void main(String[] args) {
        System.out.println("=== CREANDO TABLAS EN MARIADB Y DERBY ===\n");
        
        crearTablasMariaDB();
        
        System.out.println("\n" + "=".repeat(50) + "\n");
        
        crearTablasDerby();
        
        System.out.println("\n=== PROCESO COMPLETADO ===");
    }
    
    private static void crearTablasMariaDB() {
        System.out.println("🔵 CREANDO TABLAS EN MARIADB...");
        
        EntityManagerFactory emf = null;
        EntityManager em = null;
        
        try {
            emf = Persistence.createEntityManagerFactory("tp2_arquitectura_MariaDB");
            em = emf.createEntityManager();
            
            System.out.println("✅ Conexión exitosa a MariaDB");
            System.out.println("✅ Tablas creadas/actualizadas en MariaDB");
            System.out.println("   - estudiantes");
            System.out.println("   - carreras");
            System.out.println("   - estudiante_carrera");
            
        } catch (Exception e) {
            System.err.println("❌ ERROR en MariaDB:");
            e.printStackTrace();
        } finally {
            if (em != null) em.close();
            if (emf != null) emf.close();
        }
    }
    
    private static void crearTablasDerby() {
        System.out.println("🟡 CREANDO TABLAS EN DERBY...");
        
        EntityManagerFactory emf = null;
        EntityManager em = null;
        
        try {
            emf = Persistence.createEntityManagerFactory("tp2_arquitectura_Derby");
            em = emf.createEntityManager();
            
            System.out.println("✅ Conexión exitosa a Derby");
            System.out.println("✅ Tablas creadas/actualizadas en Derby");
            System.out.println("   - estudiantes");
            System.out.println("   - carreras");
            System.out.println("   - estudiante_carrera");
            
        } catch (Exception e) {
            System.err.println("❌ ERROR en Derby:");
            e.printStackTrace();
        } finally {
            if (em != null) em.close();
            if (emf != null) emf.close();
        }
    }
}
