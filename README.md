# FlywayDataDumperPlugin
This plugin is designed for Flyway.

If you use Flyway + Spring Boot and want to transfer data from your database, you can connect this plugin.

<b>Steps to</b>:
<h3>1. Connect classgraph into you build.gradle | pom.xml</h3>
<code>
	implementation("org.reflections:reflections:0.9.12")
</code>
<h3>2. Add </h3>
<code>
@FlywayDataDumpable(RunType = RunEnumerationTypes.DEVELOPMENT) 
</code>
<h3>annotation to your entry point class of application, which contains the </h3>
<code>
    public static void main(String[] args) {
        SpringApplication.run("your class name".class, args);
      }
</code>


<h3>3. Run your application and checkout </h3>
<code>
   ../resources/db/migration
</code>
<h3>folder. That will contains new .sql files with insert into sql instructions</h3>
<h2>When you compile your project you should switch: </h2>
<code>
  @FlywayDataDumpable(RunType = RunEnumerationTypes.DEVELOPMENT) 
</code>
<h2>TO:</h2>
<code>
  @FlywayDataDumpable(RunType = RunEnumerationTypes.PRODUCTION) 
</code>
