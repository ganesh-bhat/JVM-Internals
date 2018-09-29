# JVM-Internals

# Java Benchmarking


How to create benchmarking project

```bash
mvn archetype:generate -DinteractiveMode=false -DarchetypeGroupId=org.openjdk.jmh -DarchetypeArtifactId=jmh-java-benchmark-archetype -DgroupId=com.benchmark.learning -DartifactId=benchmark_jmh
```

Compile project

```bash
mvn clean install
```

Run the project for a specific class file

```bash
java -jar target/benchmarks.jar <target classname>
```

Understanding different options

Look here for details  - https://github.com/ganesh-bhat/Site/tree/master/jmh-samples/src/main/java/org/openjdk/jmh/samples



