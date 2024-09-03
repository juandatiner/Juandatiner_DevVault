n1= int(input("What is the first number? "))
n2= int(input("What is the second number? "))
n3= int(input("What is the third number? "))


minimum = min(n1,n2,n3) 

print("The maximum number is: "+ str(max(n1,n2,n3)))
print("The minimum number is: {}".format(min(n1,n2,n3)))


print("The maximum number between {}, {}, {} is: {}".format(n1,n2,n3,max(n1,n2,n3)))
print("The minimum number between {}, {}, {} is: {}".format(n1,n2,n3,minimum))