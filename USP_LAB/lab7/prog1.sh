read -p "Enter file name:" fname

s=`tr -cd "[aeiouAEIOU]"<$fname | wc -c`
echo $s
