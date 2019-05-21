
# coding: utf-8

# In[26]:


def gcd(n1, n2):
    if n2 == 0:
        return int(n1)
    else:
        return gcd(n2, n1%n2)

def unusualSeq(n1, n2):
    result = gcd(n1,n2)
    if result == 1:
        print(0)
    else:
        print(result)

a = input()
b = a.split()
unusualSeq(int(b[0]),int(b[1]))
    
        

