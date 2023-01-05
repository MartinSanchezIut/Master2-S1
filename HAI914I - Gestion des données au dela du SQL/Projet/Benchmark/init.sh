#                             Variables 
# Jars
Jena="Jars/Jena.jar"
qEngine="Jars/qEngine.jar"

# JVM Ram
ramValues=("2g" "4g");

# Data and queries files
dataFiles=("data/2M.nt" "data/500K.nt");
queries="queries/3K.queryset"

# Print method
print_colorised() { 
    RED='\033[0;36m'
    NC='\033[0m' # No Color
    echo -e "$RED $1 $NC"
}

# Folder name
now=`date +"%d-%m-%Y@%H:%M:%S"`
filename="results/$now"
#mkdir $filename