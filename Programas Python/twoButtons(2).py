
# coding: utf-8

# In[26]:


def twoButtons(n,m):
    cuenta = 0
    if n>m:
        return n-m
    while n<m:
        if m%2 == 0:
            m//=2
        else:
            m+=1
        cuenta+=1
    return abs(cuenta + n -m)

a = list(map(int,input().split()))
print(twoButtons(a[0],a[1]))

