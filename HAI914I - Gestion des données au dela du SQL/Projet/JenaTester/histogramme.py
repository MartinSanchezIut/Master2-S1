import csv
import array as arr
result = []

r0 = 0
r125 = 0
r2550 = 0
r50p = 0

with open('nbResults_500K.csv', newline='') as csvfile:
    spamreader = csv.reader(csvfile, delimiter=',', quotechar='|')
    compteur = 0
    for row in spamreader:
        if int(row[0]) == 0:
            r0 = int(row[1])

        if int(row[0]) > 0 and int(row[0]) < 25:
            r125 += int(row[1]) 

        if int(row[0]) > 25 and int(row[0]) < 50:
            r2550 += int(row[1]) 

        if int(row[0]) > 50:
            r50p += int(row[1]) 

print("0," + str(r0))
print("1:25," + str(r125))
print("25:50," + str(r2550))
print(":50,"+str(r50p))
