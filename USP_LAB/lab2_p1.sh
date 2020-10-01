#! /bin/sh

#Write a shell Program to accept a filename from the 
#User and display the attributes,contents and word count of the 
#file.

read -p 'Enter file name' fname

echo 'The contents of the file are:'
cat $fname
echo '\n'

echo 'Word count of the given file is:'
wc -w $fname
echo '\n'

echo 'Attributes or stats of a file are:'
stat $fname
echo '\n'

#Perform copy,rename  operation by accepting two filenames from the user

read -p 'Enter two file names:' fname1 fname2

echo 'Copying file 1 to file 2...'
cp $fname1 $fname2

echo '\n'
read -p 'Enter a file name to rename and the newname:' oldname newname

cp $oldname $newname
rm $oldname

