
# coding: utf-8

# In[61]:



#Complejidad constante
def primerValor(lista):
    return lista[0]

lista = [1,2,3]
print(primerValor(lista))


# In[18]:


#Complejidad n
def imprimeLista(lista):
    for element in lista:
        print(element)
    
lista = [1,2,3]
imprimeLista(lista)


# In[40]:


#Complejidad n/2
def completeness(lista):
    i = 0
    while (i < len(lista) / 2):
        if lista[i] == "(" and lista[len(lista)-1 -i] != ")":
            return False
        elif lista[i] == "[" and lista[len(lista)-1  -i] != "]":
            return False
        elif lista[i] == "{" and lista[len(lista)-1 -i] != "}":
            return False
        i = i + 1
    return True

lista = "[([)]"
print(completeness(lista))
        


# In[55]:


#Complejidad nlogn
def isAnagram(str1, str2):
    str1 = str1.replace(" ","")
    str2 = str2.replace(" ","")
    str1 = str1.lower()
    str2 = str2.lower()
    if len(str1) != len(str2):
        return False
    for character in str1:
        length = len(str2)
        for character2 in str2:
            if character == character2:
                str2 = str2.replace(character2,"",1)
                break
        if length == len(str2):
            return False
    return True

string1 = "holi"
string2 = "hola"
print(isAnagram(string1,string2))


# In[59]:


import time
import matplotlib.pyplot as plt

nums = [1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25,26,27,28,29,30]
Ej1 = dict()
Ej2 = dict()
Ej3 = dict()
Ej4 = dict()
Ej5 = dict()

#Ejercicio 1
def primerValor(num):
    start = time.time()
    print("Ejercicio 1")
    print(nums[0], "\n")
    end = time.time()
    Ej1[num] = end-start
    

#Ejercicio 2
def lista(num):
    start = time.time()
    print ("Ejercicio 2")
    for x in range(0, num):
        print(nums[x])
    print()
    end = time.time()
    Ej2[num] = end-start
    
#Ejercicio 3
def pares(num):
    start = time.time()
    print("Ejercicio 3")
    for x in range (0, num):
        for y in range(0, num):
            print(nums[x] , "," , nums[y])
    print()
    end = time.time()
    Ej3[num] = end-start

for x in range (0, 31):    
    primerValor(x)
    lista(x)
    pares(x)

print (Ej3[10])
        

#Ejercicio 4
#Complejidad n/2
def completeness(lista):
    i = 0
    while (i < len(lista) / 2):
        if lista[i] == "(" and lista[len(lista)-1 -i] != ")":
            return False
        elif lista[i] == "[" and lista[len(lista)-1  -i] != "]":
            return False
        elif lista[i] == "{" and lista[len(lista)-1 -i] != "}":
            return False
        i = i + 1
    return True

parentesis = "("

for x in range (0,30):
    if(x%2==1):
        parentesis = parentesis + ")"
    else:
        parentesis = "(" + parentesis
    
    start = time.time()
    completeness(parentesis)
    end = time.time()
    Ej4[x] = end - start 

#Ejercicio 5
#Complejidad nlogn
def isAnagram(str1, str2):
    str1 = str1.replace(" ","")
    str2 = str2.replace(" ","")
    str1 = str1.lower()
    str2 = str2.lower()
    if len(str1) != len(str2):
        return False
    for character in str1:
        length = len(str2)
        for character2 in str2:
            if character == character2:
                str2 = str2.replace(character2,"",1)
                break
        if length == len(str2):
            return False
    return True

