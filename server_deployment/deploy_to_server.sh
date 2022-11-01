cd ..

pwd
#Generating digest.txt file
export folder="$USERPROFILE\important jars"
#folder="/opt/jar\ files"
#echo $folder

appver=$(date +%Y.%m.%d).$(date +"%T")
appver=${appver//[:]/}
appver=${appver//[.]/}
echo this is the appversion : $appver

#mkdir "app/$appver"

#java -classpath "$folder\getdown-core-1.8.7.jar" com.threerings.getdown.tools.Digester "app/$appver"
java -classpath "$folder\getdown-core-1.8.7.jar" com.threerings.getdown.tools.Digester "app/beta"
#read varname