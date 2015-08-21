import play.routes.compiler.InjectedRoutesGenerator
import play.sbt.PlayScala
import play.twirl.sbt.Import.TwirlKeys

name := """csr-ticketing-system"""

version := "1.0-SNAPSHOT"

lazy val root = (project in file(".")).enablePlugins(PlayScala)

scalaVersion := "2.11.6"

libraryDependencies ++= Seq(jdbc, cache, ws, evolutions, specs2 % Test)

libraryDependencies ++= Seq(
  "com.typesafe.play" %% "anorm" 				    % "2.4.0",
  "org.webjars"       %% "webjars-play"     % "2.4.0-1",
  "org.webjars.bower" %  "adminlte"         % "2.2.0",
  "org.webjars"       %  "font-awesome"     % "4.3.0-2"
)

resolvers += "scalaz-bintray" at "http://dl.bintray.com/scalaz/releases"

// Play provides two styles of routers, one expects its actions to be injected, the
// other, legacy style, accesses its actions statically.
routesGenerator := InjectedRoutesGenerator

TwirlKeys.templateImports += "models._"
