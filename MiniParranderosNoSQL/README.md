# MiniParranderosNoSQL

Bienvenidos a la aplicación **MiniParranderosNoSQL**.

Este proyecto implementa una aplicación que conecta con MongoDB y permite realizar operaciones CRUD (Crear, Leer, Actualizar, Eliminar) en la colección de **Bares** y **Bebedores**, además de consultas avanzadas utilizando **pipelines de agregación** para resolver problemas complejos como la consulta de las **Top 3 bebidas más servidas en bares frecuentados por bebedores**.

## Tabla de Contenidos
1. [Conexión Inicial](#conexión-inicial)
2. [Implementación de Consultas CRUD](#implementación-de-consultas-crud)
3. [Consultas Avanzadas](#consultas-avanzadas)
4. [Tags del Proyecto](#tags-del-proyecto)

---

## Configuración

La conexión a MongoDB se define en el archivo `application.properties`, ubicado en la carpeta `src/main/resources` de la aplicación. Ahí se debe colocar el **connection string** para conectar con el cluster de MongoDB.

---

## Videos en Bloque Neon

Los videos relacionados con la configuración y funcionamiento de esta aplicación se encuentran en la ruta **Contenido/Proyecto/Recursos entrega 3**.

- **ConexiónInicial**: Explicación sobre cómo crear una cuenta de MongoDB, configurar un cluster, una base de datos y obtener el connection string.
- **ImplementacionConsultasCRUD**: Implementación de las operaciones CRUD para la colección de **Bares**, y uso de colecciones de Postman para testing.
- **ConsultasAvanzadas**: Implementación de un pipeline de agregación para obtener las Top 3 bebidas más servidas en bares frecuentados por bebedores.

---

### Conexión Inicial

En este video se muestra cómo:
1. Crear una cuenta en **MongoDB**.
2. Configurar un **cluster** y una **base de datos**.
3. Generar el **connection string** necesario para la conexión con la aplicación.
4. **Configurar la conexión** en el archivo `application.properties`.

#### Recomendación:
Para que la aplicación funcione sin problemas desde cualquier ubicación, se recomienda **permitir el acceso desde todas las direcciones IP** al cluster de MongoDB.

#### Pasos para habilitar el acceso a todas las IPs:
1. Ir a **MongoDB Atlas**.
2. Acceder a tu **cluster**.
3. En la sección de **Network Access**, hacer clic en "Add IP Address".
4. Seleccionar la opción "**Allow access from anywhere**" (0.0.0.0/0).
5. Guardar los cambios.

**Video**: 
- **ConexiónInicial**

---

### Implementación de Consultas CRUD

En este video se muestra cómo implementar las operaciones CRUD para la colección **Bares**. Aprenderás a:
1. Crear, leer, actualizar y eliminar bares.
2. Cómo estructurar el repositorio y controlador para manejar las operaciones.
3. Utilizar las **colecciones de Postman** para hacer pruebas.

#### Colecciones de Postman:
El archivo `MiniParranderosNoSQL.postman_collection.json` está ubicado en la **carpeta principal del repositorio**. Estas colecciones están listas para ser importadas en Postman y realizar pruebas de las operaciones definidas.

**Video**: 
- **ImplementacionConsultasCRUD**

---

### Consultas Avanzadas

Este video aborda cómo implementar un **pipeline de agregación** en MongoDB para resolver la siguiente consulta avanzada:

> **Consulta avanzada**: Top 3 bebidas que son más servidas en los bares, teniendo en cuenta solo aquellos bares frecuentados por bebedores y bebidas preferidas por esos bebedores.

#### Testing de la Consulta Avanzada:
La colección de Postman también ha sido actualizada para incluir las pruebas de la consulta avanzada. Se encuentra en la carpeta principal del repositorio bajo el nombre `MiniParranderosNoSQL.postman_collection.json`.

#### Documentación Adicional:
En la carpeta principal del repositorio, también encontrarás el archivo **ConsultaAvanzadaExplicación.pdf**, que contiene una explicación detallada del pipeline y los pasos para ejecutarlo en la aplicación.

**Video**: 
- **ConsultasAvanzadas**

---

## Tags del Proyecto

Para facilitar la navegación por las diferentes etapas del proyecto, hemos creado **tags** en el repositorio. Si deseas acceder directamente a una etapa específica, simplemente selecciona el tag correspondiente.

### Lista de Tags:
1. **ConexionInicial**: Si deseas ver la configuración inicial de la conexión a MongoDB.
2. **ImplementacionConsultasCRUD**: Aquí se encuentra la implementación del CRUD para la colección de **Bares**. También incluye las colecciones de Postman necesarias para probar estas operaciones.
3. **ConsultasAvanzadas**: Este tag incluye la implementación del CRUD para bares y bebedores, así como la consulta avanzada con las colecciones de Postman actualizadas y el PDF explicativo.
