cd ..
pwd

#------
export folder="$USERPROFILE\important jars"
#export folder="/opt/jar\ files"
#echo $folder

#------appversion
appver=$(date +%Y.%m.%d).$(date +"%T")
appver=${appver//[:]/}
appver=${appver//[.]/}
echo this is the appversion : $appver

#------generating digest
java -classpath "$folder\getdown-core-1.8.7.jar" com.threerings.getdown.tools.Digester "app/beta"

#------copying contents to new version's directory
mkdir "app/$appver"
cp -r app/beta/* "app/$appver"


#------adding folder to git
git add app/$appver/*
git commit -m "added app version $appver"
git push
#read varname