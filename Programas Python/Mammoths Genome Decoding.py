
# coding: utf-8

# In[26]:


def decoding(s):
    cuenta = [0]*4
    cuenta[0]=s.count("A")
    cuenta[1]=s.count("C")
    cuenta[2]=s.count("G")
    cuenta[3]=s.count("T")
    faltantesA = max(cuenta)-cuenta[0]
    faltantesC = max(cuenta)-cuenta[1]
    faltantesG = max(cuenta)-cuenta[2]
    faltantesT = max(cuenta)-cuenta[3]
    faltantesTotales = faltantesA + faltantesC + faltantesG + faltantesT
    incognitas = s.count("?")
    if(len(s)%4!=0 or faltantesTotales != incognitas):
        return "==="
    tmp1=s.replace("?","A",faltantesA)
    tmp2=tmp1.replace("?","C",faltantesC)
    tmp3=tmp2.replace("?","G",faltantesG)
    s=tmp3.replace("?","T",faltantesT)
    while s.count("?")!=0:
        tmp1=s.replace("?","A",1)
        tmp2=tmp1.replace("?","C",1)
        tmp3=tmp2.replace("?","G",1)
        s=tmp3.replace("?","T",1)
        
    return s
        
    
n = int(input())  
s = input()
print(decoding(s))
    

