name := "avro-java"

javaSource in Compile := baseDirectory.value

libraryDependencies ++= Seq(
   "org.apache.avro" % "avro" % "1.8.1"
)
