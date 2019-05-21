
# coding: utf-8

# In[32]:


def sns(a,b):
    result= []
    for i in b:
        tmp = a[i-1:]
        tmp2 = []
        for x in tmp:
            if x not in tmp2:
                tmp2.append(x)
        result.append(len(tmp2))
    return result


a = input()
b = input()

lista1 = a.split()
lista2 = b.split()
lista2i = [int(i) for i in lista2]
lista3=[]
for i in range(int(lista1i[1])):
    lista3.append(int(input()))

for i in sns(lista2i,lista3):
    print(i)

    
    

