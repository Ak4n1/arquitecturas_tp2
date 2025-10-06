package com.team.matias.juan.helpers;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class MainDerby {
    
    public static void main(String[] args) {
        System.out.println("=== CREANDO TABLAS EN APACHE DERBY ===\n");
        
        crearTablasDerby();
        
        System.out.println("\n=== PROCESO COMPLETADO ===");
    }
    
    private static void crearTablasDerby() {
        System.out.println("🟡 CREANDO TABLAS EN DERBY...");
        
        EntityManagerFactory emf = null;
        EntityManager em = null;
        
        try {
            emf = Persistence.createEntityManagerFactory("tp2_arquitectura_Derby");
            em = emf.createEntityManager();
            
            System.out.println("✅ Conexión exitosa a Derby");
            System.out.println("✅ Base de datos Derby creada");
            System.out.println("\n✅ Tablas creadas/actualizadas en Derby:");
            System.out.println("   - ESTUDIANTES");
            System.out.println("   - CARRERAS");
            System.out.println("   - ESTUDIANTE_CARRERA");
            
        } catch (Exception e) {
            System.err.println("❌ ERROR en Derby:");
            e.printStackTrace();
        } finally {
            if (em != null) em.close();
            if (emf != null) emf.close();
        }
    }
}
