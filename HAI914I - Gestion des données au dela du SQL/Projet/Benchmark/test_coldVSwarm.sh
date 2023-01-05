source init.sh

data=${dataFiles[0]}
ramValue=${ramValues[1]}

timesProgramIsRunned=5
mkdir ColdvsWarm

print_colorised "Running $qEngine without warming up: $timesProgramIsRunned times"
for nb in {1..5}; do
    outputfile="ColdvsWarm/Cold/qEngineColdRun_$nb.csv"
    command="java -Xmx$ramValue -jar $qEngine -data $data -queries $queries -output $outputfile"
    print_colorised "  $command"
    $command >> ColdvsWarm/logs.txt 2>&1
done
print_colorised "\n"


print_colorised "Running $qEngine warmed with 200 queries: $timesProgramIsRunned times"
for nb in {1..5}; do
    outputfile="ColdvsWarm/Warm200/qEngineWarm200Run_$nb.csv"
    command="java -Xmx$ramValue -jar $qEngine -data $data -queries $queries -warm 200 -output $outputfile"
    print_colorised "  $command"
    $command >> ColdvsWarm/logs.txt 2>&1
done
print_colorised "\n"


print_colorised "Running $qEngine warmed with 500 queries: $timesProgramIsRunned times"
for nb in {1..5}; do
    outputfile="ColdvsWarm/Warm500/qEngineWarm500Run_$nb.csv"
    command="java -Xmx$ramValue -jar $qEngine -data $data -queries $queries -warm 500 -output $outputfile"
    print_colorised "  $command"
    $command >> ColdvsWarm/logs.txt 2>&1
done
print_colorised "\n"


print_colorised "Running $qEngine warmed with 1000 queries: $timesProgramIsRunned times"
for nb in {1..5}; do
    outputfile="ColdvsWarm/Warm1000/qEngineWarm1000Run_$nb.csv"
    command="java -Xmx$ramValue -jar $qEngine -data $data -queries $queries -warm 1000 -output $outputfile"
    print_colorised "  $command"
    $command >> ColdvsWarm/logs.txt 2>&1
done
print_colorised "\n"