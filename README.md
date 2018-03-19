# java-lessons
 
Пришло время окончательно осознать, что же такое прогрммаривание
и как оно сделают жизнь лучше.  
Разберемся с парой инструментов которые сделают 
процесс интерактивнее и удобнее: Git и Maven(и пару слов про тесты).
 
Для начала maven - инструмент призванный упростить проесс 
управления жизненным циклом проекта и его зависимостями. 
Сам по себе maven это отдельное приложение, 
которое надо поставить себе на компьютер, выполнить пару простых 
настроек и забыть об этом.
Вся остальная движуха происходит внутри проекта, 
который теперь можно гордо именовать Maven-проект и центр 
этого движа - pom.xml. Pom от Project Object Model. 
POM like a GOD - знает о проекте все, управляет всем: 
от имени и версии проекта, до процесса его сборки.

Разберем простой конфиг, достаточный, чтобы сборать 
проект и прогнать для него тесты.

```xml
<?xml version="1.0" encoding="UTF-8"?>
<project xmlns="http://maven.apache.org/POM/4.0.0" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
         xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd">
    <modelVersion>4.0.0</modelVersion>

    <groupId>java.edu</groupId>
    <artifactId>lessons</artifactId>
    <version>0.0.1-SNAPSHOT</version>

    <properties>
        <project.build.sourceEncoding>UTF-8</project.build.sourceEncoding>
        <java.version>1.8</java.version>
    </properties>
    
    <build>
            <plugins>
                <plugin>
                    <groupId>org.apache.maven.plugins</groupId>
                    <artifactId>maven-compiler-plugin</artifactId>
                    <version>3.1</version>
                    <configuration>
                        <source>${java.version}</source>
                        <target>${java.version}</target>
                    </configuration>
                </plugin>
            </plugins>
        </build>
    
        <dependencies>
            <dependency>
                <groupId>junit</groupId>
                <artifactId>junit</artifactId>
                <version>4.11</version>
                <scope>test</scope>
            </dependency>
    </dependencies>

</project>

```
* \<groupId>, \<artifactId>, \<version> - обязательные теги в конфигурации,
задающие группу проекта, его уникальные идентификатор и текущую версию.
* Внутри \<build> лежит информация о сборке, можно указывать откуда брать исходные
файлы, откуда брать ресурсные файлы, какие плагины отработают. 
*maven-compiler-plugin*  - плагин, который выолпнит компиляцию исходного кода.
* Внутри \<dependencies> подключаются все зависимости, которые нужны
для проекта, но которых нет в стандартной библиотеке. При первой сборке проекта
эти зависимости будут автоматически выкачены из удаленного репозитория.

## Пару слов о Maven-командах
validate, compile, test, package, verify, install, deploy - фазы
жизненного цикла дефолтного maven-проекта, а также команды для выполнения
этого цикла. При сборке они выполняются
последовательно, поэтому запустив сборку командой:
```text 
mvn install
```
последовательно будет выполнено: validate, compile, test, package, verify, install.

Сейчас интересна фаза package, с остальными познакомимся позже.
 В ходе выполнения package-команды, код будет скомпилирован, пробегут тесты
и все будет упаковано в jar-архив.
 Кроме package, сейчас, стоить узнать еще о clean, которая очистит
target-директорию от результатов предыдущей сборки.
 Поэтому запускать сборку лучше так:
```text 
mvn clean install
```
*target-директория, место куда складываются результаты сборки проекта,
 по-умолчанию: project_name/target* 
 
*mvn - команда для запуска maven*

## Установка Maven

1. Скачать Binary zip archive и распаковать- [Download maven](https://maven.apache.org/download.cgi)
2. В командной строке от имени администратора выполнить:
```text
setx PATH "%PATH%;path_to_maven\bin"
```
3. Перезапустить командную строку и командой
```text
mvn -v
```
проверить, что все установилось.

---
[Maven documents](https://maven.apache.org/what-is-maven.html)

---

Теперь на очереди Git. Если в двух словах - система управления версиями(VCS - Version Control System).
