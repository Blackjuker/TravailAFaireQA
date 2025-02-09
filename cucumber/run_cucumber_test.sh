#!/bin/bash

echo "Running Maven tests..."
mvn test -Dbrowser="chrome" -D cucumber.plugin="html:target/rapport.html"

# Pause équivalente à Windows (appuyer sur une touche pour continuer)
read -p "Press any key to continue..."
