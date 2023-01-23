# Ащеулов Антон Зит-22 22-123 вариант 3
from random import randint
 
a = [[randint(5, 50) for i in range(4)] for j in range(5)]
for row in a:
    print(*map('{:2d}'.format, row))
print()
 
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
for row in a:
    print(*map('{:2d}'.format, row))