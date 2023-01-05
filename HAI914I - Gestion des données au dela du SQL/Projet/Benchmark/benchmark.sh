./init.sh


print_colorised "Running $qEngine tests : "


#   Test normaux en fesant varier les données et la ram
print_colorised "  Normal running"
for data in ${dataFiles[@]}; do
    print_colorised "    Running with $data :"
    for ramValue in ${ramValues[@]}; do
        print_colorised "      Running with $ramValue RAM :"

        d="$(basename -- $data)"
        q="$(basename -- $queries)"
        outputfile="$filename/qEngine-$ramValue-${d}_d-${q}_q.csv"
        
        
        command="java -Xmx$ramValue -jar $qEngine -data $data -queries $queries -output $outputfile"
        print_colorised "        $command"
        $command
        print_colorised "\n"
    done
done


print_colorised "  \n\n\nShuffeling queries"
for data in ${dataFiles[@]}; do
    print_colorised "  Running with $data :"
    for ramValue in ${ramValues[@]}; do
        print_colorised "  Running with $ramValue RAM :"

        d="$(basename -- $data)"
        q="$(basename -- $queries)"
        outputfile="$filename/qEngine-$ramValue-${d}_d-${q}_q-SHUFFLE.csv"
        
        
        command="java -Xmx$ramValue -jar $qEngine -data $data -queries $queries -shuffle -output $outputfile"
        print_colorised "  $command"
        $command
        print_colorised "\n"
    done
done





# Comparaison with Jena
echo -e "\n\nComparaison with Jena :  "
for ramValue in ${ramValues[@]}; do
    echo -e "Running with $ramValue RAM : \n"



    echo -e "\n\n"
done





print_colorised "\n\n\n[DONE] Résultats dans le fichier : $filename"