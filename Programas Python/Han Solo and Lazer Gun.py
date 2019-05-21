
# coding: utf-8

# In[31]:


import math
def getAngle(x0,y0,x,y):
    return math.atan2(y-y0,x-x0)
a = input().split()
direcciones = set()
for i in range(int(a[0])):
    b = input().split()
    angle = getAngle(int(a[1]),int(a[2]),int(b[0]),int(b[1]))
    if angle<0:
        angle+=math.pi
    if angle not in direcciones:
        direcciones.update([angle])
print(len(direcciones))
    

