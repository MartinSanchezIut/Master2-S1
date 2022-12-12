mkdir ./FlyingComp
mkdir ./FlyingComp/Lattice
java -jar /home/e20180002097/fca4j-cli-0.4.3.jar LATTICE FlyingComp.csv -i CSV -s SEMICOLON -g FlyingComp/Lattice/FlyingComp.dot
dot -Tpdf FlyingComp/Lattice/FlyingComp.dot -o FlyingComp/Lattice/FlyingComp.pdf
mkdir ./FlyingComp/Iceberg50
java -jar /home/e20180002097/fca4j-cli-0.4.3.jar LATTICE -a ICEBERG FlyingComp.csv -p 50 -i CSV -s SEMICOLON -g FlyingComp/Iceberg50/FlyingCompiceberg.dot
dot -Tpdf FlyingComp/Iceberg50/FlyingCompiceberg.dot -o FlyingComp/Iceberg50/FlyingCompiceberg50.pdf
mkdir ./FlyingComp/AOCposet
java -jar /home/e20180002097/fca4j-cli-0.4.3.jar AOCPOSET FlyingComp.csv -i CSV -s SEMICOLON -g FlyingComp/AOCposet/FlyingCompaocposet.dot
dot -Tpdf FlyingComp/AOCposet/FlyingCompaocposet.dot -o FlyingComp/AOCposet/AOCposet.pdf