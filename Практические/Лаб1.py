Y=[0, 1, 2, 3, 4, 5, 6, 7]; # Лабораторная работа 1. Ащеулов Антон Вариант 3 (зачетка 22-213)
 
print(sum(x for i,x in enumerate(Y) if i % 2 == 1)) # Задание №1
print([2*x if x < 15 else x for x in Y]) # Задание №2