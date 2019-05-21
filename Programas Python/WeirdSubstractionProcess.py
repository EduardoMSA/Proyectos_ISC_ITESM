
# coding: utf-8

# In[21]:


def step1(a,b):
    if a==0 or b==0:
        return (a,b)
    else:
        return step2(a,b)
    
def step2(a,b):
    if a>=2*b:
        a=a-2*b
        return step1(a,b)
    else:
        return step3(a,b)

def step3(a,b):
    if b>=2*a:
        b=b-2*a
        return step1(a,b)
    else:
        return (a,b)

def wsp(a,b):
    result = step1(a,b)
    print(str(result[0]) + " " + str(result[1]))
    
    
a = input()
b = a.split()
wsp(int(b[0]),int(b[1]))


    

