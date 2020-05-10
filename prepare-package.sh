#!/bin/sh

mvn clean install -DskipTests
mkdir -p /tmp/app/
cd ./target
files=(*.jar)
cd ..
cp target/*.jar /tmp/app/
cp deployment/etc/* /tmp/app/
echo "#!/bin/sh\n\njava -jar ${files[0]}" > /tmp/app/run.sh

zip -r -j spring-boot-deployment.zip /tmp/app/*.*
