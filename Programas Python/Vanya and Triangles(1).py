
# coding: utf-8

# In[18]:


def getArea(puntos):
    a = 0
    for i in range(len(puntos)):
        a+= (puntos[i][0]*puntos[(i+1)%len(puntos)][1])-(puntos[(i+1)%len(puntos)][0]*puntos[i][1])
    return a/2

n = int(input())
puntos=[]
for i in range(n):
    a = input()
    b = list(map(int,a.split()))
    puntos.append(b)
posibles = []
cuenta = 0
for i in range(len(puntos)):
    for j in range(i+1,len(puntos)):
        for k in range(j+1, len(puntos)):
            tmp = [puntos[i],puntos[j],puntos[k]]
            if (tmp[0][0]==tmp[1][0] and tmp[0][0]==tmp[2][0]) or (tmp[0][1]==tmp[1][1] and tmp[0][1]==tmp[2][1]):
                continue
            posibles.append(tmp)
            if getArea(tmp)!=0:
                cuenta+=1

print(cuenta)

            
    

