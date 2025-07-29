#!/bin/bash

echo "Setting up KMP Compose environment..."

# Check if Java is available
if command -v java &> /dev/null; then
    echo "Java version:"
    java -version
else
    echo "Java not found. Please install Java 17 or higher."
    echo "On Ubuntu/Debian: sudo apt install openjdk-17-jdk"
    echo "On macOS: brew install openjdk@17"
    echo "Or download from: https://adoptium.net/"
fi

# Check Gradle wrapper
if [ -f "./gradlew" ]; then
    echo "Making gradlew executable..."
    chmod +x ./gradlew
    
    echo "Gradle version:"
    ./gradlew --version
    
    echo "Building project..."
    ./gradlew composeApp:assembleDebug
else
    echo "Gradle wrapper not found!"
fi

echo "Setup complete!"
