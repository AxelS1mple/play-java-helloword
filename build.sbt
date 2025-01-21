name := """play-java-helloword"""
organization := "com.example"

version := "1.0-SNAPSHOT"

lazy val root = (project in file("."))
  .enablePlugins(PlayJava, JavaAppPackaging) // Se agregó JavaAppPackaging para empaquetar el proyecto
  .settings(
    scalaVersion := "2.13.16",

    // Configuración del puerto dinámico para Heroku
    javaOptions ++= Seq(
      "-Dhttp.port=" + sys.props.getOrElse("http.port", "8080"), // Puerto dinámico
      "-Dplay.http.secret.key=" + sys.props.getOrElse("SECRET_KEY", "changeme") // Clave secreta de Play
    )
  )

// Define la versión de Play Framework que usará el proyecto
val playVersion = "2.8.20"

libraryDependencies ++= Seq(
  guice, // Habilita la inyección de dependencias con Guice
  "com.typesafe.play" %% "play-java-forms" % playVersion, // Biblioteca para manejar formularios en Java
  "com.typesafe.play" %% "play-test" % playVersion % Test, // Dependencia para pruebas
  "org.scala-lang.modules" %% "scala-xml" % "1.3.1" // Resuelve el conflicto de versiones
)

// Forzar la versión correcta para conflictos de dependencias
dependencyOverrides += "org.scala-lang.modules" %% "scala-xml" % "1.3.1"

// Configura repositorios
resolvers ++= Seq(
  "Typesafe Releases" at "https://repo.typesafe.com/typesafe/releases/",
  "Maven Central" at "https://repo1.maven.org/maven2/"
)

// Cambia el nivel de error para conflictos a advertencia (opcional)
evictionErrorLevel := Level.Warn

// Agrega opciones comunes de compilación
scalacOptions ++= Seq("-deprecation", "-feature", "-unchecked", "-encoding", "utf8")
