
# coding: utf-8

# In[346]:


import random


# In[347]:


#maximo comun divisor
def gcd(a,b):
    while(b != 0):
        tmp = a%b
        a = b
        b = tmp
    return a

#Inverso Modular
def modInv(a,b):
    for i in range(1,b):
        if (a*i)%b == 1:
            return i
    return None


# In[348]:


#Se obtienen la llave publica y ls privada
class keys:
    def __init__(self,p,q):
        self.p = p #Numero primo
        self.q = q #Numero primo diferente a p
        self.n = p*q
        self.phi = (self.p-1)*(self.q-1)
        self.e = self.getE2()
        #self.e = self.getE()
        self.d = modInv(self.e,self.phi) #Llave privada
        self.pK = (self.n,self.e) #Llave publica
    
    #Obtiene el primer valor entre 2 y phi que no es factor de n
    def getE(self):
        for x in range(2, self.phi):
            if gcd(self.phi, x) == 1 and modInv(x,self.phi) != None:
                return x
    
    #Obtiene un valor aleatorio entre 2 y Phi que no es factor de n
    def getE2(self):
        #Se obtiene una lista con todos los numeros coprimos a phi
        l = []
        for x in range(2, self.phi):
            if gcd(self.phi, x) == 1 and modInv(x,self.phi) != None:
                l.append(x)
        for x in l:
            if x == modInv(x,self.phi):
                l.remove(x)
        #Se selecciona un numero aleatorio dentro de la lista de coprimos
        return l[random.randint(0,len(l)-1)]


# In[349]:


#Decripta el mensaje
class decryptor:
    def __init__(self,privateKey,publicKey,c): #Necesita tanto la llave pribada como la publica
        self.d = privateKey
        self.pK = publicKey
        self.c = c
        tmp = self.decryption()
        self.message = ""
        for i in tmp:
            self.message+=str(chr(i))
        
    def decryption(self):
        tmp = self.c.copy()
        for i in range(len(tmp)):
            #print(str(tmp[i])+"^"+str(self.d)+" mod "+str(self.pK[0]))
            tmp[i] = (tmp[i]**self.d)%self.pK[0]
        return tmp
            
        
        
        


# In[350]:


class encryptor:
    def __init__(self,publicKey,message): #Encripta un mensaje con la llave publica
        self.pK = publicKey
        self.message = []
        for c in message:
            self.message.append(ord(c))
        self.c = self.encryption()
        
    def encryption(self):
        tmp = self.message.copy()
        for i in range(len(tmp)):
            #print(str(tmp[i])+"^"+str(self.pK[1])+" mod "+str(self.pK[0]))
            tmp[i] = (tmp[i]**self.pK[1])%self.pK[0]
        return tmp
                
        


# In[351]:


p = 53
q = 59
k = keys(p,q)


# In[352]:



m = input()
e = encryptor(k.pK,m)
d = decryptor(k.d,k.pK,e.c)
print("-------------------------------------------------------")
print("\nNumeros primos utilizados: " + str(p) + " y " + str(q))
print("\nLlave pública = " + str(k.pK))
print("Llave privada = " + str(k.d))
s = ""
for i in e.c:
    s+=str(chr(i))
print("\nMensaje encriptado = " + s)
print("\nMensaje decriptado = " + d.message)

