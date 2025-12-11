JUnit tests for the project

Files added:
- `test/UsersTest.java` — tests for the `Users` class
- `test/NetworkGraphTest.java` — tests for the `NetworkGraph` class

Running tests (PowerShell)

1) Download JUnit Platform Console Standalone JAR (one-off). From the repository root run:

```powershell
mkdir lib -ErrorAction SilentlyContinue; \
Invoke-WebRequest -Uri "https://repo1.maven.org/maven2/org/junit/platform/junit-platform-console-standalone/1.9.3/junit-platform-console-standalone-1.9.3.jar" -OutFile lib\junit-platform-console-standalone.jar
```

2) Compile sources and tests

```powershell
mkdir out; \
javac -d out -cp "lib\junit-platform-console-standalone.jar" *.java test\*.java
```

3) Run the tests with the console launcher

```powershell
java -jar lib\junit-platform-console-standalone.jar --class-path out --scan-classpath
```

Alternative: use Maven or Gradle and add JUnit Jupiter dependencies if you prefer an automated build.

Notes:
- Tests are written for JUnit Jupiter (JUnit 5). The `junit-platform-console-standalone` jar above contains the needed runtime.
- The project uses the default (no) package to match the existing source files.
