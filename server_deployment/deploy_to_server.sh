cd ..

#making package
#rm -rf out/final_package/MazeApp_linux/*
#rm -rf out/final_package/MazeApp_windows/*
#java -jar "/opt/jar files/packr-all-4.0.0.jar" packaging/packr-config.json

pwd
#Generating digest.txt file
java -classpath /opt/jar\ files/getdown-core-1.8.7.jar com.threerings.getdown.tools.Digester app/beta
