#!/bin/bash

# Gradle tasks runner for KMP project
echo "Running KMP Compose project..."

# Check if Java is available
if command -v java >/dev/null 2>&1; then
    echo "Java found: $(java -version 2>&1 | head -1)"
else
    echo "Java not found. Trying to set up environment..."
    export JAVA_HOME=/usr/lib/jvm/default-java
    export PATH=/usr/lib/jvm/default-java/bin:$PATH
fi

# Make gradlew executable
if [ -f "gradlew" ]; then
    echo "Setting gradlew permissions..."
    # Try without chmod if not available
    sh gradlew --version
    
    if [ $? -eq 0 ]; then
        echo "Building KMP project..."
        sh gradlew composeApp:assembleDebug --info
    else
        echo "Gradle execution failed"
    fi
else
    echo "gradlew not found"
fi
