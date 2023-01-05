source init.sh

data=${dataFiles[0]}
ramValue=${ramValues[1]}

mkdir qEnginevsjena

print_colorised "Running $qEngine : "

qEngineTime=0
for nb in {1..5}; do
    command="java -Xmx$ramValue -jar $qEngine -data $data -queries $queries"
    print_colorised "  $command"

    START=$(date +%s.%N)
    $command >> qEnginevsjena/logsqEngine.txt 2>&1
    END=$(date +%s.%N)
    
    DIFF=$(echo "$END - $START" | bc)
    #qEngineTime=$( ($qEngineTime + $DIFF) )
    qEngineTime=$(echo "$qEngineTime + $DIFF" | bc)

done



print_colorised "Running $Jena : "
JenaTime=0
for nb in {1..5}; do
    command="java -Xmx$ramValue -jar $Jena -data $data -queries $queries"
    print_colorised "  $command"

    START=$(date +%s.%N)
    $command >> qEnginevsjena/logsJena.txt 2>&1
    END=$(date +%s.%N)

    DIFF=$(echo "$END - $START" | bc)
    JenaTime=$(echo "$JenaTime + $DIFF" | bc)
    #JenaTime=$( ($JenaTime + $DIFF) )
done
echo "qEngineTime, JenaTime" >> qEnginevsjena/results.txt
echo "$qEngineTime, $JenaTime" >> qEnginevsjena/results.txt