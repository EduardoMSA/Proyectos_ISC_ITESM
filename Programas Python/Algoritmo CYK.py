
# coding: utf-8

# In[6]:



#Generadores
S = ["AB","SS","AC","BD"]
B = ["b"]
A = ["a"]
C = ["SB"]
D = ["SA"]

#Simbolos Terminales
T = {'a':"A",'b':"B"}

#Inicial
inicial = 'S'

#Gramatica
G = {'S':S,'B':B,'A':A,'C':C,'D':D}

def cyk(G,T,cadena):
    
    tabla = [None]*len(cadena)
    for i in range(len(tabla)):
        tabla[i] = [None]*(i+1)
    
    for i in range(len(cadena)):
        tabla[i][i]=[T[cadena[i]]]
    
    for j in range(1,len(tabla)):
        for i in range(j,len(tabla)):
            depth = len(tabla[i])-j-1
            tabla[i][depth] = str(i)+str(j)
            
            tmp1 = []
            for k in range(i):
                  if depth+1<=len(tabla[k]):
                        tmp1.append(tabla[k][depth])      
            tmp2 = tabla[i][1+depth:]
            tabla[i][depth] = verificar(tmp1,tmp2)
    
    resultado = tabla[-1][0]
    if inicial in resultado:
        print(True) #Cadena aceptada por gramatica
    else:
        print(False)
            
        
    
    return tabla
        
def verificar(x,y):
    tmp = []
    posibilidades = []
    
    
    for i in range(len(x)):
            for k in x[i]:
                for l in y[-i-1]:
                    tmp.append(k+l)
    
    for i in tmp:
        for g in G:
            if i in G[g] and g not in posibilidades:
                posibilidades.append(g)
                
    if len(posibilidades)==0:
        posibilidades.append('ø')
    
    return posibilidades

cadena = input()
a = cyk(G,T,cadena)

for row in a:
    print(' '.join(map(str,row)))

