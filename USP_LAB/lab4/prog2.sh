# !bin/sh

#Sum of even numbers upto N

read -p "Enter a number:" num
sum=0
i=2
while [ $i -le $num ]
do
sum=`expr $sum + $i`
i=`expr $i + 2`
done

echo $sum 
