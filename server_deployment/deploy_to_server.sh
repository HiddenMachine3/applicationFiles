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

#------write app version into getdown.txt
sed '1d' app/beta/getdown.txt > tmpFile___.txt
echo -e "version = $appver\n$(cat tmpFile___.txt)" > tmpFile___.txt
cat tmpFile___.txt > app/beta/getdown.txt


------generating digest
java -classpath "$folder\getdown-core-1.8.7.jar" com.threerings.getdown.tools.Digester "app/beta"

#------copying contents to new version's directory
mkdir "app/$appver"
cp -r app/beta/* "app/$appver"


#------adding folder to git
git add app/$appver/*
git commit -m "added app version $appver"
git push
read varname