#! /bin/sh

#Script to find the area of a circle

read -p "Enter the radius:" r

area=`echo 3.141 \* $r \* $r|bc`

echo "Area of circle is: $area"
