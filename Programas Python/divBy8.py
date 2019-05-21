
# coding: utf-8

# In[10]:


def divBy8(num):
    for i in range (len(num)):
        if num[i]=='8' or num[i]=='0':
            return ("YES",num[i])
        for j in range(i+1,len(num)):
            a = int(num[i]) * 10 + int(num[j])
            if a%8 == 0:
                return ("YES",a)
            for k in range(j+1,len(num)):
                b = int(num[i])*100 + int(num[j]) * 10 + int(num[k]);
                if b%8==0:
                    return ("YES",b)
                
    return ("NO")
a = input()
b = divBy8(a)
for i in b:
    print(i)

