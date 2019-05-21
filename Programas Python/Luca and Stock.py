
# coding: utf-8

# In[10]:


n = int(input())
p = list(map(float,input().split()))
nq = int(input())
for i in range(nq):
    q = (input().split())
    if q[0] == '1':
        p[int(q[1])-1] = float(q[2])
    else:
        cuenta = p[int(q[1])-1]
        for i in range(int(q[1]),int(q[2])):
            cuenta*=p[i]
        if cuenta <2**100:
            print(cuenta)
        else:
            print("INFINITE!")
        
        
    

