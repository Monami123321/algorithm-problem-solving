from decimal import Decimal, getcontext
getcontext().prec = 300
n = 1 << int(input())
a = Decimal("1")
print(format(a/n,'f'))