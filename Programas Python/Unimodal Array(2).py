
# coding: utf-8

# In[48]:


def unimodal(a):
    i = a.index(max(a))
    incr = a[:i]
    decr = a[i:]
    m = 0
    while m<len(decr) and decr[m]==max(a):
        m+=1  
    const = decr[:m]
    decr = decr[m:]
    for n in range(len(incr)-1):
        if incr[n]>=incr[n+1]:
            return "NO"
    for n in range(len(decr)-1):
        if decr[n]<=decr[n+1]:
            return "NO"
    return "YES"


size = input()
a = input()
b = a.split()

print(unimodal(list(map(int,b))))

