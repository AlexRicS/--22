# Ащеулов Антон Зит-22 22-123 Вариант 3
a=[]
z=('')
with open("asheulovanton_zit22_vvod.txt", "r") as input_file:
    for i in input_file:
        a.append(list(map(int, i.split())))
n = len(a)
for i in range(0, n-1):
    for j in range(i+1, n):
        if a[i][j] != a[j][i]:
            z=('False')
            break

with open("asheulovanton_zit22_vivod.txt", "w") as output_file:
    for line in a:
        for elem in line:
            output_file.write(str(elem) + " ")
        output_file.write('\n')
    if z != ('False'):
        output_file.write('Матрица симметрична')
    else:
        output_file.write('Матрица несимметрична')
