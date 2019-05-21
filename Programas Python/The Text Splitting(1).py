
# coding: utf-8

# In[15]:


def textSplitting(n,p,q,s):
    size = n
    cuenta = 0
    while size>=0:
        if size%p == 0:
            break
        cuenta+=1
        size-=q
        
    if size<0:
        print(-1)
        return

    cuenta2 = size//p
    print(cuenta + cuenta2)
    
    indx = 0
    for i in range(cuenta2):
        print(s[indx:indx+p])
        indx+=p
    for i in range(cuenta):
        print(s[indx:indx+q])
        indx+=q
    return
    


a = input().split()
n = int(a[0])
p = int(a[1])
q = int(a[2])
s = input()

textSplitting(n,p,q,s)

        


