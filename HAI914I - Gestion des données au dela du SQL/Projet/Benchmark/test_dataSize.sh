source init.sh

ramValue=${ramValues[1]}

mkdir doesDataMatter

print_colorised "Running $qEngine : "

for data in ${dataFiles[@]}; do
    START=$(date +%s.%N)

    for nb in {1..5}; do
        command="java -Xmx$ramValue -jar $qEngine -data $data -queries $queries"
        print_colorised "  $command"

        $command >>  doesDataMatter/logs.txt 2>&1
        
    done

    END=$(date +%s.%N)
    DIFF=$(echo "$END - $START" | bc)
    echo "$data, $DIFF, 5" >> doesDataMatter/results.txt
done