#!/bin/bash

# Очистка проекта Maven и установка зависимостей
mvn clean install dependency:copy-dependencies

# Создание пользовательского образа JRE с jlink
jlink --add-modules java.base,java.desktop,java.instrument,java.management,java.net.http,java.prefs,java.rmi,java.scripting,java.security.jgss,java.security.sasl,java.sql.rowset,jdk.compiler,jdk.jfr,jdk.unsupported --strip-debug --no-man-pages --no-header-files --compress=2 --output javaruntime

# Создание директории для сборки приложения и переход в неё
mkdir -p build-app && cd build-app

# Извлечение слоев приложения из JAR-файла
java -Djarmode=layertools -jar ../target/TestHub-0.0.1-SNAPSHOT.jar extract

## Запуск Docker Compose для поднятия контейнеров
#docker-compose up -d
