#!/bin/bash

# input
rm -f aa.out aa.bmp bb.bmp

src=$1;

echo $src

r $src > aa.out

succcnt=0
diff aa.out lab.out
if [[ $? == 0 ]];
then
	let "succcnt += 1"  # 카운터 증가.
fi

cmp aa.bmp lab002aa.bmp
if [[ $? == 0 ]];
then
	let "succcnt += 2"  # 카운터 증가.
fi

cmp bb.bmp lab002bb.bmp
if [[ $? == 0 ]];
then
	let "succcnt += 4"  # 카운터 증가.
fi


echo "Result: " $succcnt $src



