# Ащеулов Антон Зит-22 22-123 вариант 3
from random import randint

a = []
with open("asheulovanton_zit22_vvod2.txt", "r") as input_file:
    for i in input_file:
        a.append(list(map(int, i.split())))
max_elem = a[0][0]
ie = je = 0
for i in range(len(a)):
    for j in range(len(a[0])):
        if a[i][j] > max_elem:
            max_elem = a[i][j]
            ie = i
            je = j
a[0], a[ie] = a[ie], a[0]
a[0][0], a[0][je] = a[0][je], a[0][0]


with open("asheulovanton_zit22_vivod2.txt", "w") as output_file:
    for row in a:
        for elem in row:
            output_file.write(str(elem) + " ")
        output_file.write('\n')