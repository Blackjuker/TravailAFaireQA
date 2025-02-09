@echo off
echo Running Maven tests...
mvn test -Dbrowser="chrome" -D cucumber.plugin="html:target/rapport.html"
pause
