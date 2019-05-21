
# coding: utf-8

# In[ ]:


def wsp(a,b):
    while(True):
        if a==0 or b==0:
            break
        elif a>=2*b:
            a = a%2b
        elif b>=2*a:
            b = b%2*a
        else:
            break
    print(str(a) + " " + str(b))
    
    
a = input()
b = a.split()
wsp(int(b[0]),int(b[1]))


    

