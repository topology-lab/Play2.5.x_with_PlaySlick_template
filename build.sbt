name := """nanicolle"""

version := "1.0-SNAPSHOT"

lazy val root = (project in file(".")).enablePlugins(PlayScala)

scalaVersion := "2.11.7"

libraryDependencies ++= Seq(
//  jdbc,
//  cache,
//  ws,
  "org.scalatestplus.play" %% "scalatestplus-play" % "1.5.0-RC1" % Test,

  evolutions,
  "com.typesafe.play" %% "play-slick" % "1.1.1",
  "com.typesafe.play" %% "play-slick-evolutions" % "1.1.1",
  "org.postgresql"  %  "postgresql"  %  "9.4.1208.jre7"
)

resolvers += "scalaz-bintray" at "http://dl.bintray.com/scalaz/releases"

EclipseKeys.preTasks := Seq(compile in Compile)
