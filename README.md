# Proyecto de Gestión de Reservas para Coworking

## Descripción

Proyecto de aplicación web backend desarrollado en **Java Servlets** que permite gestionar las reservas de espacios en un coworking. Los usuarios pueden crear, visualizar y eliminar reservas de diferentes espacios de trabajo.

## Requisitos Previos

Antes de desplegar el proyecto, asegúrate de tener instalados los siguientes componentes:

- **Java Development Kit (JDK)**: Versión 21 o superior
- **Apache Tomcat**: Versión 11 o superior
- **Maven**: Versión 3.6 o superior (opcional, para compilar desde el código fuente)

### Versiones Utilizadas en el Desarrollo

- **Java**: 25 LTS (build 25.0.2+10-LTS-69)
- **Apache Tomcat**: 11.0.18
- **Maven**: 3.6.3

## Estructura del Proyecto

```
ProyectoReservaCoworking/
├── pom.xml                                          # Archivo de configuración de Maven
├── README.md                                        # Este archivo
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   └── com/mycompany/proyectoreservacoworking/
│   │   │       ├── Reserva.java                     # Clase modelo de Reserva
│   │   │       └── servlets/
│   │   │           ├── ReservaServlet.java          # Servlet para crear reservas
│   │   │           ├── ListaReservasServlet.java    # Servlet para listar reservas
│   │   │           └── EliminarReservaServlet.java  # Servlet para eliminar reservas
│   │   └── webapp/
│   │       ├── index.html                           # Página de inicio con formulario
│   │       └── WEB-INF/
│   │           └── web.xml                          # Archivo de configuración web (opcional)
└── target/
    └── ProyectoReservaCoworking-1.0-SNAPSHOT.war    # Archivo WAR compilado
```

## Pasos para el Despliegue

### 1. Compilar el Proyecto

Si tienes el código fuente, compila el proyecto con Maven:

```bash
cd ProyectoReservaCoworking
mvn clean package
```

Esto generará un archivo `ProyectoReservaCoworking-1.0-SNAPSHOT.war` en la carpeta `target/`.

### 2. Copiar el Archivo WAR a Tomcat

Copia el archivo WAR generado a la carpeta de despliegue de Tomcat:

```bash
cp target/ProyectoReservaCoworking-1.0-SNAPSHOT.war /opt/homebrew/Cellar/tomcat/11.0.18/libexec/webapps/ProyectoReservaCoworking.war
```

### 3. Iniciar Apache Tomcat

Si Tomcat no está en ejecución, inicia el servidor:

```bash
/opt/homebrew/Cellar/tomcat/11.0.18/libexec/bin/startup.sh
```

### 4. Acceder a la Aplicación

Una vez que Tomcat esté en ejecución, abre tu navegador web y accede a:

```
http://localhost:8080/ProyectoReservaCoworking/index.html
```

## Funcionalidades del Sistema

### 1. Página de Inicio (index.html)

La página de inicio presenta un formulario donde los usuarios pueden:

- **Nombre de usuario**: Ingresar su nombre (campo obligatorio)
- **Fecha de reserva**: Seleccionar la fecha mediante un calendario (campo obligatorio)
- **Espacio de trabajo**: Elegir entre:
  - Escritorio
  - Sala de reuniones
  - Oficina privada
- **Duración de la reserva**: Especificar la duración en horas (campo obligatorio)

### 2. Procesamiento de Reservas (ReservaServlet)

El servlet `ReservaServlet` realiza las siguientes operaciones:

- **Validación**: Verifica que todos los campos obligatorios estén completos
- **Almacenamiento**: Guarda la reserva en una lista en memoria
- **Confirmación**: Redirige al usuario a la página de lista de reservas

### 3. Lista de Reservas (ListaReservasServlet)

El servlet `ListaReservasServlet` muestra:

- Una tabla con todas las reservas almacenadas
- Información de cada reserva: ID, nombre del usuario, fecha, espacio y duración
- Un botón "Eliminar" para cada reserva

### 4. Eliminación de Reservas (EliminarReservaServlet)

El servlet `EliminarReservaServlet` permite:

- Eliminar una reserva específica de la lista
- Redirigir al usuario de vuelta a la lista de reservas actualizada

## Validaciones y Manejo de Errores

El sistema implementa las siguientes validaciones:

- **Campos obligatorios**: Verifica que el nombre, fecha, espacio y duración no estén vacíos
- **Formato de duración**: Valida que la duración sea un número entero
- **Mensajes de error**: Muestra mensajes amigables al usuario en caso de errores

## Almacenamiento de Datos

Las reservas se almacenan en una **lista en memoria** (ArrayList) durante la ejecución de la aplicación. Esto significa que:

- Los datos se mantienen mientras Tomcat esté en ejecución
- Los datos se pierden cuando se reinicia Tomcat
- No se utiliza una base de datos real para simplificar el desarrollo

## Documentación del Código

El código incluye comentarios explicativos en las secciones principales:

- **Clase Reserva**: Define la estructura de una reserva
- **ReservaServlet**: Procesa las solicitudes POST para crear reservas
- **ListaReservasServlet**: Procesa las solicitudes GET para mostrar la lista
- **EliminarReservaServlet**: Procesa las solicitudes POST para eliminar reservas

## Pruebas Recomendadas

Para verificar que el sistema funciona correctamente, realiza las siguientes pruebas:

1. **Crear una reserva**: Completa el formulario y verifica que aparezca en la lista
2. **Ver lista de reservas**: Haz clic en "Ver todas las reservas" y verifica que se muestren correctamente
3. **Eliminar una reserva**: Haz clic en "Eliminar" y verifica que desaparezca de la lista
4. **Validación de errores**: Intenta enviar el formulario sin completar todos los campos

## Solución de Problemas

### La aplicación no se carga

- Verifica que Tomcat esté en ejecución
- Comprueba que el archivo WAR esté en la carpeta `webapps` de Tomcat
- Revisa los logs de Tomcat en `/opt/homebrew/opt/tomcat/11.0.18/libexec/logs/catalina.out`

### Las reservas no se guardan

- Asegúrate de que la aplicación esté compilada correctamente
- Verifica que los servlets estén correctamente mapeados
- Revisa la consola de Tomcat para mensajes de error

### Error de compilación

- Verifica que tengas Java 21 o superior instalado
- Comprueba que Maven esté correctamente instalado
- Ejecuta `mvn clean` antes de compilar nuevamente

## Notas Importantes

- Este proyecto utiliza **Jakarta Servlets** sin frameworks como Spring o Hibernate
- El almacenamiento es **en memoria**, no en una base de datos real
- El proyecto está optimizado para fines educativos y de evaluación
- Para producción, se recomienda implementar una base de datos real

## Autor

Proyecto desarrollado como parte de la evaluación parcial de Programación Web Backend por SANTIAGO RODRIGUEZ

