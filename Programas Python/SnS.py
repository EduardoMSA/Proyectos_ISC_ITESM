
# coding: utf-8

# In[ ]:


def sns(n,m):
    a=[0]*100005
    b=[0]*100005
    result=[]
    c=[False]*100005
    vn = input()
    vn = vn.split()
    vn = list(map(int,vn))
    for i in range(1,n+1):
        a[i]=vn[i-1]
    for i in range(n,0,-1):
        if not c[a[i]]:
            b[i]+=1
        c[a[i]]=True
    for i in range(n,0,-1):
        b[i]+=b[i+1]
    for i in range(m):
        result.append(b[int(input())])
    for i in result:
        print(i)
a = input()
b = a.split()
sns(int(b[0]),int(b[1]))


    
    

