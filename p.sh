#!/bin/bash

echo "🚀 Generando estructura Spring Boot..."

BASE="src/main/java/com/todoapp/gestroproyecto"

mkdir -p $BASE/config
mkdir -p $BASE/controller
mkdir -p $BASE/entity
mkdir -p $BASE/enums
mkdir -p $BASE/exception
mkdir -p $BASE/repository
mkdir -p $BASE/service

touch $BASE/GestroproyectoApplication.java
touch $BASE/config/CorsConfig.java

touch $BASE/entity/Usuario.java
touch $BASE/entity/Proyecto.java
touch $BASE/entity/Tarea.java

touch $BASE/enums/Role.java
touch $BASE/enums/TaskStatus.java
touch $BASE/enums/ProjectStatus.java
touch $BASE/enums/Priority.java

touch $BASE/repository/UsuarioRepository.java
touch $BASE/repository/ProyectoRepository.java
touch $BASE/repository/TareaRepository.java

touch $BASE/service/UsuarioService.java
touch $BASE/service/ProyectoService.java
touch $BASE/service/TareaService.java

touch $BASE/controller/AuthController.java
touch $BASE/controller/UsuarioController.java
touch $BASE/controller/ProyectoController.java
touch $BASE/controller/TareaController.java

touch $BASE/exception/GlobalExceptionHandler.java

touch src/main/resources/application.properties
touch src/main/resources/static/css/style.css

echo "✔ Estructura creada correctamente"
