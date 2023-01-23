# Ащеулов Антон Зит-22 22-123 Вариант 3
n=int(input('Укажите кол-во строк и столбцов в матрице - '))
a=[]
z=('')
for i in range(n):
    b=[]
    for j in range(n):
        print('Введите [',i,',',j,'] элемент')
        b.append(int(input()))
    a.append(b)
for i in range(n):
    for j in range(n):
        print(a[i][j], end = ' ')
    print()
for i in range(0, n-1):
    for j in range(i+1, n):
        if a[i][j] != a[j][i]:
            z=('False')
            break
if z != ('False'):
    print('Матрица симметрична')
else:
    print('Матрица несимметрична')