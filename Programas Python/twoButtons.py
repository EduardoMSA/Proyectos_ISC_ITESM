
# coding: utf-8

# In[9]:


def twoButtons(m,n):
    cuenta = 0
    while(n!=m):
        cuenta+=1
        if n<m:
            n*=2
        else:
            n-=1
    return cuenta

a = list(map(int,input().split()))
print(twoButtons(a[0],a[1]))

