
# coding: utf-8

# In[46]:


from collections import defaultdict
a = input().split()
direcciones = defaultdict(lambda: 0)
ejex = 0
ejey = 0
cuenta = 0
for i in range(int(a[0])):
    b = input().split()
    if int(a[1])==int(b[0]):
        ejex = 1
        continue
    if int(a[2])==int(b[1]):
        ejey = 1
        continue
    angle = (int(b[1])-int(a[2]))/(int(b[0])-int(a[1]))
    if direcciones[angle]!=1:
        cuenta+=1
        direcciones[angle]=1
print(cuenta + ejex + ejey)
    


# In[40]:


a = dict()
a[1.25] = 1
print(a[2.1])


# In[35]:




