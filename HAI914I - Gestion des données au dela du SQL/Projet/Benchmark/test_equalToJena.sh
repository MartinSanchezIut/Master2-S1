source init.sh

dataFolder="data/"
queriesFolder="queries/"
ramValue=${ramValues[1]}

mkdir JenaValidation

print_colorised "Running $qEngine with Jena validation: "

for data in ${dataFolder}*.nt; do
    for queries in ${queriesFolder}*.queryset; do
        command="java -Xmx$ramValue -jar $qEngine -data $data -queries $queries -Jena"
        print_colorised "  $command"

        d="$(basename -- $data)"
        q="$(basename -- $queries)"
        $command >> JenaValidation/logs_${d}d${q}q.txt 2>&1
    done
done