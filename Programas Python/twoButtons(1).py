
# coding: utf-8

# In[15]:


def twoButtons(n,m):
    cuenta = 0
    while n<m:
        distanciaR = abs(((n-1)*2)-m)
        distanciaM = abs(n*2-m)
        if distanciaR<distanciaM:
            n-=1
        else:
            n*=2
        cuenta+=1
    cuenta+=(n-m)
    
    
    return cuenta

a = list(map(int,input().split()))
print(twoButtons(a[0],a[1]))

