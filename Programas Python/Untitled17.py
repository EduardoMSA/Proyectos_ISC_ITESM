
# coding: utf-8

# In[36]:


from fractions import Fraction

def sumFractions(a1,a2,b1,b2,c1,c2):
    a = a1 * b2 * c2
    b = b1 * a2 * c2
    c = c1 * a2 * b2
    num = a+b+c
    den = a2*b2*c2
    return Fraction(num,den)

def abc(a,b,c):
    f1  = a.split("/")
    f2  = b.split("/")
    f3  = c.split("/")
    fraccion = sumFractions(int(f1[0]),int(f1[1]),int(f2[0]),int(f2[1]),int(f3[0]),int(f3[1]))
    print(str(fraccion.numerator) + "/" + str(fraccion.denominator))
    
n = int(input())
for i in range(n):
    a = input().split()
    abc(a[0],a[1],a[2])
    
    

