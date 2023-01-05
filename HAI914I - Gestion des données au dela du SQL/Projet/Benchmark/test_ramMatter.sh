source init.sh

data=${dataFiles[0]}

mkdir doesRamMatter

print_colorised "Running $qEngine : "

for ramValue in ${ramValues[@]}; do
    START=$(date +%s.%N)

    for nb in {1..5}; do
        command="java -Xmx$ramValue -jar $qEngine -data $data -queries $queries"
        print_colorised "  $command"

        $command >> doesRamMatter/logs.txt 2>&1
        
    done

    END=$(date +%s.%N)
    DIFF=$(echo "$END - $START" | bc)
    echo "$ramValue, $DIFF, 5" >> doesRamMatter/results.txt
done