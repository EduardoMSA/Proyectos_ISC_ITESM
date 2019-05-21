
# coding: utf-8

# In[11]:


def aSum(n,a,b,k):
    sum = 0
    values = [None]*k
    signos = input()
    for i in range(k):
        valor = 0
        if(signos[i%len(signos)]=="+"):
            valor = 1
        else:
            valor = -1
        values[i] = valor
    for i in range(n+1):
        sum+= values[i%k]*pow(a,n-i)*pow(b,i)
    sum%=pow(10,9)+9
    print(sum)

a = input()
b = a.split()
aSum(int(b[0]),int(b[1]),int(b[2]),int(b[3]))
    
    

