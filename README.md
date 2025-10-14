# TP2 - Arquitectura Web

## 📋 INSTRUCCIONES DE EJECUCIÓN

### ⚠️ IMPORTANTE: Sigue estos pasos EN ORDEN

## 🔧 PASO 1: Configurar Base de Datos

**ANTES de ejecutar el programa principal, DEBES crear las tablas en la base de datos.**

### Opción A: Apache Derby (Recomendado - No requiere instalación)
```bash
java com.team.matias.juan.helpers.MainDerby
```
✅ **Qué hace**: Crea automáticamente la base de datos Derby y todas las tablas

### Opción B: MariaDB (Requiere servidor MariaDB ejecutándose)
```bash
java com.team.matias.juan.helpers.MainMariaDb
```
✅ **Qué hace**: Crea las tablas en MariaDB (debe estar ejecutándose)

## 🚀 PASO 2: Ejecutar el Programa Principal

**SOLO después de completar el Paso 1:**
```bash
java com.team.matias.juan.Main
```
✅ **Qué hace**: Ejecuta todos los enunciados del TP2

## ⚙️ CONFIGURACIÓN DE CONEXIÓN

Si necesitas cambiar la configuración de conexión, edita:
```
src/main/resources/META-INF/persistence.xml
```

### Configuración MariaDB:
- **Puerto**: 3306
- **Usuario**: admin  
- **Contraseña**: admin
- **Base de datos**: tp2_arquitectura

### Configuración Derby:
- **Base de datos**: derbyDB (archivo local)
- **Ubicación**: C:/Users/JeeP_/OneDrive/Escritorio/TP_2_ARQUITECTURA/tp2_arquitectura/derbyDB

## 📊 DIAGRAMAS DEL SISTEMA

**Para entender la arquitectura del proyecto, revisa:**
```
src/main/resources/Diagramas/
```

- **DClases_TP2.jpg**: Diagrama de clases del sistema
- **DER_TP2.jpg**: Diagrama Entidad-Relación de la base de datos

## 🔍 RESUMEN RÁPIDO

1. **Ejecuta**: `MainDerby` o `MainMariaDb` (crear tablas)
2. **Ejecuta**: `Main` (ejecutar enunciados)  
3. **Revisa**: Diagramas en `resources/Diagramas/`
4. **Configura**: `persistence.xml` si necesitas cambiar conexión

## Estructura del Proyecto

```
src/main/java/com/team/matias/juan/
├── entities/          # Entidades JPA
├── daos/             # Data Access Objects
├── services/         # Lógica de negocio
├── dto/              # Data Transfer Objects
├── helpers/          # Utilidades (MainDerby, MainMariaDb)
├── Enunciados.java   # Implementación de los enunciados
└── Main.java         # Punto de entrada principal
```

## Tecnologías Utilizadas

- **Java 17**
- **JPA/Hibernate 5.6.15**
- **MariaDB Driver 3.4.1**
- **Apache Derby 10.17.1**
- **Maven**

## Requisitos

- Java 17 o superior
- Maven 3.6+
- MariaDB (opcional) o Apache Derby (incluido)

## Notas Importantes

- Asegúrate de que MariaDB esté ejecutándose en el puerto 3306 si usas esa opción
- Derby crea automáticamente la base de datos si no existe
- Los diagramas en `resources/Diagramas/` muestran la arquitectura completa del sistema
